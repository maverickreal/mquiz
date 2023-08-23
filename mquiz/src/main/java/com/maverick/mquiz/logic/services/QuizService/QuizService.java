package com.maverick.mquiz.logic.services.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;
import com.maverick.mquiz.data.models.QuizEntity.QuizEntity;
import com.maverick.mquiz.data.repositories.QuestionRepo.QuestionRepo;
import com.maverick.mquiz.data.repositories.QuizRepo.QuizRepo;
import org.springframework.http.HttpStatus;
import java.util.LinkedList;
import java.util.List;

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

    public ResponseEntity<List<QuestionModel>> getQuizByTitle(String title) {
        QuizEntity quiz = quizRepo.findByTitle(title).get();
        List<QuestionModel> questions = new LinkedList<>();
        for(QuestionEntity question : quiz.getQuestions()){
            questions.add(new QuestionModel(question));
        }
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}