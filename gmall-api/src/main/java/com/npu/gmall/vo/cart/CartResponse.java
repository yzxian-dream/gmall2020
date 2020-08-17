package com.npu.gmall.vo.cart;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartResponse implements Serializable {

    private Cart cart;//整个购物车

    private CartItem cartItem;//某一项

    //如果用户已经登录此项为null
    private String cartKey;//临时生成的

}
