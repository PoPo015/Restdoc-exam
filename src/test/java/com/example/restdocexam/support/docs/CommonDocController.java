package com.example.restdocexam.support.docs;

import com.example.restdocexam.member.common.EnumType;
import com.example.restdocexam.member.domain.MemberStatus;
import com.example.restdocexam.member.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class CommonDocController {

    @PostMapping("/error")
    public void errorSample(@RequestBody SampleRequest dto){

    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SampleRequest{

        private String name;

        private String email;

    }

    public ApiResponseDto<EnumDocs> findEnums(){

        // 문서화 하고 싶은 -> EnumDocs 클래스에 담긴 모든 Enum 값 생성
        Map<String, String> memberStatus = getDocs(MemberStatus.values());
        Map<String, String> sex = getDocs(Sex.values());

        // 전부 담아서 반환 -> 테스트에서는 이걸 꺼내 해석하여 조각을 만들면 된다.
        return ApiResponseDto.of(EnumDocs.builder()
                .memberStatus(memberStatus)
                .Sex(sex)
                .build()
        );

    }


    private Map<String, String> getDocs(EnumType[] enumTypes) {
        return Arrays.stream(enumTypes)
                .collect(Collectors.toMap(EnumType::getName, EnumType::getDescription));
    }




}
