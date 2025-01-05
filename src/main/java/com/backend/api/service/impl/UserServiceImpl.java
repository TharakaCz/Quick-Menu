package com.backend.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.api.dto.UserDTO;
import com.backend.api.model.User;
import com.backend.api.repository.UserRepository;
import com.backend.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDTO create(UserDTO userDTO) throws Exception {
        try {
            User user =  new User();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            User data = this.userRepository.save(user);
            return new UserDTO(data.getName(), data.getEmail(), data.getStatus());
        } catch (Exception e) {
            logger.error("User create ex: "+ e.getMessage());
            throw new InternalError("OOPS! Something went wrong");
        }
    }

    @Override
    public UserDTO update(UserDTO userDTO) throws Exception {
        return null;
    }

    @Override
    public String remove(Long id) throws Exception {
        return null;
    }

    @Override
    public User getById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> users = this.userRepository.findAll();
        return users;
    }
    
}
