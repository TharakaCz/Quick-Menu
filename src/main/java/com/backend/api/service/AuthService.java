package com.backend.api.service;

import com.backend.api.dto.AuthDTO;
import com.backend.api.dto.UserDTO;

public interface AuthService {
    public AuthDTO login(UserDTO userDTO) throws Exception;
}
