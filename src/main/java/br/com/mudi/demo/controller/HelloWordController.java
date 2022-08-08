package br.com.mudi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWordController {
    @GetMapping("/HelloWord")
    public String hello(Model model){
        model.addAttribute("nome", "Gian");
        return "HelloWord";
    }
}
