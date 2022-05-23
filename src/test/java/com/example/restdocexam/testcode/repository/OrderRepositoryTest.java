package com.example.restdocexam.testcode.repository;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import com.example.restdocexam.testcode.domain.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;


    @DisplayName("주문_등록")
    @Test
    public void orderCreate() throws Exception{
        Order order = new Order();
        order.setProductName("상품1");

        assertThatCode(() -> orderRepository.save(order))
                .doesNotThrowAnyException();

    }

    @Test
    @DisplayName("주문_단건_조회")
    public void orderFindOne() throws Exception{
        //when
        Order order = orderRepository.findById(1L).get();

        //then
        assertThat(order.getId()).isEqualTo(1L);

    }

    @DisplayName("주문_전체_조회")
    @Test
    public void given() throws Exception{

        List<Order> all = orderRepository.findAll();

        assertThat(all.size()).isEqualTo(1);

    }


    @DisplayName("주문_변경")
    @Test
    public void orderChange() throws Exception{
        //given
        OrderRequest request = new OrderRequest(1L, "주문변경");
        Optional<Order> order = orderRepository.findById(request.getId());
        Order order1 = order.get();

        //when
        order1.setProductName(request.getProductName());


        System.out.println("request -->" + request.getProductName());
        System.out.println("order -->" + order1.getProductName());
        //then
        assertThat(order1.getProductName()).isEqualTo(request.getProductName());
    }


    @Test
    @DisplayName("주문_삭제")
    public void orderDelete() throws Exception{
        //when
        Order testOrder = orderRepository.findById(1L).get();
        orderRepository.delete(testOrder);

//        entityManager.flush();
//        entityManager.clear();


        Optional<Order> byId = orderRepository.findById(1L);

        assertThat(byId).isEqualTo(Optional.empty());

    }




}