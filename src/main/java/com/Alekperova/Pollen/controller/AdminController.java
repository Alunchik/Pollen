package com.Alekperova.Pollen.controller;


import com.Alekperova.Pollen.Service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PollService pollService;
    @DeleteMapping("/poll")
    public void deletePoll(Long pollId){
        pollService.deletePollByIdAsAdmin(pollId);
    }
}
