package com.example.restdocexam.testcode.service;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderSerivceTest {

    @Autowired
    private OrderSerivce orderSerivce;


    @Test
    public void given() throws Exception{

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setProductName("상품1");

        orderSerivce.orderCreate(orderRequest);

    }


}