package com.vote.Service;

import com.Exception.BusinessLogicException;
import com.Exception.ExceptionCode;
import com.vote.Entity.Vote;
import com.vote.Repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    public Vote createdVote(){
        Vote createdVote = new Vote();
        return voteRepository.save(createdVote);
    }

    public Vote updateVote(Vote vote){
        Vote findVote = findVerifiedVote(vote.getVoteId());
        long count = findVote.getVoteCount();
        Optional.ofNullable(vote.getVoteType())
                .ifPresent(voteType -> findVote.setVoteType(voteType));
        if(vote.getVoteType().equals("Like")) findVote.setVoteCount(count+1);
        if(vote.getVoteType().equals("DisLike")) findVote.setVoteCount(count-1);
        // 주어진 요청에 좋아요에 변화가 있으면 voteCount를 변경하는 저장하는 로직
        return voteRepository.save(findVote);
    }

    public Vote findVoteCount(long voteId){

        return voteRepository.findById(voteId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.VOTE_NOT_FOUND));
        //voteCount를 저장소에서 불러오는 요청에 대한 응답.
    }

    public Vote findVerifiedVote(long voteId){
        Optional<Vote> optionalVote =
                voteRepository.findById(voteId);
        Vote findvote =
                optionalVote.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.VOTE_NOT_FOUND));
        return findvote;
    }

}
