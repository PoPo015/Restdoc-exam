package com.example.restdocexam.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarTest {


    @Test
    public void given() throws Exception{
        //given
        Car car = new Car();
        Integer result = 0;
        //when
        for (int i = 0; i < 10; i++){
            int length = new Random().nextInt(10);
            result += car.run(length);

        }

        //then
        Assertions.assertThat(car.getStreet()).isEqualTo(result);

        System.out.println("car.getStreet()" + car.getStreet() + "result.getStreet()>" + result);

    }

}