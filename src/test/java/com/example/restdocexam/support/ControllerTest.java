package com.example.restdocexam.support;

import com.example.restdocexam.member.controller.MemberController;
import com.example.restdocexam.member.domain.MemberRepository;
import com.example.restdocexam.support.docs.CommonDocController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@Disabled
@WebMvcTest({
        MemberController.class,
        CommonDocController.class
})
public abstract class ControllerTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected MemberRepository memberRepository;

    protected String createJson(Object dto) throws JsonProcessingException{
        return objectMapper.writeValueAsString(dto);
    }


}
