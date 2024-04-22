package com.ITPM.springbootbackend.service.impl;

import com.ITPM.springbootbackend.dto.UserRequest;
import com.ITPM.springbootbackend.model.User;
import com.ITPM.springbootbackend.repository.UserRepository;
import com.ITPM.springbootbackend.service.CordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CordinatorServiceImpl implements CordinatorService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(UserRequest userRequest) {
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setUserName(userRequest.getUserName());
        user.setUserType(userRequest.getUserType());
        user.setEmail(userRequest.getEmail());
        user.setContactNumber(userRequest.getContactNumber());
        user.setPassword(userRequest.getPassword());
        user.setProfilePicture(userRequest.getProfilePicture());
        user.setName(userRequest.getName());
      return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User userFindById(Long uId) {

        Optional<User> userOptional = userRepository.findById(uId);

        if (!userOptional.isPresent()){
            return null;
        }

        User user = userOptional.get();

        return user;


    }


}
