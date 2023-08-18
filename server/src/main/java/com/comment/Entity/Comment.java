package com.comment.Entity;

import com.member.Entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;
    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void addMember(Member member){
        this.member = member;
    }
//
//    @ManyToOne
//    @JoinColumn(name = "QUESTION_ID")
//    private Question questionId;
}
