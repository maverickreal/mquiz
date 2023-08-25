package com.mquiz.quiz.logic.services.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mquiz.quiz.api.controllers.restControllers.Quiz.QuizDto;
import com.mquiz.quiz.data.models.QuizEntity.QuizEntity;
import com.mquiz.quiz.data.repositories.QuizRepo.QuizRepo;
import com.mquiz.quiz.logic.feignServicesClients.QuestionClient;
import com.mquiz.quiz.logic.feignServicesClients.QuestionDto;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionClient questionClient;

    public ResponseEntity addQuiz(QuizDto quizDto) {
        QuizEntity quizEntity = new QuizEntity();
        quizEntity.setTitle(quizDto.title());
        quizEntity.setCategory(quizDto.category());
        List<Long> questionIds = questionClient.getNQuestionsOfCategory(quizDto.category(), quizDto.size()).getBody();
        quizEntity.setQuestionIds(questionIds);
        quizRepo.save(quizEntity);
        return ResponseEntity.created(null).build();
    }

    public ResponseEntity<List<QuestionDto>> getQuizByTitle(String title) {
        QuizEntity quizEntity = quizRepo.findByTitle(title).get();
        List questions = new LinkedList<QuestionDto>();
        for (Long qid : quizEntity.getQuestionIds()) {
            QuestionDto qDto = questionClient.fetchQuestionsFromIds(List.of(qid)).getBody().get(0);
            questions.add(qDto);
        }
        return ResponseEntity.ok(questions);
    }
}