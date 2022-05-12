package com.example.restdocexam.member.domain;

import com.example.restdocexam.member.common.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberStatus implements EnumType {

    LOCK("일시 정지"),
    NORMAL("정상"),
    BAN("영구 정지");


    private final String descrption;


    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public String getDescription() {
        return this.descrption;
    }

}
