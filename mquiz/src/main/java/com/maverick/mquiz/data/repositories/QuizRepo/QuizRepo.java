package com.maverick.mquiz.data.repositories.QuizRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maverick.mquiz.data.models.QuizEntity.QuizEntity;

public interface QuizRepo extends JpaRepository<QuizEntity, Long> {
}