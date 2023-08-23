package com.maverick.mquiz.api.controllers.restControllers.Question;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maverick.mquiz.logic.services.QuestionService.QuestionService;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("questions")
public class Question {
    private final QuestionService questionService;

    Question(QuestionService _QuestionService) {
        questionService = _QuestionService;
    }

    @GetMapping
    ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        try {
            return questionService.getAllQuestions();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("{category}")
    ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(@PathVariable String category) {
        try {
            return questionService.getQuestionsByCategory(category);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    ResponseEntity addQuestion(@RequestBody QuestionEntity question) {
        try {
            return questionService.addQuestion(question);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}