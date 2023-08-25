package com.mquiz.quiz.api.controllers.restControllers.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mquiz.quiz.logic.feignServicesClients.QuestionDto;
import com.mquiz.quiz.logic.services.QuizService.QuizService;
import java.util.List;

@RestController
@RequestMapping("quizes")
public class Quiz {
    @Autowired
    private QuizService quizService;

    @PostMapping
    ResponseEntity addQuiz(@RequestBody QuizDto quiz) {
        try {
            return quizService.addQuiz(quiz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("{title}")
    ResponseEntity<List<QuestionDto>> getQuizByTitle(@PathVariable String title) {
        return quizService.getQuizByTitle(title);
    }
}