package com.example.restdocexam.member.domain;

import com.example.restdocexam.member.domain.dto.MemberRequest;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
// 참조
// https://backtony.github.io/spring/2021-10-15-spring-test-3/#1-rest-docs-%EB%9E%80
@AutoConfigureMockMvc
@AutoConfigureRestDocs // rest docs 자동 설정
class MemberTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void 더미데이터_추가(){
        Member member = new Member();
        member.setEmail("kst005109@naver.com");
        member.setName("김승태");
        memberRepository.save(member);
    }

//    @AfterEach
//    public void 더미데이터_삭제(){
//
//        memberRepository.deleteAll();
//
//    }


    @Test
    public void 멤버_단건_조회() throws Exception {
        // 조회 API -> 대상의 데이터가 있어야 합니다.
        mockMvc.perform(
                        get("/api/members/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo( // rest docs 문서 작성 시작
                        document("member-get", // 문서 조각 디렉토리 명
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("Member ID")
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("id").description("ID"),
                                        fieldWithPath("name").description("name"),
                                        fieldWithPath("email").description("email")
                                )
                        )
                );
    }

    @Test
    void 멤버_단건_등록() throws Exception{


//        new Jackson
        MemberRequest memberRequest = new MemberRequest("email", "이름");


        mockMvc.perform(
                post("/api/members")
                        .content(memberRequest)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        System.out.println("memberRepository.findAll().size() > " + memberRepository.findAll().size());

    }




}