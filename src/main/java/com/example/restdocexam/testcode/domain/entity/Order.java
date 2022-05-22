package com.example.restdocexam.testcode.domain.entity;

import com.example.restdocexam.testcode.domain.dto.OrderRequest;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;


@ToString
@NoArgsConstructor
@Table(name = "TB_ORDER")
@Entity
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;


    public Order(OrderRequest request) {
        this.id = request.getId();
        this.productName = request.getProductName();
    }

    public Order(Long id, String productName) {
        this.id = id;
        this.productName = productName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        return productName != null ? productName.equals(order.productName) : order.productName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }


}
