package com.hamidz.quizApp.service;

import com.hamidz.quizApp.entity.QuestionWrapper;
import com.hamidz.quizApp.entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<String> createQuiz(String category, Long numQ, String title);
    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long quizId);
    ResponseEntity<Integer> calculateResult(Long quizId, List<Response> responses);
}
