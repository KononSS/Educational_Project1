package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,
                            @RequestParam (value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello "+name+ " "+surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam (value = "b", required = false) int b,
                            @RequestParam (value = "operation", required = false) String operation,
                            Model model) {
        double znachenie=0;
        switch(operation){
            case "multiplication":
                znachenie= b * a;
                break;
            case "addition":
                znachenie= b + a;
                break;
            case "subtraction":
                znachenie= b - a;
                break;
            case "division":
                znachenie= b / a;
                break;
        }

        model.addAttribute("message1", "a= "+a+ ";\n b= "+b+" ;\n result operation "+operation+": "+znachenie);
        return "first/calculator";
    }
}
