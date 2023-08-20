package com.maverick.mquiz.api.controllers.restControllers.question;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maverick.mquiz.logic.services.QuestionService.QuestionService;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;

@RestController
@RequestMapping("questions")
public class Question {
    private final QuestionService questionService;
    Question(QuestionService _QuestionService){
        questionService = _QuestionService;
    }
    @GetMapping
    List<QuestionEntity> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @GetMapping("{category}")
    List<QuestionEntity> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping
    void addQuestion(@RequestBody QuestionEntity question){
        questionService.addQuestion(question);
    }
}