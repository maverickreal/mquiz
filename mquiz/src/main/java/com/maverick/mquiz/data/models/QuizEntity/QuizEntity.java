package com.maverick.mquiz.data.models.QuizEntity;

import java.util.List;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "quiz", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    @ManyToMany //(mappedBy = "quizes")
    List<QuestionEntity> questions;
    @Column(nullable = false)
    String category;
}