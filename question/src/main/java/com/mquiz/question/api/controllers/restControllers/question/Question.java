package com.mquiz.question.api.controllers.restControllers.question;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mquiz.question.data.models.QuestionEntity.QuestionEntity;
import com.mquiz.question.logic.services.QuestionService.AnswerModel;
import com.mquiz.question.logic.services.QuestionService.QuestionModel;
import com.mquiz.question.logic.services.QuestionService.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("questions")
public class Question {
    @Autowired
    private QuestionService questionService;

    Question(QuestionService _QuestionService) {
        questionService = _QuestionService;
    }

    @GetMapping
    ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        try {
            return questionService.getAllQuestions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("{category}")
    ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(@PathVariable String category) {
        try {
            return questionService.getQuestionsByCategory(category);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    ResponseEntity addQuestion(@RequestBody QuestionEntity question) {
        try {
            return questionService.addQuestion(question);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("generate")
    ResponseEntity<List<Long>> generateQuestionsForQuiz(@RequestParam("category") String category,
            @RequestParam("numberOfQuestions") Short numberOfQuestions) {
        try {
            return questionService.generateQuestionsForQuiz(category, numberOfQuestions);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("fetch_questions")
    ResponseEntity<List<QuestionModel>> fetchQuestionsFromIds(@RequestBody List<Long> questionIds) {
        try {
            return questionService.fetchQuestionsFromIds(questionIds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("fetch_score")
    ResponseEntity<Short> getQuizScore(@RequestBody List<AnswerModel> answers) {
        return questionService.getQuizScore(answers);
    }

}