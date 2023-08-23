package com.maverick.mquiz.logic.services.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.maverick.mquiz.data.models.QuizEntity.QuizEntity;
import com.maverick.mquiz.data.repositories.QuestionRepo.QuestionRepo;
import com.maverick.mquiz.data.repositories.QuizRepo.QuizRepo;
import org.springframework.http.HttpStatus;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity addQuiz(String title, String category, Short size) {
        QuizEntity quiz = new QuizEntity();
        quiz.setTitle(title);
        quiz.setCategory(category);
        quiz.setQuestions(questionRepo.findNRandomQuestionsOfCategory(category, size));
        quizRepo.save(quiz);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
 