package com.team.winey.admin;

import com.team.winey.admin.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService SERVICE;

    @Autowired
    public AdminController(AdminService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Operation(summary = "상품 등록")
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int postProduct(@RequestPart(required = false) MultipartFile pic, @RequestPart ProductInsParam param) {
        return SERVICE.postProduct(pic, param);
    }

    @Operation(summary = "상품 수정")
    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int putProduct(@RequestPart(required = false) MultipartFile pic, @RequestPart ProductUpdParam param) {
        return SERVICE.putProduct(pic, param);
    }

    //등록 상품 리스트 출력 (페이징 처리)
    @Operation(summary = "등록된 상품 리스트 출력(페이징처리)", description = "page값 = 1(default), row값 = 20(default)<br>"
            + "default값은 임의로 넣은 것이니 수정이 필요합니다.")
    @GetMapping("/product/list")
    public List<ProductVo> getProduct(@RequestParam(defaultValue = "1")int page,
                                      @RequestParam(defaultValue = "20")int row) {
        SelListDto dto = new SelListDto();
        dto.setRow(row);
        dto.setPage(page);
        return SERVICE.getProduct(dto);
    }

    //할인 중인 등록 상품 리스트 출력
    @Operation(summary = "할인 중인 상품 리스트", description = "saleYn = 1 인 상품만 리스트에 나옵니다.")
    @GetMapping("/product/salelist")
    public List<ProductSaleVo> getProductSale(@RequestParam(defaultValue = "1")int page,
                                              @RequestParam(defaultValue = "20")int row) {
        SelListDto dto = new SelListDto();
        dto.setRow(row);
        dto.setPage(page);
        return SERVICE.getProductSale(dto);
    }
}
