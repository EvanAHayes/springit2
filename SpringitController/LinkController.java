package com.ehayes.springit2.SpringitController;
import com.ehayes.springit2.SpringitRepository.LinkRepository;
import com.ehayes.springit2.Springitmodel.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.Optional;


@Controller
public class LinkController {



    @Autowired
    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("links", linkRepository.findAll());
        return "list";
    }

    //view page controller for each links
    @GetMapping("/link/{id}")
    public String Read(@PathVariable long id, Model model){
        Optional<Link> link = linkRepository.findById(id);
        if(link.isPresent() ){
            model.addAttribute("link", link.get());
            model.addAttribute("success", model.containsAttribute("success"));
            return "view";

        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/link/submit")
    public String newLink(Model model){
        model.addAttribute("link", new Link());
        return "submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model,
     RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("link", link);
            return "submit";

        }else{
            //save the link
            linkRepository.save(link);
            redirectAttributes
                    .addAttribute("link", link.getId())
            //flash attribute is a attribute that will only live on the next template you visit
                    .addFlashAttribute("success", true);
                    return "redirect:/link/{id}";
        }
    }



    }


