package com.Alekperova.Pollen.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String questionText;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<Answer> answers;
}
