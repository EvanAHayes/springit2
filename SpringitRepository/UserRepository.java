package com.ehayes.springit2.SpringitRepository;

import com.ehayes.springit2.Springitmodel.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //ask our repository that we are going to pass a email and i want you to find me one
    //make sure you have findBy and not findby
    Optional<User> findByEmail(String email);

}
