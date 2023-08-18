package com.vote.Mapper;

import com.vote.DTO.VoteDto;
import com.vote.Entity.Vote;
import org.mapstruct.Mapper;

@Mapper
public interface VoteMapper{
    Vote votePostDtoToVote(VoteDto.Post requestBody);
    Vote votePatchDtoToVote(VoteDto.Patch requestBody);
    VoteDto.Response voteToVoteResponseDto(Vote vote);
}
