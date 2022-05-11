package com.example.restdocexam.member.controller;

import com.example.restdocexam.member.domain.Member;
import com.example.restdocexam.member.domain.MemberRepository;
import com.example.restdocexam.member.domain.dto.MemberRequest;
import com.example.restdocexam.member.domain.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Transactional
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id){

        return new MemberResponse(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다.")));
    }


    @PostMapping("")
    public void createMember(@RequestBody MemberRequest memberRequest){

        Member member = new Member();
        member.setName(memberRequest.getName());
        member.setEmail(memberRequest.getEmail());

        memberRepository.save(member);
    }






}
