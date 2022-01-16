package com.slowin.ridingmeeting.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.slowin.ridingmeeting.domain.Member;
import com.slowin.ridingmeeting.domain.MemberRepository;
import com.slowin.ridingmeeting.dto.MemberRequest;
import com.slowin.ridingmeeting.dto.MemberResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    public static final String EMAIL = "email@email.com";
    public static final String PASSWORD = "password";
    public static final int AGE = 10;

    @Mock
    private MemberRepository memberRepository;

    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 회원정보_저장_됨() {
        // given
        given(memberRepository.save(any(Member.class))).willReturn(
            new Member(EMAIL, PASSWORD, AGE));
        MemberRequest memberRequest = new MemberRequest(EMAIL, PASSWORD, AGE);

        // when
        MemberResponse memberResponse = memberService.createMember(memberRequest);

        // then
        assertAll(
            () -> assertThat(memberResponse.getEmail()).isEqualTo(EMAIL),
            () -> assertThat(memberResponse.getAge()).isEqualTo(AGE)
        );
    }

}
