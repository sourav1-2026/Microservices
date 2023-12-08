package com.question.controller;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

     private QuestionService questionService;

     @Autowired
     public QuestionController(QuestionService questionService) {
          this.questionService = questionService;
     }

     @PostMapping
     public Question create(@RequestBody Question question){
          return questionService.create(question);
     }

     // get all
     @GetMapping
     public List<Question> getAll(){
          return questionService.get();
     }

     @GetMapping("/{questionid}")
     public Question getAll(@PathVariable Long questionid){
          return questionService.getOne(questionid);
     }


     // get all question of a speccific quiz
     @GetMapping("/quiz/{quizId}")
     public List<Question> getQuestionsofQuiz(@PathVariable Long quizId ){
          return questionService.getQuestionsOfQuiz(quizId);
     }
}
