package com.maverick.mquiz.data.repositories.QuestionRepo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.maverick.mquiz.data.models.QuestionEntity.QuestionEntity;

// @Repository
public interface QuestionRepo extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> getQuestionsByCategory(String category);

    @Query(value = "SELECT * FROM question WHERE category = :category ORDER BY RAND() LIMIT :size", nativeQuery = true)
    List<QuestionEntity> findNRandomQuestionsOfCategory(String category, Short size);
}