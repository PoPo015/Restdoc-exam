package com.example.restdocexam.testcode.service;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import com.example.restdocexam.testcode.domain.entity.Order;
import com.example.restdocexam.testcode.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderSerivceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderSerivce orderSerivce;


    @DisplayName("주문_단건_조회")
    @Test
    public void findOne() throws Exception {
        //given
        Order fakeOrder = new Order(new OrderRequest(1L, "상품1"));
        given(orderRepository.findById(1L)).willReturn(Optional.of(fakeOrder));

        //when
        Order realOrder = orderSerivce.orderFindOne(1L);

        //then
        assertEquals(fakeOrder, realOrder);
    }

    @DisplayName("주문_전체_조회")
    @Test
    public void findAll() throws Exception{
        // DB에서 가져올 데이터는 미리만들어둔다. * DB에서 줄 예상 데이터 라고 생각하면 편하네
        List<Order> list = new ArrayList<>();
        list.add(new Order(1L, "상품1"));
        given(orderRepository.findAll()).willReturn(list);

        //when
        List<Order> orders = orderSerivce.orderGetList();

        //then
        Assertions.assertThat(orders.size()).isEqualTo(1);
    }


    @DisplayName("주문_등록")
    @Test
    public void create() throws Exception{
        //given
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setId(1L);
        orderRequest.setProductName("상품1");
        Order fakeOrder = new Order(orderRequest);

        //더미 저장
        given(orderRepository.save(any()))
                .willReturn(fakeOrder);
        //더미데이터 조회용
        given(orderRepository.findById(fakeOrder.getId()))
                .willReturn(Optional.of(fakeOrder));


        //when
        Order realOrder = orderSerivce.orderCreate(orderRequest);


        //then
        Order finalOrder = orderRepository.findById(realOrder.getId()).get();
        assertEquals(fakeOrder, finalOrder);

    }

//        검증 -> 운영 설정 맞추기
//                1.리뷰어 맞추고
//                2.버전맞추고.


    @DisplayName("주문_삭제")
    @Test
    public void delete() throws Exception{
        //given
        Long orderId = 100L;
        Order fakeOrder = new Order(100L, "상품100");

        given(orderRepository.findById(100L))
                .willReturn(Optional.of(fakeOrder));

        //when
        Order realOrder = orderSerivce.orderDelete(orderId);

        //then
        assertEquals(fakeOrder, realOrder);
    }


    @DisplayName("주문_업데이트")
    @Test
    public void update() throws Exception{
        //given
        OrderRequest request = new OrderRequest(100L, "상품명 변경");
        Order fakeOrder = new Order(request);

        given(orderRepository.findById(request.getId()))
                .willReturn(Optional.of(fakeOrder));
        //when

        Order realOrder = orderSerivce.orderChange(request);

        //then
        System.out.println("fakeOrder = " + fakeOrder);
        System.out.println("realOrder = " + realOrder);


        assertEquals(fakeOrder, realOrder);

    }


    @DisplayName("equlas_hashcode 테스트")
    @Test
    public void equals_hashcode() throws Exception{
        Order order1 = new Order(1L, "상품명");
        Order order2 = new Order(1L, "상품명");


        System.out.println(order1.hashCode() == order2.hashCode());
        System.out.println(order1.equals(order2));
        System.out.println("order1 = " + order1.hashCode());
        System.out.println("order2 = " + order2.hashCode());


    }


}