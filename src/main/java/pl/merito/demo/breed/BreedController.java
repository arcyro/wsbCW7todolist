package pl.merito.demo.breed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/breeds")
public class BreedController {


    private final  BreedRepository breedRepository;

    public BreedController(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }


    @GetMapping("/list")
    public String allRaceses(Model model) {
        List<Breed> all = breedRepository.findAll();
        model.addAttribute("breeds", all);
        return "breeds/list";
    }

}
