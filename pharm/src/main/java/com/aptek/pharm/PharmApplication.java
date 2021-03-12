package com.aptek.pharm;

import com.aptek.pharm.Service.userService;
import com.aptek.pharm.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class PharmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmApplication.class, args);
    }

/*    @Bean
    CommandLineRunner commandLineRunner(userService userService) {
        return new CommandLineRunner() {
     //       (args)->{} yaza bilerik
            @Override
            public void run(String... args) throws Exception {
             // User user = new User();
         //     user.setUsername("admin");
         //     user.setDisplayName("Samir ahmad");
          //    user.setPassword("Admin1234");
         //    userService.save(user);

*//*                { "username": "admin_samir",
                  "displayName": "admin",
                  "password":"Admin1234"
                }*//*

           }
      };
  }*/

}
