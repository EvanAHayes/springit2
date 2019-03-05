package com.ehayes.springit2.Service;

import com.ehayes.springit2.SpringitRepository.VoteRepository;
import com.ehayes.springit2.Springitmodel.Vote;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }
}
