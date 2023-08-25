package com.mquiz.quiz.logic.feignServicesClients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("question")
public interface QuestionClient {
    @PostMapping("questions")
    ResponseEntity addQuestion(@RequestBody QuestionDto question);

    @GetMapping("questions/generate")
    ResponseEntity<List<Long>>getNQuestionsOfCategory(@RequestParam("category") String category,
            @RequestParam("numberOfQuestions") Short numberOfQuestions);

    @PostMapping("questions/fetch_from_ids")
    ResponseEntity<List<QuestionDto>> fetchQuestionsFromIds(@RequestBody List<Long> questionIds);

    @PostMapping("questions/fetch_score")
    ResponseEntity<Short> getQuizScore(@RequestBody List<AnswerDto> answers);
}