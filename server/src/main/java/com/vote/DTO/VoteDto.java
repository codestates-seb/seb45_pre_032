package com.vote.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class VoteDto {

    @Getter
    @AllArgsConstructor
    public static class Post{
        private String voteType;
        private long voteCount;
    }
    @Getter
    @Setter
    public static class Patch{
        private long voteId;
        private String voteType;
        private long voteCount;

        public void addVoteId(long voteId){
            this.voteId = voteId;
        }

    }

    @Getter
    @Builder
    public static class Response{
        private long voteId;
        private long memberId;
        private String voteType;
        private long voteCount;
    }


}
