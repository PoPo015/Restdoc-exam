package com.example.restdocexam.member.domain.dto;

import com.example.restdocexam.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {

    private final Long id;
    private final String email;
    private final String name;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
    }






}
