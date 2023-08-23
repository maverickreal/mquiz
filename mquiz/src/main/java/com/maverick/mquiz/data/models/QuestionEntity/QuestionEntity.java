package com.maverick.mquiz.data.models.QuestionEntity;

import java.util.List;
import com.maverick.mquiz.data.models.QuizEntity.QuizEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer difficulty;
    @Column(nullable = false)
    private String title, option1, option2, option3, option4, answer, category;
    // private List<QuizEntity> quizes;
}