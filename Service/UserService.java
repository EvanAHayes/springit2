package com.ehayes.springit2.Service;


import com.ehayes.springit2.SpringitRepository.UserRepository;
import com.ehayes.springit2.Springitmodel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//You will often find that your service is going to contain a lot of the methods the repository contains
// and that is ok, it will also contain some methods the repository doesn’t.

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
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
}