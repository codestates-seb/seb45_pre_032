package com.comment.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotNull
        private String content;
        private long membersId;
        private long questionId;

    }
    @Getter
    public static class Patch{
        private long commentId;
        private String content;

        public void addCommentId(long commentId){this.commentId = commentId;}
    }
    @Getter
    @Builder
    public static class Response {
        private long commentId;
        private String content;
        private String createdAt;
        private String modifiedAt;

    }


}
