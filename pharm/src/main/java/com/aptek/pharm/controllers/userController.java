package com.aptek.pharm.controllers;

import com.aptek.pharm.Service.userService;
import com.aptek.pharm.Share.genericResponce;
import com.aptek.pharm.entity.User;
import com.aptek.pharm.error.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
public class userController {

   // Logger log = (Logger) LoggerFactory.getLogger(userController.class);

    @Autowired
    userService userService;

   // PasswordEncoder passwordEncoder;


    //@CrossOrigin
    @PostMapping("/api/1.0/users")
    //@ResponseStatus(HttpStatus.CREATED)
    private genericResponce createUser(@RequestBody User user) {
/*        String username = user.getUsername();
        String displayName = user.getDisplayName();
        apiError error = new apiError(400, "Validation error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();

        if (username == null || username.isEmpty()) {
            validationErrors.put("username", "username can't be null");
        }
        if (displayName == null || displayName.isEmpty()) {
            validationErrors.put("displayName", "Can't be null");
        }
        if (validationErrors.size() > 0) {
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        userService.save(user);
        log.info(user.toString());
        //  return new genericResponce("User Created");
        return ResponseEntity.ok(new genericResponce("user created"));*/
        userService.save(user);
        return new genericResponce("user created");

    }

/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationApiError(MethodArgumentNotValidException exception) {
        ApiError error = new ApiError(400, "Validation error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        };
        error.setValidationErrors(validationErrors);
        return error;

    }*/


}
