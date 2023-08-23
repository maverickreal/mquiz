package com.maverick.mquiz.data.repositories.QuizRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maverick.mquiz.data.models.QuizEntity.QuizEntity;
import java.util.Optional;

public interface QuizRepo extends JpaRepository<QuizEntity, Long> {
    Optional<QuizEntity> findByTitle(String title);
}