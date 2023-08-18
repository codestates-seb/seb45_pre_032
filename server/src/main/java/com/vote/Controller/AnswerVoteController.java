package com.vote.Controller;

import com.member.Entity.Member;
import com.member.Service.MemberService;
import com.vote.DTO.VoteDto;
import com.vote.Entity.Vote;
import com.vote.Entity.VoteMember;
import com.vote.Mapper.VoteMapper;
import com.vote.Service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/answer_vote")
@Validated
public class AnswerVoteController {

    private final VoteService voteService;
    private final VoteMapper mapper;
    private final MemberService memberService;

    public AnswerVoteController(VoteService voteService,
                                VoteMapper mapper,
                                MemberService memberService){
        this.voteService = voteService;
        this.mapper = mapper;
        this.memberService = memberService;
    }

    @PostMapping("/")
    public ResponseEntity postAnswerVote(){
        Vote createdVote = voteService.createdVote();

        return new ResponseEntity(createdVote, HttpStatus.CREATED);
    }

    @PatchMapping("/{member_id}/{vote_id}")
    public ResponseEntity patchAnswerVote(@PathVariable("member_id") @Positive long memberId,
                                          @PathVariable("vote_id") @Positive long voteId,
                                          @RequestBody VoteDto.Patch patch){
        //새로운 좋아요를 기록하기위해 이전 좋아요를 찾아 원상복구
        long count = voteService.findVoteCount(voteId).getVoteCount();
        if(verifiedVoteMemberId(memberId, voteId).equals("Like")) voteService.findVoteCount(voteId).setVoteCount(count-1);
        if(verifiedVoteMemberId(memberId, voteId).equals("DisLike")) voteService.findVoteCount(voteId).setVoteCount(count+1);

        patch.addVoteId(voteId);
        Vote updateVote = voteService.updateVote(mapper.votePatchDtoToVote(patch));

        return new ResponseEntity(mapper.voteToVoteResponseDto(updateVote), HttpStatus.OK);
    }

    @GetMapping("/{vote_id}")
    public ResponseEntity findAnswerVote(@PathVariable("vote_id") @Positive long voteId){
        Vote findVote = voteService.findVoteCount(voteId);

        return new ResponseEntity(mapper.voteToVoteResponseDto(findVote), HttpStatus.OK);
    }

    private String verifiedVoteMemberId(long memberId, long voteId){
        Member member = memberService.findVerifiedMember(memberId);
        List<VoteMember> voteMembers = member.getVoteMembers();
        String voteType ="";
        for(VoteMember voteMember : voteMembers){
            if(voteMember.getVote().getVoteId() == voteId){
                voteType = voteMember.getVote().getVoteType();
            }
        }
        return voteType;

    }

}
