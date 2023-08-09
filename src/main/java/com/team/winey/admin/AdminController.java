package com.team.winey.admin;

import com.team.winey.admin.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "관리자 페이지")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService SERVICE;

    @Autowired
    public AdminController(AdminService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Operation(summary = "상품 등록", description = "성공시 코드 : 상품PK, 실패시 코드 : 0<br>"
    +"nmKor/nmEng -> String타입<br>"
    +"price/alcohol/quantity -> int타입<br>"
    +"promotion -> 추천상품에 해당할 때 1, 아닐 때 0<br>"
    +"beginner -> 입문자 추천상품일 때 1, 아닐 때 0<br>"
    +"country -> 1(미국), 2(스페인), 3(프랑스), 4(이탈리아), 5(포르투갈), 6(칠레)<br>"
    +"sweety/acidity/body -> 0~5<br>"
    +"category -> 1(레드), 2(화이트), 3(스파클링), 4(기타)<br>"
    +"aroma(flower/plant/fruit/spicy/earth/oak/nuts -> 향이 있으면 1, 없으면 0<br>"
    +"sale/salePrice -> int타입<br>"
    +"startSale/endSale -> 2023-08-08 12:00 형식 (시간 단위까지만 입력, 분단위는 00)<br>"
    +"smallCategoryId -> steak(1), chicken(2), lamb(3), pork(4), oyster(5), fish(6), shrimp(7), clam(8), cheese(9), fruit(10), pizza(11), pasta(12)<br>")
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int postProduct(@RequestPart(required = false) MultipartFile pic, @RequestPart ProductInsParam param) {
        return SERVICE.postProduct(pic, param);
    }

    @Operation(summary = "상품 수정", description = "성공시 코드 : 상품PK, 실패시 코드 : 0<br>"
            +"nmKor/nmEng -> String타입<br>"
            +"price/alcohol/quantity -> int타입<br>"
            +"promotion -> 추천상품에 해당할 때 1, 아닐 때 0<br>"
            +"beginner -> 입문자 추천상품일 때 1, 아닐 때 0<br>"
            +"country -> 1(미국), 2(스페인), 3(프랑스), 4(이탈리아), 5(포르투갈), 6(칠레)<br>"
            +"sweety/acidity/body -> 0~5<br>"
            +"category -> 1(레드), 2(화이트), 3(스파클링), 4(기타)<br>"
            +"aroma(flower/plant/fruit/spicy/earth/oak/nuts -> 향이 있으면 1, 없으면 0<br>"
            +"sale/salePrice -> int타입<br>"
            +"startSale/endSale -> 2023-08-08 12:00 형식 (시간 단위까지만 입력, 분단위는 00)<br>"
            +"smallCategoryId -> steak(1), chicken(2), lamb(3), pork(4), oyster(5), fish(6), shrimp(7), clam(8), cheese(9), fruit(10), pizza(11), pasta(12)<br>")
    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int putProduct(@RequestPart(required = false) MultipartFile pic, @RequestPart ProductUpdParam param) {
        return SERVICE.putProduct(pic, param);
    }

    //등록 상품 리스트 출력 (페이징 처리)
    @Operation(summary = "페이징)등록된 상품 리스트 출력(피그마: 등록상품리스트 페이지)", description = "page값 = 1(default), row값 = 20(default)<br>"
            + "default값은 임시로 넣은 것이니 수정이 필요합니다.")
    @GetMapping("/product/list")
    public ProductList getProduct(@RequestParam(defaultValue = "1")int page,
                                      @RequestParam(defaultValue = "20")int row) {
        SelListDto dto = new SelListDto();
        dto.setRow(row);
        dto.setPage(page);
        return SERVICE.getProduct(dto);
    }

    //할인 중인 등록 상품 리스트 출력
    @Operation(summary = "페이징)할인 중인 상품 리스트", description = "saleYn = 1 인 상품만 리스트에 나옵니다.<br>"
            +"page (기본값 1), row (기본값 20) 디폴트값 임시로 해놓은거라 수정이 필요합니다.")
    @GetMapping("/product/salelist")
    public ProductSaleList getProductSale(@RequestParam(defaultValue = "1")int page,
                                              @RequestParam(defaultValue = "20")int row) {
        SelListDto dto = new SelListDto();
        dto.setRow(row);
        dto.setPage(page);
        return SERVICE.getProductSale(dto);
    }

    //가입 회원 리스트 출력
    @Operation(summary = "페이징)가입 회원 리스트 (페이징처리)(피그마: 가입회원리스트 페이지)", description = "page (기본값1), row (기본값15) 임시로 해놓은거라 수정이 필요합니다.")
    @GetMapping("/user/list")
    public UserList getUserList(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "15") int row) {
        SelListDto dto = new SelListDto();
        dto.setPage(page);
        dto.setRow(row);
        return SERVICE.getUserList(dto);
    }

    //미완성) 가입 회원별 상세 주문 내역(회원pk별) +페이징 처리
    @Operation(summary = "페이징)회원별 상세 주문 내역 (피그마: 회원상세내역 페이지)", description = "page (기본값1), row (기본값15) 임시로 해놓은거라 수정 필요하면 말해주세요.")
    @GetMapping("/{userId}/order")
    public UserOrderDetailList getUserOrder(@PathVariable Long userId, @RequestParam(defaultValue = "1")int page,
                                                @RequestParam(defaultValue = "15")int row) {
        SelListDto dto = new SelListDto();
        dto.setPage(page);
        dto.setRow(row);
        return SERVICE.getUserOrder(userId, dto);
    }

    //상품 사진 삭제
    @Operation(summary = "상품 사진 삭제(피그마:상품수정페이지에서 사진 삭제 기능)", description = "상품 수정할 때 기존 등록한 사진 삭제하기 위한 것<br>"
            +"성공시 코드 : 200")
    @DeleteMapping("/product/pic")
    public int deleteProductPic(int productId) {
        return SERVICE.deleteProductPic(productId);
    }

    //주문 내역
    @Operation(summary = "주문 내역 출력(피그마:주문내역관리 페이지)", description = "주문상품, 주문수량 출력 안하는 중<br>"
            +"page (기본값1), row (기본값15) 임시로 해놓은거라 수정 필요하면 말해주세요.")
    @GetMapping("/order")
    public List<OrderListVo> getOrder(@RequestParam(defaultValue = "1")int page,
                                      @RequestParam(defaultValue = "15")int row) {
        SelListDto dto = new SelListDto();
        dto.setPage(page);
        dto.setRow(row);

        return SERVICE.getOrder(dto);
    }
    //상세 주문 내역 리스트 by orderId
    @Operation(summary = "상세 주문 내역 출력 by orderId(피그마:주문상세리스트)")
    @GetMapping("/order/{orderId}")
    public List<OrderDetailVo> getOrderDetail(@PathVariable int orderId) {
        return SERVICE.getOrderDetail(orderId);
    }

    //환불된 상품과 환불 사유 출력
    @Operation(summary = "환불 상품 내역과 환불 사유 출력", description = "page (기본값1), row (기본값15) 임시로 해놓은거라 수정 필요하면 말해주세요.")
    @GetMapping("/order/refund")
    public List<OrderRefundVo> getOrderRefund(@RequestParam(defaultValue = "1")int page,
                                              @RequestParam(defaultValue = "15")int row) {
        SelListDto dto = new SelListDto();
        dto.setPage(page);
        dto.setRow(row);

        return SERVICE.getOrderRefund(dto);
    }

    //매장 정보 등록
    @Operation(summary = "매장 정보 등록", description = "nm(매장이름)을 기존 등록된 매장이름과 중복된 이름 입력시 등록 안됨<br>"
            +"전화번호 유효성 검사 (2~3자리 숫자)-(3~4자리 숫자)-(4자리 숫자), 실패시 코드 : 0")
    @PostMapping("/store")
    public Long postStore(@RequestBody StoreInsParam param) {
        return SERVICE.insStore(param);
    }
    //매장 리스트 출력
    @Operation(summary = "매장 리스트 출력", description = "page (기본값1), row (기본값15) 임시로 해놓은거라 수정 필요하면 말해주세요.")
    @GetMapping("/store")
    public List<StoreVo> getStore(@RequestParam(defaultValue = "1")int page,
                                  @RequestParam(defaultValue = "15")int row) {
        SelListDto dto = new SelListDto();
        dto.setPage(page);
        dto.setRow(row);

        return SERVICE.getStore(dto);
    }
    //매장 정보 수정
    @Operation(summary = "매장 정보 수정", description = "전화번호 유효성 검사 (2~3자리 숫자)-(3~4자리 숫자)-(4자리 숫자), 실패시 코드 : 0 ")
    @PutMapping("/store/{storeId}")
    public Long putStore(@RequestBody StoreInsParam param, Long storeId) {
        return SERVICE.updStore(param, storeId);
    }
    //매장 정보 삭제
    @Operation(summary = "매장 정보 삭제", description = "삭제 성공시 코드 : 1, 실패시 코드 : 0")
    @DeleteMapping("/store/{storeId}")
    public Long deleteStore(Long storeId) {
        return SERVICE.deleteStore(storeId);
    }

    //주문 상태 업데이트 (관리자 페이지에서)
    @Operation(summary = "주문 상태 업데이트(피그마:주문내역관리 페이지의 배송상태설정 기능)", description = "orderStatus코드 : 1(결제완료), 2(배송중), 3(배송완료), 4(픽업대기), 5(픽업완료), 6(주문취소)<br>"
            +"* orderStatus 코드 유효성 검사 실패시 200 리턴<br>"
            +"* 주문 상태 업데이트 실패시 0 리턴")
    @PutMapping("/order")
    public Long putOrderStatus(@RequestBody OrderStatusDto dto) {
        return SERVICE.updOrderStatus(dto);
    }

    //할인 상태(saleYn) 업데이트 (관리자가 수동으로 On/Off하는 용도)
    @Operation(summary = "상품 할인상태(saleYn) 업데이트 (관리자가 수동으로 On/Off하는 용도)", description = "업데이트 * 성공시 코드: 1<br>"+ "* 실패시 코드: 0")
    @PutMapping("/sale")
    public int putProductSaleYn(ProductSaleYnDto dto) {
        return SERVICE.putProductSaleYn(dto);
    }
}


