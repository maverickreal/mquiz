package com.mquiz.question.data.repositories.QuestionRepo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mquiz.question.data.models.QuestionEntity.QuestionEntity;

// @Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> getQuestionsByCategory(String category);

    @Query(value = "SELECT id FROM question WHERE category = :category ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Long> findNRandomQuestionsOfCategory(String category, Short numberOfQuestions);
}