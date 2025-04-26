package com.hamidz.quizApp.repository;

import com.hamidz.quizApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategory(String category);
    List<Question> findRandomQuestionsByCategory(String category, Long limit);
}
