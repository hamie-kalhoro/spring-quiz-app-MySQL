package com.hamidz.quizApp.repository;

import com.hamidz.quizApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
