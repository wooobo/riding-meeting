package com.slowin.ridingmeeting.application;

import com.slowin.ridingmeeting.domain.LoginMember;
import com.slowin.ridingmeeting.domain.Member;
import com.slowin.ridingmeeting.domain.MemberRepository;
import com.slowin.ridingmeeting.dto.TokenRequest;
import com.slowin.ridingmeeting.dto.TokenResponse;
import com.slowin.ridingmeeting.infrastructure.JwtTokenProvider;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(final MemberRepository memberRepository,
        final JwtTokenProvider jwtTokenProvider) {
        this.memberRepository = memberRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public TokenResponse login(TokenRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
            .orElseThrow(RuntimeException::new);
        member.checkPassword(request.getPassword());

        String token = jwtTokenProvider.createToken(request.getEmail());
        return new TokenResponse(token);
    }

    public LoginMember findMemberByToken(String credentials) {
        if (!jwtTokenProvider.validateToken(credentials)) {
            throw new RuntimeException();
        }

        String email = jwtTokenProvider.getPayload(credentials);
        Member member = memberRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        return new LoginMember(member.getId(), member.getEmail(), member.getAge());
    }
}
