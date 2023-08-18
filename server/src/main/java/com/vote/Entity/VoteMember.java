package com.vote.Entity;

import com.member.Entity.Member;
import com.vote.Entity.Vote;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VoteMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long voteMemberId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "vote_id")
    private Vote vote;


    public void addMember(Member member){
        this.member = member;
    }

    public void addVote(Vote vote){
        this.vote = vote;
    }

}
