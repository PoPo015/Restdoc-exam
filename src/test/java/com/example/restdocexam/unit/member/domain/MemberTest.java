package com.example.restdocexam.unit.member.domain;

import com.example.restdocexam.member.domain.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//참조 우아한형제들 기술블로그
// https://techblog.woowahan.com/2597/
// https://techblog.woowahan.com/2678/

// 참조
// https://backtony.github.io/spring/2021-10-15-spring-test-3/#1-rest-docs-%EB%9E%80
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs // rest docs 자동 설정
class MemberTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberRepository memberRepository;


    @Test
    public void 멤버_단건_조회() throws Exception {
        // 조회 API -> 대상의 데이터가 있어야 합니다.
        mockMvc.perform(
                        get("/api/members/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo( // rest docs 문서 작성 시작
                        document("member-controller-test/member-get", // 문서 조각 디렉토리 명
                                pathParameters( // path 파라미터 정보 입력
                                        parameterWithName("id").description("Member ID")
                                ),
                                responseFields( // response 필드 정보 입력
                                        fieldWithPath("id").description("id"),
                                        fieldWithPath("email").description("email"),
                                        fieldWithPath("age").description("age")
                                )
                        )
                );
    }




 /*
 @Test
    void 멤버_단건_등록() throws Exception{

        MemberRequest memberRequest = new MemberRequest("email", "이름");

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(
                post("/api/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(memberRequest))
        ).andExpect(status().isOk());

        System.out.println("memberRepository.findAll().size() > " + memberRepository.findAll().size());

    }
*/



}