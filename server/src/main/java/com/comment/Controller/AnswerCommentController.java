package com.comment.Controller;

import com.comment.Entity.Comment;
import com.comment.DTO.CommentDto;
import com.comment.Mapper.CommentMapper;
import com.comment.Service.CommentService;
import com.Exception.BusinessLogicException;
import com.Exception.ExceptionCode;
import com.member.Service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RequestMapping("/answer_comment")
@RestController
@Validated
public class AnswerCommentController {
    private final static String QUESTION_COMMENT_URL = "/answer_comment";
    private final CommentService commentService;
    private final CommentMapper mapper;

    private final MemberService memberService;

    public AnswerCommentController(CommentService commentService,
                                   CommentMapper mapper,
                                   MemberService memberService){
        this.commentService = commentService;
        this.mapper = mapper;
        this.memberService = memberService;
    }


    @PostMapping("/")
    public ResponseEntity postQuestionComment(@Valid @RequestBody CommentDto.Post post){

        Comment createdComment = commentService.createComment(mapper.commentPostDtoToComment(post));
        return new ResponseEntity(mapper.commentToCommentResponseDto(createdComment), HttpStatus.CREATED);
    }

    @PatchMapping("/{members_id}/{comment_id}")
    public ResponseEntity patchQuestionComment(@PathVariable("members_id") @Positive long memberId,
                                               @PathVariable("comment_id") @Positive long commentId,
                                               @Valid @RequestBody CommentDto.Patch patch){
        findVerifiedCommentMember(memberId, commentId);
        patch.addCommentId(commentId);
        Comment updateComment = commentService.updateComment(mapper.commentPatchDtoToComment(patch));

        return ResponseEntity.ok(mapper.commentToCommentResponseDto(updateComment));
    }

    @DeleteMapping("/{members_id}/{comment_id}")
    public void deleteQuestionComment(@PathVariable("member_id") @Positive long memberId,
                                      @PathVariable("comment_id") @Positive long commentId){
        findVerifiedCommentMember(memberId, commentId);
        commentService.deleteComment(commentId);
    }

    private void findVerifiedCommentMember(long memberId, long commentId){

        memberService.findVerifiedMember(memberId);
        long memberCheckId = commentService.findVerifiedComment(commentId).getMember().getMemberId();
        if(memberCheckId != memberId ) throw new BusinessLogicException(ExceptionCode.MEMBER_FORBIDDEN);
    }

}
