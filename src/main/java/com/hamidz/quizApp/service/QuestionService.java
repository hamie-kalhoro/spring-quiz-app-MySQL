package com.hamidz.quizApp.service;

import com.hamidz.quizApp.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    ResponseEntity<List<Question>> getAllQuestions();
    ResponseEntity<List<Question>> getQuestionsByCategory(String category);
    ResponseEntity<String> addQuestion(Question question);
}
