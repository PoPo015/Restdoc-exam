package com.example.restdocexam.testcode.controller;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import com.example.restdocexam.testcode.service.OrderSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderSerivce orderSerivce;

    @PostMapping("/order/create")
    private void orderCreate(@RequestBody OrderRequest request) {
        log.info("> Controller 주문 등록");

        orderSerivce.orderCreate(request);

    }

    @GetMapping("/order/list")
    private void orderGetList() {
        log.info("> Controller 주문 리스트 조회");

        orderSerivce.orderGetList();
    }

    @GetMapping("/order")
    private void orderFindOne(@RequestParam("id") Long id) {
        log.info("> Controller 주문 단건 조회");

        orderSerivce.orderFindOne(id);
    }

    @DeleteMapping("/order")
    private void orderDelete(@RequestParam("id") Long id) {
        log.info("> Controller 주문 등록");

        orderSerivce.orderDelete(id);
    }

    @PutMapping("/order")
    private void orderPut(@RequestBody OrderRequest request){
        log.info("> Controller 주문 수정");

        orderSerivce.orderChange(request);
    }


}
