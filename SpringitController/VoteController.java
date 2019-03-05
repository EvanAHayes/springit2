package com.ehayes.springit2.SpringitController;

import com.ehayes.springit2.Service.LinkService;
import com.ehayes.springit2.Service.VoteService;
import com.ehayes.springit2.SpringitRepository.LinkRepository;
import com.ehayes.springit2.SpringitRepository.VoteRepository;
import com.ehayes.springit2.Springitmodel.Link;
import com.ehayes.springit2.Springitmodel.Vote;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//using a rest because it does not render a view out
//rest controller returns a response based on what we are asking for in the header
@RestController
public class VoteController {

    private VoteService voteService;
    private LinkService linkService;

    public VoteController(VoteService voteService, LinkService linkService) {
        this.voteService = voteService;
        this.linkService = linkService;
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkID}/direction/{direction}/votecount/{voteCount}")
    public int vote(@PathVariable Long linkID, @PathVariable short direction, @PathVariable int voteCount) {
        Optional<Link> optionalLink = linkService.findById(linkID);
        if( optionalLink.isPresent() ) {
            Link link = optionalLink.get();
            Vote vote = new Vote(direction,link);
            voteService.save(vote);

            int updatedVoteCount = voteCount + direction;
            link.setVoteCount(updatedVoteCount);
            linkService.save(link);
            return updatedVoteCount;
        }

        return voteCount;
    }

}
