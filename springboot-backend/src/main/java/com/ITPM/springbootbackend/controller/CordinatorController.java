package com.ITPM.springbootbackend.controller;

import com.ITPM.springbootbackend.dto.UserRequest;
import com.ITPM.springbootbackend.model.User;
import com.ITPM.springbootbackend.service.CordinatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CordinatorController {

    CordinatorService cordinatorService;



    @PostMapping("/users")
    public User addUsers(@RequestBody UserRequest userRequest){
        return cordinatorService.addUser(userRequest);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return cordinatorService.getAllUser();
    }

    @GetMapping("/users/{user-id}")
    public User getAllUsers(@PathVariable("user-id") Long uID){

        return cordinatorService.userFindById(uID);
    }


}
