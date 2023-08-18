package com.member.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        private long memberId;
        private String email;
        private String password;
        private String display_name;
    }
    @AllArgsConstructor
    @Getter
    public static class Patch {
        public long memberId;
        public String email;
        public String display_name;
    }

    @Getter
    @AllArgsConstructor
    public class MemberResponseDto {
        public long member_id;
        public String email;
        public String password;
        public String display_name;
    }
}
