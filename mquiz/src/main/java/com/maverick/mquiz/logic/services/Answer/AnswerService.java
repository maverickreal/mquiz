package com.maverick.mquiz.logic.services.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.maverick.mquiz.api.controllers.restControllers.Answer.AnswerModel;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;
import com.maverick.mquiz.data.repositories.QuizRepo.QuizRepo;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private QuizRepo quizRepo;

    public ResponseEntity<Short> getScore(Long quizId, List<AnswerModel> answers) {
        List<QuestionEntity> questions = quizRepo.findById(quizId).get().getQuestions();
        if (questions.size() != answers.size()) {
            return ResponseEntity.badRequest().build();
        }
        Short score = 0;
        for (int ind = 0; ind < questions.size(); ++ind) {
            if (questions.get(ind).getAnswer().equals(answers.get(ind).answer())) {
                score++;
            }
        }
        return ResponseEntity.ok(score);
    }
}