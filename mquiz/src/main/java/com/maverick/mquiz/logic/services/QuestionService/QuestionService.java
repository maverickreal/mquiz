package com.maverick.mquiz.logic.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maverick.mquiz.data.repositories.QuestionRepo.QuestionRepo;
import java.util.List;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo Question;

    public List<QuestionEntity> getAllQuestions() {
        return Question.findAll();
    }

    public List<QuestionEntity> getQuestionsByCategory(String category) {
        return Question.getQuestionsByCategory(category);
    }

    public void addQuestion(QuestionEntity question) {
        Question.save(question);
    }
}