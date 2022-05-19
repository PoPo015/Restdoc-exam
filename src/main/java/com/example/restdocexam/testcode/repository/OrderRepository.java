package com.example.restdocexam.testcode.repository;

import com.example.restdocexam.testcode.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {



}
