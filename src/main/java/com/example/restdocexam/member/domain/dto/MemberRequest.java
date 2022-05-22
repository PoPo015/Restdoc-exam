package com.example.restdocexam.member.domain.dto;

import com.example.restdocexam.member.domain.MemberStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequest {

    private Long id;
    private String email;
    private Integer age;
    private MemberStatus status;


    public MemberRequest(Long id, String email, Integer age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public MemberRequest(String email, Integer age) {
        this.email = email;
        this.age = age;
    }

}
