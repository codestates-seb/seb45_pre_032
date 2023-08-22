package com.question.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // JPA 엔터티임을 선언하는 어노테이션.
@Table(name = "questions")  // 테이블 이름을 명시하는 어노테이션.
public class QuestionEntity {  // 데이터베이스에서 질문 정보를 저장하는 역할을 하는 QuestionEntity 클래스.

    @Id  // JPA 엔터티 클래스에서 기본 키(primary key) 필드를 지정할 때 사용하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본 키 값을 어떻게 자동으로 값을 생성할지의 방법을 지정할 때 사용하는 어노테이션
    // GenerationType.IDENTITY 전략은 데이터베이스의 자동 증가 기능을 사용하여 기본 키 값을 생성하는 것을 의미

    @Column(name = "question_id")
    private long questionId;

    @Column(name = "members_id")
    private long membersId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "tag")
    private String tag;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;


    // 생성자, 게터 및 세터 메소드
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getMembersId() {
        return membersId;
    }

    public void setMembersId(long membersId) {
        this.membersId = membersId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
