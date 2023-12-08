package com.quiz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


// to use Lombok ---> either use @Data annotation or the below annotation+ some extra annotation
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Quiz {

     @Id   // for primary key
     @GeneratedValue(strategy = GenerationType.AUTO)  // for auto increment value
     private Long id;

     private String title;

     transient private List<Question> questions;   // does not make a column in the database


}
