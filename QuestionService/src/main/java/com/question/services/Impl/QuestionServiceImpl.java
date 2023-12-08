package com.question.services.Impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

     private QuestionRepository questionRepository;

     @Autowired
     public QuestionServiceImpl(QuestionRepository questionRepository) {
          this.questionRepository = questionRepository;
     }

     @Override
     public Question create(Question question) {
          return questionRepository.save(question);
     }

     @Override
     public List<Question> get() {
          return questionRepository.findAll();
     }

     @Override
     public Question getOne(Long id) {
          return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("id not found"));
     }

     @Override
     public List<Question> getQuestionsOfQuiz(Long quizId) {
          return questionRepository.findByQuizId(quizId);
     }
}
