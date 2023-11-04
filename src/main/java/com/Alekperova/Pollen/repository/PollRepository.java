package com.Alekperova.Pollen.repository;

import com.Alekperova.Pollen.model.Poll;
import com.Alekperova.Pollen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {

}
