package com.maverick.mquiz.logic.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.maverick.mquiz.data.repositories.QuestionRepo.QuestionRepo;
import java.util.List;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo Question;

    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        return new ResponseEntity<>(Question.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(String category) {
        return new ResponseEntity<List<QuestionEntity>>(Question.getQuestionsByCategory(category), HttpStatus.OK);
    }

    public ResponseEntity addQuestion(QuestionEntity question) {
        Question.save(question);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}