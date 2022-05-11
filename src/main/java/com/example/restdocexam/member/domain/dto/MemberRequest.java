package com.example.restdocexam.member.domain.dto;

import lombok.Getter;

@Getter
public class MemberRequest {

    private Long id;
    private String email;
    private String name;


    public MemberRequest(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public MemberRequest(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
