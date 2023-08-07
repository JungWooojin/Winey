package com.team.winey.admin;

import com.team.winey.admin.model.*;
import com.team.winey.utils.MyFileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class AdminService {

    private final AdminMapper MAPPER;
    private final String FILE_DIR;

    @Autowired
    public AdminService(AdminMapper MAPPER, @Value("${file.dir}") String FILE_DIR) {
        this.MAPPER = MAPPER;
        this.FILE_DIR = MyFileUtils.getAbsolutePath(FILE_DIR);
    }

    public int postProduct(MultipartFile pic, ProductInsParam param) {
        ProductInsDto dto = new ProductInsDto();

        ProductAromaDto aromaDto = new ProductAromaDto(param.getAroma()); //t_aroma

        dto.setSweety(param.getSweety()); //t_feature
        dto.setAcidity(param.getAcidity()); //t_feature
        dto.setBody(param.getBody()); //t_feature

        dto.setCategoryId(param.getCategory()); //t_product
        dto.setCountryId(param.getCountry()); //t_product

        dto.setNmKor(param.getNmKor()); //t_product
        dto.setNmEng(param.getNmEng()); //t_product
        dto.setPrice(param.getPrice()); //t_product
        dto.setPromotion(param.getPromotion()); //t_product
        dto.setBeginner(param.getBeginner()); //t_product
        dto.setAlcohol(param.getAlcohol()); //t_product
        dto.setQuantity(param.getQuantity()); //t_product

        dto.setSale(param.getSale()); // t_sale
        dto.setSalePrice(param.getSalePrice()); // t_sale
        dto.setStartSale(param.getStartSale()); // t_sale 3차 때 반영
        dto.setEndSale(param.getEndSale()); //t_sale 3차 때 반영

//        dto.setSmallCategoryId(param.getSmallCategoryId());// t_wine_pairing 테이블에 인서트 아래에서

        // 피쳐 인서트 하기
        MAPPER.insFeature(dto); //t_feature 인서트 후 pk값 productInsDto에 들어감
        // 아로마 인서트 하기
        MAPPER.insAroma(aromaDto);
        dto.setAromaId(aromaDto.getAromaId());

        //사진 파일 업로드 로직 1
        //임시경로에 사진 저장
        if(pic != null) { //만약에 pic가 있다면
            File tempDic = new File(FILE_DIR, "/temp");
            if(!tempDic.exists()) { // /temp 경로에 temp폴더가 존재하지 않는다면 temp폴더를 만든다.
                tempDic.mkdirs();
            }

            String savedFileName = MyFileUtils.makeRandomFileNm(pic.getOriginalFilename());

            File tempFile = new File(tempDic.getPath(), savedFileName);

            try{
                pic.transferTo(tempFile);
            } catch(Exception e) {
                e.printStackTrace();
            }

            dto.setPic(savedFileName);

            //t_product에 인서트
            //사진 파일 업로드 로직 2
            int result = MAPPER.insProduct(dto); //t_product 인서트 후 pk값 productInsDto에 들어감
            try {
                if(result == 0) {
                    throw new Exception("상품을 등록할 수 없습니다.");
                }
            } catch(Exception e) {
                tempFile.delete();
                return 0;
            }
            if (result == 1) {
                String targetPath = FILE_DIR + "/winey/product/" + dto.getProductId();
                File targetDic = new File(targetPath);
                if(!targetDic.exists()) {
                    targetDic.mkdirs();
                }
                File targetFile = new File(targetPath, savedFileName);
                tempFile.renameTo(targetFile);
                return dto.getProductId();
            }
        }
        MAPPER.insProduct(dto); //pic==null일 때 실행됨
        // 할인율, 할인가격 t_sale에 인서트 (product_id 이용해서) , 할인시작일과 종료일은(3차 때 구현)
        MAPPER.insSale(dto);

        //페어링음식 t_wine_pairing에 인서트
        for(int i=0;i<param.getSmallCategoryId().size();i++) {
            dto.setSmallCategoryId(param.getSmallCategoryId().get(i));
            MAPPER.insWinePairing(dto);
        }
        return dto.getProductId();
    }

    public int putProduct(MultipartFile pic, ProductUpdParam param) {
        ProductUpdDto dto = MAPPER.selProductFk(param.getProductId());
        ProductAromaDto aromaDto = new ProductAromaDto(param.getAroma()); //t_aroma

        dto.setProductId(param.getProductId()); //t_product
        dto.setNmKor(param.getNmKor()); //t_product
        dto.setNmEng(param.getNmEng()); //t_product

        dto.setPrice(param.getPrice()); //t_product
        dto.setCountryId(param.getCountry()); //t_product
        dto.setCategoryId(param.getCategory()); //t_product

        dto.setSale(param.getSale()); // t_sale
        dto.setSalePrice(param.getSalePrice()); // t_sale
        dto.setStartSale(param.getStartSale()); // t_sale
        dto.setEndSale(param.getEndSale()); // t_sale

        dto.setSweety(param.getSweety()); //t_feature
        dto.setAcidity(param.getAcidity()); //t_feature
        dto.setBody(param.getBody()); //t_feature

        //t_aroma 테이블 update
        MAPPER.updAroma(aromaDto);
        //t_sale 테이블 update
        MAPPER.updSale(dto);
        //t_feature 테이블 update
        MAPPER.updFeature(dto);

        //t_small_category table update
        MAPPER.delWinePairing(dto);

        ProductInsDto pairingDto = new ProductInsDto();
        pairingDto.setProductId(param.getProductId());
        pairingDto.setSmallCategoryId(param.getCategory());

        for(int i=0;i<param.getSmallCategoryId().size();i++) {
            pairingDto.setSmallCategoryId(param.getSmallCategoryId().get(i));
            MAPPER.insWinePairing(pairingDto);
        }

        //사진 파일 업로드 로직 1
        //임시경로에 사진 저장
        if(pic != null) { //만약에 pic가 있다면
            File tempDic = new File(FILE_DIR, "/temp");
            if(!tempDic.exists()) { // /temp 경로에 temp폴더가 존재하지 않는다면 temp폴더를 만든다.
                tempDic.mkdirs();
            }

            String savedFileName = MyFileUtils.makeRandomFileNm(pic.getOriginalFilename());

            File tempFile = new File(tempDic.getPath(), savedFileName);

            try{
                pic.transferTo(tempFile);
            } catch(Exception e) {
                e.printStackTrace();
            }

            dto.setPic(savedFileName);

            //t_product테이블 update
            //사진 파일 업로드 로직 2
            int result = MAPPER.updProduct(dto); //t_product 인서트 후 pk값 productInsDto에 들어감
            try {
                if(result == 0) {
                    throw new Exception("상품을 등록할 수 없습니다.");
                }
            } catch(Exception e) {
                tempFile.delete();
                return 0;
            }
            if (result == 1) {
                String targetPath = FILE_DIR + "/winey/product/" + dto.getProductId();
                File targetDic = new File(targetPath);
                if(!targetDic.exists()) {
                    targetDic.mkdirs();
                }
                File targetFile = new File(targetPath, savedFileName);
                tempFile.renameTo(targetFile);
            }
            return dto.getProductId(); //성공시 상품PK값 리턴
        }

        //수정시 사진파일을 수정하지 않을 경우 (pic = null)
        int result2 = MAPPER.updProduct(dto);
        if(result2 == 1) {
            return dto.getProductId();
        }
        return 0; // result2가 0이면 수정에 실패했다는 의미로 0 리턴
    }

    //상품 사진 삭제
    public int deleteProductPic(int productId) {
        MyFileUtils.delFolder(FILE_DIR+"/winey/product/"+productId);

        return 200; //성공시 200 리턴
    }

    //등록 상품 리스트 출력 (전체 상품)
    public List<ProductVo> getProduct(SelListDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return MAPPER.selProduct(dto);
    }

    //할인 중인 상품 리스트 출력 (saleYn = 1인 상품만)
    public List<ProductSaleVo> getProductSale(SelListDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);

        return MAPPER.selProductSale(dto);
    }

    //가입회원 리스트
    public List<UserVo> getUserList(SelListDto dto) {
        int startIdx = (dto.getPage()-1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return MAPPER.selUserList(dto);
    }

    //미완성) 가입회원 상세 주문 내역(회원pk별) +페이징 처리
    public List<UserOrderDetailVo> getUserOrder(Long userId, int page, int row) {
        UserOrderDetailDto dto = new UserOrderDetailDto();
        dto.setUserId(userId);
        dto.setRow(row);

        int startIdx = (page - 1) * row;
        dto.setStartIdx(startIdx);

        return MAPPER.selUserOrder(dto);
    }

    //상세 주문 내역 리스트 by orderId
    List<OrderDetailVo> getOrderDetail(int orderId) {
        return MAPPER.selOrderDetail(orderId);
    }
}
