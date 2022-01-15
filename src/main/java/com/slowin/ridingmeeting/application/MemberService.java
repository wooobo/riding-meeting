package com.slowin.ridingmeeting.application;

import com.slowin.ridingmeeting.domain.Member;
import com.slowin.ridingmeeting.domain.MemberRepository;
import com.slowin.ridingmeeting.dto.MemberRequest;
import com.slowin.ridingmeeting.dto.MemberResponse;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse createMember(MemberRequest request) {
        Member member = memberRepository.save(request.toMember());
        return MemberResponse.of(member);
    }
}
