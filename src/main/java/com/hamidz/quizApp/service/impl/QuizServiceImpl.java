package com.hamidz.quizApp.service.impl;

import com.hamidz.quizApp.entity.Question;
import com.hamidz.quizApp.entity.QuestionWrapper;
import com.hamidz.quizApp.entity.Quiz;
import com.hamidz.quizApp.entity.Response;
import com.hamidz.quizApp.repository.QuestionRepository;
import com.hamidz.quizApp.repository.QuizRepository;
import com.hamidz.quizApp.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    @Override
    public ResponseEntity<String> createQuiz(String category, Long numQ, String title) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Integer> calculateResult(Long quizId, List<Response> responses) {
        Quiz quiz = quizRepository.findById(quizId).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
