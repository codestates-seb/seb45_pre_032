package com.question.controller;

import com.codestates.member.dto.QuestionPostDto;
import com.codestates.member.dto.QuestionPatchDto;
import com.codestates.member.dto.QuestionResponseDto;
import com.codestates.member.entity.Question;
import com.codestates.member.mapper.QuestionMapper;
import com.codestates.member.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController  //제공된 API 명세서에 따라 기본적인 Json형태로 CRUD 기능을 수행
@RequestMapping("/questions")
@Validated
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;

    // QuestionController 클래스의 생성자. QuestionService와 QuestionMapper를 주입받음
    public QuestionController(QuestionService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    // 질문을 생성하는 POST 요청을 처리함
    @PostMapping("/")
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto questionDto) {
        // DTO를 엔티티로 매핑함.
        Question question = mapper.questionPostDtoToQuestion(questionDto);

        // 서비스를 통해 질문을 생성함.
        Question response = questionService.createQuestion(question);

        // 생성된 질문의 응답 DTO를 HttpStatus CREATED 상태와 함께 반환함.
        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(response),
                HttpStatus.CREATED);
    }

    // 질문을 수정하는 PATCH 요청을 처리함.
    @PatchMapping("/{members-id}/{question-id}")
    public ResponseEntity patchQuestion(
            @PathVariable("members-id") @Positive long membersId,
            @PathVariable("question-id") @Positive long questionId,
            @Valid @RequestBody QuestionPatchDto questionPatchDto) {
        // 수정할 질문의 멤버 ID와 질문 ID를 설정함.
        questionPatchDto.setMembersId(membersId);
        questionPatchDto.setQuestionId(questionId);

        // 서비스를 통해 질문을 수정함.
        Question response = questionService.updateQuestion(mapper.questionPatchDtoToQuestion(questionPatchDto));

        // 수정된 질문의 응답 DTO를 HttpStatus OK 상태와 함께 반환함.
        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(response),
                HttpStatus.OK);
    }

    // 특정 질문을 조회하는 GET 요청을 처리함.
    @GetMapping("/{members-id}/{question-id}")
    public ResponseEntity getQuestion(
            @PathVariable("members-id") @Positive long membersId,
            @PathVariable("question-id") @Positive long questionId) {
        // 서비스를 통해 특정 질문을 조회함.
        Question response = questionService.findQuestion(membersId, questionId);

        // 조회된 질문의 응답 DTO를 HttpStatus OK 상태와 함께 반환함.
        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(response), HttpStatus.OK);
    }

    // 모든 질문을 조회하는 GET 요청을 처리함.
    @GetMapping
    public ResponseEntity getQuestions() {
        // 서비스를 통해 모든 질문을 조회함.
        List<Question> questions = questionService.findQuestions();

        // 조회된 질문들을 응답 DTO로 매핑하고, HttpStatus OK 상태와 함께 반환함.
        List<QuestionResponseDto> response =
                questions.stream()
                        .map(question -> mapper.questionToQuestionResponseDto(question))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 질문을 삭제하는 DELETE 요청을 처리함.
    @DeleteMapping("/{members-id}/{question-id}")
    public ResponseEntity deleteQuestion(
            @PathVariable("members-id") @Positive long membersId,
            @PathVariable("question-id") @Positive long questionId) {
        System.out.println("# delete question");

        // 서비스를 통해 질문을 삭제함.
        questionService.deleteQuestion(membersId, questionId);

        // 삭제 성공 메시지를 HttpStatus NO_CONTENT 상태와 함께 반환함.
        return new ResponseEntity<>("{\"message\": \"Question Deleted successfully\"}", HttpStatus.NO_CONTENT);
    }
}
