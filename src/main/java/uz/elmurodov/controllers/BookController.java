package uz.elmurodov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import uz.elmurodov.criteria.BookCriteria;
import uz.elmurodov.dto.book.BookCreateDto;
import uz.elmurodov.models.Book;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.book.BookService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book/*")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("fakeBookService") BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "create/", method = RequestMethod.GET)
    private String createPage() {
        return "/book/create";
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    private String create(@ModelAttribute BookCreateDto dto, @RequestParam("file") MultipartFile file, @RequestParam("img") MultipartFile img, Model model) throws IOException {
        ResponseEntity<String> response = bookService.create(dto, file, img);
        if (response.getStatus().value() == HttpStatus.BAD_REQUEST.value()) {
            model.addAttribute("dto", dto);
            return "book/create_prepared";
        }
        return "redirect:/home/";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    private ModelAndView deletePage(ModelAndView modelAndView, @PathVariable String id) {
        modelAndView.setViewName("book/delete");
        modelAndView.addObject("book", bookService.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "detail/{id}/", method = RequestMethod.GET)
    private String details(Model model, @PathVariable String id) {
        model.addAttribute("book", bookService.get(id).getBody().getBody());
        return "book/detail";
    }
//
//    @RequestMapping(value = "list/", method = RequestMethod.GET)
//    private String bookListPage(Model model) {
//        model.addAttribute("books", bookService.getAll().getBody().getBody());
//        return "book/list";
//    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.POST)
    private String delete(@PathVariable String id) {
        bookService.delete(id);
        return "redirect:/book/list/";
    }

    @RequestMapping(value = "list/", method = RequestMethod.POST)
    private String search(@ModelAttribute BookCriteria bookCriteria, Model model) {
        ResponseEntity<List<Book>> response = bookService.getAll(bookCriteria);
        model.addAttribute("books", response.getBody().getBody());
        return "/book/list";
    }



}