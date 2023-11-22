package com.Alekperova.Pollen.Service;

import com.Alekperova.Pollen.model.Answer;
import com.Alekperova.Pollen.repository.AnswerRepository;
import com.Alekperova.Pollen.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final AnswerRepository answerRepository;

    public void vote(Long answerId){
        Answer answer = answerRepository.findById(answerId).orElseThrow();
        answer.setSelected(answer.getSelected()+1);
        answerRepository.save(answer);
    }
}
