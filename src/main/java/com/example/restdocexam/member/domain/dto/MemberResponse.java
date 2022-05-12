package com.example.restdocexam.member.domain.dto;

import com.example.restdocexam.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {

    private Long id;
    private String email;
    private Integer age;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.age = member.getAge();
    }






}
