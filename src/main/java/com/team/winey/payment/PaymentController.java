package com.team.winey.payment;

import com.team.winey.payment.model.PaymentInsDto;
import com.team.winey.payment.model.PaymentUpdDto;
import com.team.winey.payment.model.ReviewInsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@Tag(name = "2. 결제")
public class PaymentController {

    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/payment")
    @Operation(summary = "결제", description =
            "userId: 유저PK값, <br>"
                    + "payment: 카드결제 1번, <br>"
                    + "storeId: 매장PK값, <br>"
                    + "totalOrderPrice: 총 결제 금액, <br>"
                    + "pickupTime: 픽업타임, <br>"
                    + "orderStatus: 주문상태 <br>")
    public int postPayment(@RequestBody PaymentInsDto dto) {
        return service.insPayment(dto);
    }


    @PutMapping("/orderstatus")
    @Operation(summary = "주문상태 변경", description =
            "orderStatus: 주문 상태, <br>")
    public int putPayment(@RequestBody PaymentUpdDto dto) {
        return service.updPayment(dto);
    }


    @GetMapping("/sumPrice")
    @Operation(summary = "결제 총금액", description =
            "userId: user pk값 <br>")
    public int getSumPrice(@RequestParam int userId) {
        return service.selSumPrice(userId);
    }

    @PostMapping("/review")
    @Operation(summary = "결제", description =
            "orderDetailId: 주문상세 pk값, <br>"
                    + "review_level: 1번 좋아요 <br>"
                    + "2번 보통이에요 <br>"
                    + "3번 취향 아니에요 <br>")
    public int postReview(@RequestBody ReviewInsDto dto) {
        return service.insReview(dto);


    }
}