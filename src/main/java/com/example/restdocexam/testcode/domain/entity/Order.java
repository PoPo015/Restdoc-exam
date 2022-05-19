package com.example.restdocexam.testcode.domain.entity;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Table(name = "TB_ORDER")
@Entity
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;


    public Order(OrderRequest request) {
        this.productName = request.getProductName();
    }
}
