package com.backend.api.service;

import java.util.List;

import com.backend.api.dto.UserDTO;
import com.backend.api.model.User;

public interface  UserService {
    public UserDTO create(UserDTO userDTO)throws Exception;
    public UserDTO update(UserDTO userDTO) throws Exception;
    public String remove(Long id) throws Exception;
    public User getById(Long id) throws Exception;
    public List<User> getAll() throws Exception;
}
