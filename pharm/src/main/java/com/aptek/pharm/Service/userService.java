package com.aptek.pharm.Service;

import com.aptek.pharm.Respository.userRepository;
import com.aptek.pharm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {

    userRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public userService(userRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public void save(User user) {
        String encrypPass=this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encrypPass);
        userRepository.save(user);
    }



}
