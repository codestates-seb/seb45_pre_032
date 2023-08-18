package com.member.Service;


import com.member.Entity.Member;
import com.Exception.BusinessLogicException;
import com.Exception.ExceptionCode;
import com.member.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member createMember(Member member){
        verifyExistEmail(member.getEmail());
        return memberRepository.save(member);
    }

    public Member updateMember(Member member){
        Member updateMember = member;
        return updateMember;
    }


    public Member findMember(long memberId){
        return findVerifiedMember(memberId);
    }


    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);
        //findVerifiedMember 구현필요 (8월 17일) > 구현완료 (8월 18일)
        memberRepository.delete(findMember);
    }

    private void verifyExistEmail(String email){
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        // 예외처리는 글로벌로 작성하기로함 필요한 예외 종합 필요 (8월 17일)
    }

    public Member findVerifiedMember (long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        // 예외처리는 글로벌로 작성하기로함 필요한 예외 종합 필요 (8월 17일)
        return findMember;
    }
}
