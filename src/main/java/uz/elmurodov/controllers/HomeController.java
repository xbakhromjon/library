package uz.elmurodov.controllers;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.elmurodov.annotations.MvcController;
import uz.elmurodov.services.book.PostgresqlBookService;

@MvcController
@RequestMapping
public class HomeController {

    @RequestMapping(value = {"/", "/home/"})
    private String homePage() {
        return "home";
    }

    @RequestMapping("/about/")
    private String about() {
        return "extras/about";
    }

    @RequestMapping("/donation")
    private String donation() {
        return "extras/donation";
    }
}
