package com.mquiz.question.logic.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mquiz.question.data.repositories.QuestionRepo.QuestionRepo;
import java.util.LinkedList;
import java.util.List;
import com.mquiz.question.data.models.QuestionEntity.QuestionEntity;;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo Question;

    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        return new ResponseEntity<>(Question.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(String category) {
        return new ResponseEntity<List<QuestionEntity>>(Question.getQuestionsByCategory(category), HttpStatus.OK);
    }

    public ResponseEntity addQuestion(QuestionEntity question) {
        Question.save(question);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<List<Long>> generateQuestionsForQuiz(String category, Short numberOfQuestions) {
        return ResponseEntity.ok(Question.findNRandomQuestionsOfCategory(category, numberOfQuestions));
    }

    public ResponseEntity<List<QuestionModel>> fetchQuestionsFromIds(List<Long> questionIds) {
        List<QuestionModel> questions = new LinkedList<>();
        for (Long qid : questionIds) {
            QuestionEntity qEntity = Question.findById(qid).get();
            questions.add(new QuestionModel(qEntity));
        }
        return ResponseEntity.ok(questions);
    }

    public ResponseEntity<Short> getQuizScore(List<AnswerModel> answers) {
        Short score = 0;
        for (AnswerModel aModel : answers) {
            QuestionEntity qEntity = Question.findById(aModel.questionId()).get();
            if (qEntity.getAnswer().equals(aModel.answer())) {
                score++;
            }
        }
        return ResponseEntity.ok(score);
    }
}