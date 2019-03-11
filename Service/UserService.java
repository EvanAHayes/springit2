package com.ehayes.springit2.Service;


import com.ehayes.springit2.SpringitRepository.UserRepository;
import com.ehayes.springit2.Springitmodel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//You will often find that your service is going to contain a lot of the methods the repository contains
// and that is ok, it will also contain some methods the repository doesn’t.

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {

        //need to take password from form and encode it
        String secret = "{bcrypt}" + encoder.encode("password");
        user.setPassword(secret);

        //confirm password
        user.setConfirmPassword(secret);

        //assign a role to user
        user.addRole(roleService.findByName("ROLE_USER"));

        // set activation code

        //disable user

        // save user
        Save(user);

        //send activation email
        SendActivationEmail(user);

        //return user
        return user;

    }

    public User Save(User user){
        return userRepository.save(user);
    }


    @Transactional
    public void SaveUsers(User... users) {
        for (User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }

    public void SendActivationEmail(User user){
        //send email
    }
}