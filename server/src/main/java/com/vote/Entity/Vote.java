package com.vote.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long voteId;
    private String voteType;
    private long voteCount;

    @OneToMany(mappedBy = "vote_id", cascade = CascadeType.PERSIST)
    private List<VoteMember> voteMember;


//    @OneToOne
//    private Question question;
//
//    @OneToOne
//    private Answer answer;
}