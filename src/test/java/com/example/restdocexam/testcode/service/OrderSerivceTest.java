package com.example.restdocexam.testcode.service;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import com.example.restdocexam.testcode.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class OrderSerivceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderSerivce orderSerivce;

    @Test
    public void given() throws Exception{

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setProductName("상품1");

        orderSerivce.orderCreate(orderRequest);

    }


}