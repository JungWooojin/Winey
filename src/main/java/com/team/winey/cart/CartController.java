package com.team.winey.cart;

import com.team.winey.cart.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wine")
@RequiredArgsConstructor
@Tag(name = "장바구니")
public class CartController {

    private final CartService service;


    @PostMapping ("/cart")
    @Operation(summary = "장바구니 추가", description =
            "productId: 상품 PK값,<br>"
            + "quantity: 수량,<br>")
    public int postCart(@RequestBody CartInsDto dto){
        return service.insCart(dto);
    }

    @GetMapping("/filledcart")
    @Operation(summary = "장바구니 출력", description =
            "userId: 유저PK값, <br>"
                    + "quantity: 수량, <br>"
                    + "nmKor: 한글 이름, <br>"
                    + "nmEng: 영어 이름, <br>"
                    + "price: 가격, <br>"
                    + "salePrice: 할인가격, <br>"
                    + "pic: 사진, <br>")
    public List<CartVo> getFilledCart() {
        return service.selCart();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "장바구니 삭제", description =
            "cartId: cart pk값 <br>")
    public int delCart(@RequestBody CartdelDto dto){
        return service.delCart(dto);
    }


    @PutMapping("/quantity")
    @Operation(summary = "장바구니 수량변경", description =
            "quantity: 수량, <br>"
                    + "cartId: cart pk값 <br>")
    public int putCart(@RequestParam int cartId, @RequestParam int quantity){
        CartUpdDto dto = new CartUpdDto();
        dto.setCartId(cartId);
        dto.setQuantity(quantity);
        return service.updCart(dto);
    }
//
//    @GetMapping("/sumPrice")
//    @Operation(summary = "장바구니 총합계", description =
//            "userId: user pk값 <br>")
//    public int getSumPrice(@RequestParam int userId){
//        return service.selSumPrice(userId);
//    }

}
