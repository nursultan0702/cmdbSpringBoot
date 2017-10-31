package com.example.demo.Controllers;

import com.example.demo.Entities.Visit;
import com.example.demo.Repositories.VisitsRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final VisitsRepository visitsRepository;

    public ApiController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @GetMapping("/visits")
    public Iterable<Visit> getVisits() {
        return visitsRepository.findAll();
    }
    @GetMapping("/check")
    public Visit check(){
        long i =1;
        return visitsRepository.findOne(i);
    }
//    @GetMapping("/test")
//    public String test(){
//        visitsRepository.
//        return "";
//    }
}
