package com.example.restdocexam.member.controller;

import com.example.restdocexam.member.domain.Member;
import com.example.restdocexam.member.domain.MemberRepository;
import com.example.restdocexam.member.domain.dto.MemberRequest;
import com.example.restdocexam.member.domain.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Transactional
public class MemberController {

    private final MemberRepository memberRepository;

    /**
     * 멤버 단건 조회
     *
     * @param id
     * @return MemberReponse
     */
    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {

        return new MemberResponse(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다.")));
    }

    /**
     * 멤버 리스트 조회
     * @param pageable
     * @return
     */

    @GetMapping
    public Page<MemberResponse> getMembers(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<MemberResponse> result = memberRepository.findAll(pageable).map(MemberResponse::new);

        return result;
    }

    /**
     * 멤버 단건 생성
     * @param memberRequest
     */

    @PostMapping
    public void createMember(@RequestBody MemberRequest memberRequest) {
        Member member = new Member();
        member.setAge(memberRequest.getAge());
        member.setEmail(memberRequest.getEmail());

        memberRepository.save(member);
    }

    /**
     * 멤버 find 후, 수정
     * @param request
     * @throws Exception
     */

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody MemberRequest request) throws Exception {
        Member member = memberRepository.findById(id)
                .orElseThrow(Exception::new);

        member.setEmail(request.getEmail());
        member.setAge(request.getAge());
    }




}
