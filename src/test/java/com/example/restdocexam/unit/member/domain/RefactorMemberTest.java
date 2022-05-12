package com.example.restdocexam.unit.member.domain;

import com.example.restdocexam.member.domain.Member;
import com.example.restdocexam.member.domain.MemberStatus;
import com.example.restdocexam.support.docs.RestDocsTestSupport;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RefactorMemberTest extends RestDocsTestSupport {



    @Test
    public void member_page_test() throws Exception {
        Member member = new Member("backtony@gmail.com", 27, MemberStatus.NORMAL);
        PageImpl<Member> memberPage = new PageImpl<>(List.of(member), PageRequest.of(0, 10), 1);
        given(memberRepository.findAll(ArgumentMatchers.any(Pageable.class))).willReturn(memberPage);

        mockMvc.perform(
                        get("/api/members")
                                .param("size", "10")
                                .param("page", "0")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(
                        restDocs.document(
                                requestParameters(
                                        parameterWithName("size").optional().description("size"), // 필수여부 false
                                        parameterWithName("page").optional().description("page") // 필수여부 false
                                )
                        )
                )
        ;
    }






}
