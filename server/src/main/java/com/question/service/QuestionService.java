import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {  // 비즈니스 로직을 처리하고 데이터를 조작하는 역할을 하는 QuestionService 클래스.

    private List<Question> questionList = new ArrayList<>(); // 질문을 저장하는 리스트

    // 질문 생성 메소드
    public Question createQuestion(QuestionDto questionDto) {
        Question newQuestion = new Question(
                questionList.size() + 1, // 새 질문의 ID는 리스트 크기 + 1
                questionDto.getMembers_id(), // 멤버 ID
                questionDto.getTitle(), // 제목
                questionDto.getContent(), // 내용
                questionDto.getTag(), // 태그
                LocalDateTime.now() // 현재 시간
        );
        questionList.add(newQuestion); // 리스트에 새 질문 추가
        return newQuestion;
    }

    // 질문 수정 메소드
    public Question updateQuestion(int question_id, QuestionDto questionDto) {
        Question questionToUpdate = findQuestionById(question_id);
        if (questionToUpdate != null) {
            questionToUpdate.setTitle(questionDto.getTitle()); // 제목 업데이트
            questionToUpdate.setContent(questionDto.getContent()); // 내용 업데이트
            questionToUpdate.setTag(questionDto.getTag()); // 태그 업데이트
            questionToUpdate.setModified_at(LocalDateTime.now()); // 수정 시간 업데이트
        }
        return questionToUpdate;
    }

    // 특정 질문 조회 메소드
    public Question getQuestion(int question_id) {
        return findQuestionById(question_id);
    }

    // 모든 질문 목록 조회 메소드
    public List<Question> getAllQuestions() {
        return questionList;
    }

    // 질문 삭제 메소드
    public boolean deleteQuestion(int question_id) {
        Question questionToDelete = findQuestionById(question_id);
        if (questionToDelete != null) {
            questionList.remove(questionToDelete); // 해당 질문 삭제
            return true;
        }
        return false;
    }

    // 질문 ID로 질문 찾는 메소드 (내부에서만 사용)
    private Question findQuestionById(int question_id) {
        for (Question question : questionList) {
            if (question.getQuestion_id() == question_id) {
                return question; // 해당 ID의 질문 반환
            }
        }
        return null; // 해당 ID의 질문을 찾지 못한 경우
    }
}
