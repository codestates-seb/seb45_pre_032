package com.member.Entity;

import com.comment.Entity.Comment;
import com.vote.Entity.VoteMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String displayName;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @Column(nullable = false)
    private LocalDateTime signInAt = LocalDateTime.now();// 서비스에 post 진행시 호출

    @Column(nullable = false)
    private LocalDateTime lastLoginAt = LocalDateTime.now();// 서비스에 patch 진행시 호출

    //Comment와 1:다 매핑
    @OneToMany(mappedBy = "member_id")
    private List<Comment> comments;
    //VoteMember와 1:다 매핑
    @OneToMany(mappedBy = "member_id")
    private List<VoteMember> voteMembers;

    public Member (String email, String password, String displayName){
        this.email = email;
        this.password = password;
        this.displayName = displayName;
    }


    public enum MemberStatus{
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
