package com.example.restdocexam.unit.member.domain;

import com.example.restdocexam.member.domain.Member;
import com.example.restdocexam.member.domain.MemberStatus;
import com.example.restdocexam.member.domain.dto.MemberSignUpRequest;
import com.example.restdocexam.support.docs.RestDocsTestSupport;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;

import java.util.List;

import static com.example.restdocexam.config.RestDocsConfig.filed;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RefactorMemberTest extends RestDocsTestSupport {



    @Test
    public void member_page_test() throws Exception {
        //given
        Member member = new Member("backtony@gmail.com", 27, MemberStatus.NORMAL);
        //when
        PageImpl<Member> memberPage = new PageImpl<>(List.of(member), PageRequest.of(0, 10), 1);
        given(memberRepository.findAll(ArgumentMatchers.any(Pageable.class))).willReturn(memberPage);

        mockMvc.perform(
                        get("/api/members")
                                .param("size", "10")
                                .param("page", "0")
                                .contentType(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isOk())


                .andDo(
                        restDocs.document(
                                requestParameters(
                                        parameterWithName("size").optional().description("size"), // 필수여부 false
                                        parameterWithName("page").optional().description("page") // 필수여부 false
                                )
                        )
                );
    }


    @Test
    public void member_create() throws Exception{

        MemberSignUpRequest dto = MemberSignUpRequest.builder()
                .status(MemberStatus.BAN)
                .email("kst005109@naver.com")
                .age(27)
                .build();

        mockMvc.perform(
                post("/api/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
        ).andExpect(status().isOk())
                .andDo(
                    restDocs.document(
                        requestFields(
                            fieldWithPath("age").description("age").attributes(filed("constraints", "길이 10 이하")),
                            fieldWithPath("email").description("email").attributes(filed("constraints", "길이 30 이하")),
                            fieldWithPath("status").description("Code Member status 참조")
                    )
                ));
    }






}
