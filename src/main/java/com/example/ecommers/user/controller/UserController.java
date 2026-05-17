package com.example.ecommers.user.controller;


import com.example.ecommers.user.dto.UserCreateRequestDTO;
import com.example.ecommers.user.dto.UserCreateResponseDTO;
import com.example.ecommers.user.dto.UserEmailIdDTO;
import com.example.ecommers.user.dto.UserEmailIdPasswordDTO;
import com.example.ecommers.user.entity.User;
import com.example.ecommers.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

   public UserController(UserService userService){
       this.userService = userService;
   }

    @PostMapping
    public UserCreateResponseDTO createUser( @Valid  @RequestBody UserCreateRequestDTO request){
            return userService.createUser(request);
    };

   @GetMapping
   public List<UserEmailIdPasswordDTO> getAllUsers(){
       return userService.getAllUser();
   }


}
