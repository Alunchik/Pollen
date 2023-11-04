package com.Alekperova.Pollen.controller;


import com.Alekperova.Pollen.Service.PollService;
import com.Alekperova.Pollen.model.Poll;
import com.Alekperova.Pollen.repository.PollRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PollController {

    private final PollService pollService;
    @PostMapping("/poll")
    public void createPoll(@RequestBody Poll poll){
        pollService.addPoll(poll);
    }
    @GetMapping("/poll")
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }
}
