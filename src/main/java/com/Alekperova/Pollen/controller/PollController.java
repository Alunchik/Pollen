package com.Alekperova.Pollen.controller;


import com.Alekperova.Pollen.Service.PollService;
import com.Alekperova.Pollen.model.Answer;
import com.Alekperova.Pollen.model.Poll;
import com.Alekperova.Pollen.repository.PollRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class PollController {

    private final PollService pollService;

    @CrossOrigin
    @PostMapping("/poll")
    public void createPoll(@RequestBody Poll poll, Principal principal){
        pollService.addPoll(poll, principal);
    }
    @CrossOrigin
    @GetMapping("/poll")
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }
    @GetMapping("/poll/{id}")
    public List<Answer> getAllAnswersByQuestion(@PathVariable Long id){
        return pollService.getAllAnswersByQuestion(id);
    }

    @PutMapping("/poll/{pollId}")
    public void changePollTopic(Principal principal, @PathVariable Long pollId, @RequestParam String pollTopic){
        pollService.changePollTopic(principal, pollTopic, pollId);
    }

    @DeleteMapping("poll/{pollId}")
    public void deletePollById(Principal principal, @PathVariable Long pollId){
        pollService.deletePollById(principal, pollId);
    }
}
