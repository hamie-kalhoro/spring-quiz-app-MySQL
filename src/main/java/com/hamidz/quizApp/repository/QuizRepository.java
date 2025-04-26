package com.hamidz.quizApp.repository;

import com.hamidz.quizApp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
