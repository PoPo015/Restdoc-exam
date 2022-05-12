package com.example.restdocexam.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MemberStatus status;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "sex", nullable = false)
//    private Sex sex;

    public Member(String email, Integer age, MemberStatus status, Sex sex) {
        this.email = email;
        this.age = age;
        this.status = status;
//        this.sex = sex;
    }

    public Member(String email, Integer age, MemberStatus status) {
        this.email = email;
        this.age = age;
        this.status = status;
    }
}
