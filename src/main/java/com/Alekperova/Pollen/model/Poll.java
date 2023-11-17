package com.Alekperova.Pollen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "polls")
@Getter
@Setter
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Question question;
}
