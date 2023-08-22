package com.question.dto;

import javax.validation.constraints.NotBlank;

public class QuestionPatchDto {
    private long membersId;
    private long questionId;

    @NotBlank(message = "제목은 필수 입력 사항입니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력 사항입니다.")
    private String content;

    private String tag;

    public long getMembersId() {
        return membersId;
    }

    public void setMembersId(long membersId) {
        this.membersId = membersId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
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
}
