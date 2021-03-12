package com.aptek.pharm.controllers;

import com.aptek.pharm.Respository.userRepository;
import com.aptek.pharm.Share.CurrentUser;
import com.aptek.pharm.Share.Views;
import com.aptek.pharm.entity.User;
import com.aptek.pharm.error.ApiError;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class AuthController {
    @Autowired
    userRepository userRepository;

    @PostMapping("/api/1.0/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAutentication(@CurrentUser User user) {
   //  User userDetails= (User) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    };
}

/*
@RestController
public class AuthController {
    // Logger log = (Logger) LoggerFactory.getLogger(userController.class);

    @Autowired
    userRepository userRepository;

    //  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/api/1.0/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAutentication(*/
/*@RequestHeader(name = "Authorization"*//*
*/
/*, required = false*//*
*/
/*) String authorization*//*
) {
        //Bura gelmir onsuzda
     */
/*   if (authorization == null) {
            ApiError error = new ApiError(401, "Unautorizatin", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }*//*

        //   PharmUserDetails userDetails= (PharmUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDetails= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //   String username=userDetails.getUsername();
      */
/*  String base64encoder = authorization.split("Basic ")[1];
        String decoder = new String(Base64.getDecoder().decode(base64encoder));//Basic c2FtaXI6c2FtaXIx bele bir base64 ile
        String[] parts = decoder.split(":"); ///{user:password} olan bir array aliriq ve spit edirik
        String username = parts[0];*//*
        //  String password = parts[1];
        //   System.out.println(username + "," + password);
        //   User idb = userRepository.findByUsername(username);
       */
/* if (idb == null) {
            ApiError error = new ApiError(401, "username yanlis", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
        String hashedPassword = idb.getPassword();
        if (!passwordEncoder.matches(password, hashedPassword)) {
            ApiError error = new ApiError(401, "Parol yanlis", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }*//*

        //    log.info(authorization);
        //username displayename image
*/
/*        Map<String,String> responseBody=new HashMap<>();
        responseBody.put("username",idb.getUsername());
        responseBody.put("password",idb.getPassword());
        responseBody.put("image",idb.getImage());
        return ResponseEntity.ok(responseBody); //username displayename image*//*
        return ResponseEntity.ok(userDetails);

    };
*/

