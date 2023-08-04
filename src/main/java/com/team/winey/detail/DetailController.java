package com.team.winey.detail;

import com.team.winey.detail.model.WineDetailVo;
import com.team.winey.detail.model.WineVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {
    private final DetailService SERVICE;

    @GetMapping("/{productId}")
    @Operation(summary = "와인 디테일 페이지")
    public WineVo getWineDetail(@PathVariable Long productId){
        WineDetailVo vo = new WineDetailVo();
        vo.setProductId(productId);
        return SERVICE.selWineDetail(productId);




    }
}
