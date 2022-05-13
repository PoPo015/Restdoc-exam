package com.example.restdocexam.member.domain.dto;

import com.example.restdocexam.member.domain.Member;
import com.example.restdocexam.member.domain.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSignUpRequest {

    @Email
    @Size(max = 40)
    private String email;

    @Max(10)
    private int age;

    private MemberStatus status;

    public Member toEntity(){
        return new Member(email, age, status);
    }


}
