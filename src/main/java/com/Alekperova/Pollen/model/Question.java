package com.Alekperova.Pollen.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tables")
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String questionText;
    @OneToOne
    @JoinColumn(name = "poll_id")
    @JsonIgnore
    private Poll poll;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;
}
