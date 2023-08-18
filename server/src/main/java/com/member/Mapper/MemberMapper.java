package com.member.Mapper;


import com.member.DTO.MemberDto;
import com.member.Entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtotoMember (MemberDto.Post postDto);
    Member memberPatchDtotoMember (MemberDto.Patch patchDto);
    MemberDto.MemberResponseDto memberToMemberResponseDto (Member member);
    List<MemberDto.MemberResponseDto> membersToMemberResponseDto (List<Member> members);
}
