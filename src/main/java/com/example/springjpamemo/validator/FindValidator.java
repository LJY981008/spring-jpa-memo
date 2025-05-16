package com.example.springjpamemo.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class FindValidator {
    public <T> T validFindById(Optional<T> optionalResponse, String id){
        if(optionalResponse.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "does not exist id : " + id);
        }
        return optionalResponse.get();
    }
    public  <T> T validFindByUserName(Optional<T> optionalResponse, String userName){
        if(optionalResponse.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "does not post user : " + userName);
        }
        return optionalResponse.get();
    }
}
