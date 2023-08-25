package com.mquiz.quiz.logic.feignServicesClients;

public record QuestionDto(String title, String category, String option1,
                String option2, String option3, String option4) {
}