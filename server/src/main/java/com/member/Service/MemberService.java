package com.member.Service;


import com.member.Entity.Member;
import com.member.Repository.MemberRepository;
import com.Exception.BusinessLogicException;
import com.Exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member createMember(Member member){
        verifyExistEmail(member.getEmail());
        member.setSignInAt(LocalDateTime.now());
        return memberRepository.save(member);
    }

    public Member updateMember(Member member){

        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getDisplayName())
                .ifPresent(displayName -> findMember.setDisplayName(displayName));
        Optional.ofNullable(member.getPassword())
                .ifPresent(password -> findMember.setPassword(password));
//        Optional.ofNullable(member.getEmail())
//                .ifPresent(email -> findMember.setEmail(email));
//        이메일까지? 아니면 닉네임과 비밀번호만?

        findMember.setLastLoginAt(LocalDateTime.now());

        return memberRepository.save(findMember);


    }


    public Member findMember(long memberId){
        return findVerifiedMember(memberId);
    }

    public Page<Member> findMember (int page, int size){
        return memberRepository.findAll(PageRequest.of(page, size,
        Sort.by("memberId").descending()));
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
