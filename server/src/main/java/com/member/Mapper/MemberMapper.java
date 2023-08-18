package com.member.Mapper;

import com.member.DTO.MemberDto;
import com.member.Entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtotoMember (MemberDto.Post postDto);
    Member memberPatchDtotoMember (MemberDto.Patch patchDto);
    Member memberResponseDtotoMember (Member member);
}
