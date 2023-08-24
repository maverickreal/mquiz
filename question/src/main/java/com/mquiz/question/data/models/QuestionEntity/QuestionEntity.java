package com.mquiz.question.data.models.QuestionEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class QuestionEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Short difficulty;
    @Column(nullable = false)
    private String title, option1, option2, option3, option4, answer, category;
    // private List<QuizEntity> quizes;
}