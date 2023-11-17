package com.Alekperova.Pollen.Service;

import com.Alekperova.Pollen.model.Answer;
import com.Alekperova.Pollen.model.Poll;
import com.Alekperova.Pollen.repository.AnswerRepository;
import com.Alekperova.Pollen.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PollService {

    private final PollRepository pollRepository;

    private final AnswerRepository answerRepository;


    public void addPoll(Poll poll){
        pollRepository.save(poll);
    }

    public List<Poll> getAllPolls(){
        return pollRepository.findAll();
    }


    public List<Answer> getAllAnswersByQuestion(Long questionId){
        return answerRepository.findByQuestionId(questionId);
    }
}
