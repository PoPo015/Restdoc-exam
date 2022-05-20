package com.example.restdocexam.testcode.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class OrderRequest {

    private Long id;

    private String productName;


    public OrderRequest(String productName) {
        this.productName = productName;
    }
}
