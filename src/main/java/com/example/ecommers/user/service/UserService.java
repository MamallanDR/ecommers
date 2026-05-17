package com.example.ecommers.user.service;

import com.example.ecommers.user.dto.UserCreateRequestDTO;
import com.example.ecommers.user.dto.UserCreateResponseDTO;
import com.example.ecommers.user.dto.UserEmailIdDTO;
import com.example.ecommers.user.dto.UserEmailIdPasswordDTO;
import com.example.ecommers.user.entity.User;
import com.example.ecommers.user.exceptions.UserAlreadyExistException;
import com.example.ecommers.user.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }


    public UserCreateResponseDTO createUser(UserCreateRequestDTO request)
            throws UserAlreadyExistException {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEmailId(request.getEmailId());

        try {
            User createdUser = userRepository.save(user);

            UserCreateResponseDTO response = new UserCreateResponseDTO();
            response.setUsername(createdUser.getUsername());
            response.setEmailId(createdUser.getEmailId());

            return response;

        } catch (DataIntegrityViolationException e) {
            throw new UserAlreadyExistException("User already exists");
        }
    }

    public List<UserEmailIdPasswordDTO> getAllUser(){
        List<User> users =  userRepository.findAll();

        return users.stream().
                map((user)->{
                    UserEmailIdPasswordDTO useremailidpassword= new UserEmailIdPasswordDTO();
                    useremailidpassword.setEmailId(user.getEmailId());
                    useremailidpassword.setPassword(user.getPassword());
                    return useremailidpassword;
                }).toList();
    };
}
