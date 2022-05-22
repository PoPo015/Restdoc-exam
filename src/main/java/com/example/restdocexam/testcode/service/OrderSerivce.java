package com.example.restdocexam.testcode.service;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import com.example.restdocexam.testcode.domain.entity.Order;
import com.example.restdocexam.testcode.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
public class OrderSerivce {

    private final OrderRepository orderRepository;

    public Order orderCreate(OrderRequest request) {
        log.info("> Service 주문 생성");

        return orderRepository.save(new Order(request));
    }

    public List<Order> orderGetList() {
        log.info("> Service 주문 리스트 조회");
        List<Order> all = orderRepository.findAll();

        if (all.size() == 0) {
            log.info("값이 없다");
            throw new RuntimeException();
        }

        log.info("> List 목록 반환");
        return all;
    }

    public Order orderFindOne(Long id) {
        log.info("> Service 주문 단건 조회");

        Optional<Order> byId = orderRepository.findById(id);


        if (!byId.isPresent()) {
            log.info("값이 없다");
            throw new RuntimeException();
        }

        log.info("> 멤버 단건 반환");
        return byId.get();
    }

    public Order orderDelete(Long id) {
        log.info("> Service 주문 단건 삭제");


        Optional<Order> byId = orderRepository.findById(id);
        if (!byId.isPresent()) {
            log.info("값이 없다");
            throw new RuntimeException();
        }

        orderRepository.delete(byId.get());
        return byId.get();
    }

    public Order orderChange(OrderRequest request) {
        log.info("> request ---> {}", request);

        Optional<Order> byId = orderRepository.findById(request.getId());

        if(!byId.isPresent()){
            log.info("값이 없다");
            throw new RuntimeException();
        }

        Order order = byId.get();
        order.setProductName(request.getProductName());

        return order;
    }


}
