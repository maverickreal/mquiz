package com.maverick.mquiz.logic.services.QuizService;

import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;

public record QuestionModel(String category, Short difficulty, String title,
                String option1, String option2, String option3,
                String option4) {

        public QuestionModel(QuestionEntity question) {
                this(question.getCategory(), question.getDifficulty(), question.getTitle(),
                                question.getOption1(), question.getOption2(), question.getOption3(),
                                question.getOption4());

        }
}