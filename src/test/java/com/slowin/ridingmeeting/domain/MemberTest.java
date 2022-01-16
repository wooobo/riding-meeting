package com.slowin.ridingmeeting.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

    public static final String EMAIL = "email@email.com";
    public static final String PASSWORD = "password";
    public static final String CHANGE_PASSWORD = "changepassword";
    public static final int AGE = 10;

    @Test
    @DisplayName("유저 인스턴스화 데이터 검증")
    void create() {
        // when
        Member member = new Member(EMAIL, PASSWORD, AGE);

        // then
        assertAll(
            () -> assertThat(member.getEmail()).isEqualTo(EMAIL),
            () -> assertThat(member.getPassword()).isEqualTo(PASSWORD),
            () -> assertThat(member.getAge()).isEqualTo(AGE)
        );
    }

    @Test
    @DisplayName("비밀번호 검증시 일치 하지 않을 경우 예외가 발생한다")
    void checkPassword_fail() {
        // when
        Member member = new Member(EMAIL, PASSWORD, AGE);

        assertThrows(RuntimeException.class, () -> member.checkPassword(CHANGE_PASSWORD));
    }

}