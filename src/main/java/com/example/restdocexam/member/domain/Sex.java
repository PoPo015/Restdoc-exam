package com.example.restdocexam.member.domain;

import com.example.restdocexam.member.common.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Sex implements EnumType {

    MALE("남자"),
    FEMALE("여자");

    private final String description;


    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public String getDescription() {
        return this.description;
    }


}
