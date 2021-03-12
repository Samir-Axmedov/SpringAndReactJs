package com.aptek.pharm.configuration;

import com.aptek.pharm.Respository.userRepository;
import com.aptek.pharm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    userRepository useRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User idb = useRepository.findByUsername(username);
        if (idb==null){
            throw new UsernameNotFoundException("User not found");
        }
        //return new PharmUserDetails(idb);
        return idb;
    }
}
