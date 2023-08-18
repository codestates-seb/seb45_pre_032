package com.member.Controller;

import com.member.DTO.MemberDto;
import com.member.Entity.Member;
import com.member.Response.SingleResponseDto;
import com.member.Service.MemberService;
import com.member.Mapper.MemberMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {
    //    private final static String MEMBER_DEFAULT_URL ="";
    private MemberService memberService;
    private MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper){
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post postDto){

//        Member member = mapper.memberPostDtotoMember(postDto);    JPA 학습 이전
//        Member createMember = memberService.createMember(member); JPA 학습 이전 / 8월 13일 개발

        Member createMember = memberService.createMember(mapper.memberPostDtotoMember(postDto));

        return new ResponseEntity<> (new SingleResponseDto<>(mapper.memberToMemberResponseDto(createMember)), HttpStatus.CREATED);
    }

    @PatchMapping("/{member_id}")
    public ResponseEntity patchMember(@PathVariable("member_id") long memberId,
                                      @Valid @RequestBody MemberDto.Patch patchDto){

//        Member member = mapper.memberPatchDtotoMember(patchDto);  JPA 학습 이전
//        Member updateMember = memberService.updateMember(member); JPA 학습 이전 /8월 13일 개발

        Member updateMember = memberService.updateMember(mapper.memberPatchDtotoMember(patchDto));

        return new ResponseEntity<> (new SingleResponseDto<>(mapper.memberToMemberResponseDto(updateMember)), HttpStatus.OK);
    }

    @GetMapping("/{member_id}")
    public ResponseEntity getMember(@PathVariable("member_id") long memberId) {

        Member findMember = memberService.findMember(memberId);

        return new ResponseEntity<> (new SingleResponseDto<>(mapper.memberToMemberResponseDto(findMember)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        List<MemberDto.MemberResponseDto> response = mapper.membersToMemberResponseDto(members);


        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteMember(@PathVariable("member_id") long memberId){

        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
