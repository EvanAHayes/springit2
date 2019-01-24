package com.ehayes.springit2.SpringitController;
import com.ehayes.springit2.SpringitRepository.LinkRepository;
import com.ehayes.springit2.Springitmodel.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {


    @Autowired
    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public List<Link> list(){
        return linkRepository.findAll();
    }



    @PostMapping("/create")
    public Link Create(@ModelAttribute Link link){
        return linkRepository.save(link);
    }

    //Link
    @GetMapping("/{id}")
    public Optional<Link> Read(@PathVariable Long id){
        return linkRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Link Update(@PathVariable Long id, @ModelAttribute Link link){
        return linkRepository.save(link);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        linkRepository.deleteById(id);
    }



}
