package com.Alekperova.Pollen.Service;

import com.Alekperova.Pollen.model.Answer;
import com.Alekperova.Pollen.model.Poll;
import com.Alekperova.Pollen.model.Question;
import com.Alekperova.Pollen.repository.AnswerRepository;
import com.Alekperova.Pollen.repository.PollRepository;
import com.Alekperova.Pollen.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final AnswerRepository answerRepository;
    private final PollRepository pollRepository;
    private final QuestionRepository questionRepository;


    public void vote(Long answerId){
        Answer answer = answerRepository.findById(answerId).orElseThrow();
        answer.setSelected(answer.getSelected()+1);
        answerRepository.save(answer);
    }

    public void editQuestion(Long questionId, Principal principal, String questionText){
        Question question = questionRepository.findById(questionId).orElseThrow();
        Poll poll = question.getPoll();
        question.setQuestionText(questionText);
        if(poll.getUserLogin().equals(principal.getName())){
            questionRepository.save(question);
        }
        else{
            throw new AccessDeniedException("Only creator can edit poll: " + poll.getUserLogin() + ", you are " + principal.getName());
        }
    }
}
