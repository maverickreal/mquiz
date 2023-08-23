package com.maverick.mquiz.api.controllers.restControllers.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.maverick.mquiz.logic.services.QuizService.QuizService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("quizes")
public class Quiz {
    @Autowired
    private QuizService quizService;

    @PostMapping
    ResponseEntity addQuiz(@RequestParam("title") String title, @RequestParam("category") String category, @RequestParam("size") short size) {
        try {
            return quizService.addQuiz(title, category, size);
        } catch (Exception e) {
            System.out.println("coxefgu");
            System.out.println(e.getMessage());
            // e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}