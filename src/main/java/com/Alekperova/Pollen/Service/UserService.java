package com.Alekperova.Pollen.Service;


import com.Alekperova.Pollen.model.User;
import com.Alekperova.Pollen.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //create
    //update
    public void saveOrUpdate(User user){
        userRepository.save(user);
    }



    //read
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        if(userRepository.findAllById(id).size()>0){
            return userRepository.findAllById(id).get(0);
        }
        else return null;
    }


    //delete

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
