package com.example.ecommers.user.exceptions;

public class UserNotFoundExection extends RuntimeException{

    UserNotFoundExection(String msg){
        super(msg);
    }
}
