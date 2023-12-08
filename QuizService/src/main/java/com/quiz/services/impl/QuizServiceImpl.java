package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositroies.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service   // for autowired
public class QuizServiceImpl implements QuizService {

     private QuizRepository quizRepository;

     private QuestionClient questionClient;

     @Autowired
     public QuizServiceImpl(QuizRepository quizRepository,QuestionClient questionClient) {

          this.quizRepository = quizRepository;
          this.questionClient=questionClient;
     }

     @Override
     public Quiz add(Quiz quiz) {
          return quizRepository.save(quiz);
     }

     @Override
     public List<Quiz> get() {
          List<Quiz> quizess= quizRepository.findAll();
//          List<Quiz> newQuizList=quizess.stream().map(quiz -> {
//              quiz.setQuestions(questionClient.getQuestionofQuiz(quiz.getId()));
//              return  quiz;
//         }).collect(Collectors.toList());
          for(Quiz quiz : quizess){
               quiz.setQuestions(questionClient.getQuestionofQuiz(quiz.getId()));
          }
          return quizess;
     }

     @Override
     public Quiz get(Long id) {
          Quiz quiz=quizRepository.findById(id).orElseThrow(()-> new RuntimeException("quiz Not found") );
          quiz.setQuestions(questionClient.getQuestionofQuiz(quiz.getId()));
          return quiz;
     }
}
