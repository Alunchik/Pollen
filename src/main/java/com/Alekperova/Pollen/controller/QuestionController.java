package com.Alekperova.Pollen.controller;


import com.Alekperova.Pollen.Service.PollService;
import com.Alekperova.Pollen.Service.QuestionService;
import com.Alekperova.Pollen.model.Answer;
import com.Alekperova.Pollen.model.Poll;
import com.Alekperova.Pollen.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @PutMapping("/poll/{pollId}/vote")
    public void changePollTopic(Principal principal,  @RequestParam Long answerId){
        questionService.vote(answerId);
    }

    @PutMapping("/question/{questionId}")
    public void editQuestion(Principal principal, @PathVariable Long questionId, @RequestBody Question question){
        questionService.editQuestion(questionId, principal, question);
    }

}
