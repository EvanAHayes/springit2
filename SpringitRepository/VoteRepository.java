package com.ehayes.springit2.SpringitRepository;

import com.ehayes.springit2.Springitmodel.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
