package com.maverick.mquiz.api.controllers.restControllers.Answer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maverick.mquiz.logic.services.Answer.AnswerService;

@RestController
@RequestMapping("answers")
public class Answer {
    @Autowired

    private AnswerService answerService;

    @PostMapping("{quizId}")
    ResponseEntity<Short> getScore(@PathVariable Long quizId, @RequestBody List<AnswerModel> answers) {
        try {
            return answerService.getScore(quizId, answers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
