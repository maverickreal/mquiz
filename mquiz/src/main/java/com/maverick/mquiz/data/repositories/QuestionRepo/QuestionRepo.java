package com.maverick.mquiz.data.repositories.QuestionRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;

// @Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> getQuestionsByCategory(String category);
}