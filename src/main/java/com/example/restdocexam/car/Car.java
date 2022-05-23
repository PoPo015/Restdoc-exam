package com.example.restdocexam.car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private Integer street = 0;

    public Integer run(Integer street) {
        this.street += street;
        return street;
    }

}
