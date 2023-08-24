package com.mquiz.question.logic.services.QuestionService;

import com.mquiz.question.data.models.QuestionEntity.QuestionEntity;

public record QuestionModel(String title, String category, String option1,
        String option2, String option3, String option4) {
    public QuestionModel(QuestionEntity question) {
        this(question.getTitle(), question.getCategory(), question.getOption1(),
                question.getOption2(), question.getOption3(), question.getOption4());
    }
}