package com.Alekperova.Pollen.Service;

import com.Alekperova.Pollen.model.Role;
import com.Alekperova.Pollen.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").orElseThrow(NoSuchElementException::new);
    }
    @PostConstruct
    private void addRoles(){
        Role admin = new Role();
        Role user = new Role();
        admin.setName("ROLE_ADMIN");
        user.setName("ROLE_USER");
        roleRepository.save(admin);
        roleRepository.save( user);
    }
}
