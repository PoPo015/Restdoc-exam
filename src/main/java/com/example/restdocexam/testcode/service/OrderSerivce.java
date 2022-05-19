package com.example.restdocexam.testcode.service;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import com.example.restdocexam.testcode.domain.entity.Order;
import com.example.restdocexam.testcode.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class OrderSerivce {

    private final OrderRepository orderRepository;

    public void orderCreate(OrderRequest request) {
        log.info("> Service 주문 생성");

        orderRepository.save(new Order(request));

    }

    public void orderGetList() {
        log.info("> Service 주문 리스트 조회");
    }

    public void orderFindOne(Long id) {
        log.info("> Service 주문 단건 조회");
    }

    public void orderDelete(Long id) {
        log.info("> Service 주문 단건 삭제");
    }


}
