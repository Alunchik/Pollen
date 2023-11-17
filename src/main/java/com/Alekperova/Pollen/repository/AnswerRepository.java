package com.Alekperova.Pollen.repository;

import com.Alekperova.Pollen.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long answerId);
}
