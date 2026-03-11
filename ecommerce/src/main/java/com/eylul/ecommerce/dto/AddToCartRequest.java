package com.eylul.ecommerce.dto;

import lombok.Data;

@Data
public class AddToCartRequest {

    private Long cartId;
    private Long productId;
    private Integer quantity;

}