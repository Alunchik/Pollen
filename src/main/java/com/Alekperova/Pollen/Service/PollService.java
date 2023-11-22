package com.Alekperova.Pollen.Service;

import com.Alekperova.Pollen.model.Answer;
import com.Alekperova.Pollen.model.Poll;
import com.Alekperova.Pollen.model.Question;
import com.Alekperova.Pollen.repository.AnswerRepository;
import com.Alekperova.Pollen.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PollService {

    private final PollRepository pollRepository;

    private final AnswerRepository answerRepository;


    public void addPoll(Poll poll, Principal principal){
        poll.setUserLogin(principal.getName());
        pollRepository.save(poll);
    }

    public List<Poll> getAllPolls(){
        return pollRepository.findAll();
    }


    public List<Answer> getAllAnswersByQuestion(Long questionId){
        return answerRepository.findByQuestionId(questionId);
    }


    public void changePollTopic(Principal principal, String topic, Long pollId){
        Poll poll = pollRepository.findById(pollId).orElseThrow(IllegalArgumentException::new);
        poll.setPollTopic(topic);
        if(poll.getUserLogin().equals(principal.getName())){
            pollRepository.save(poll);
        }
        else{
            throw new AccessDeniedException("Only creator can edit poll: " + poll.getUserLogin() + ", you are " + principal.getName());
        }
    }
}
