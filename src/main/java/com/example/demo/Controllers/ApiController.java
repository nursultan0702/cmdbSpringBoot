package com.example.demo.Controllers;

import com.example.demo.Entities.TurbineData;
import com.example.demo.Entities.Visit;
import com.example.demo.Repositories.TurbineDataRepository;
import com.example.demo.Repositories.VisitsRepository;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {

    private final VisitsRepository visitsRepository;
    private  final TurbineDataRepository dataRepository;

    public ApiController(VisitsRepository visitsRepository, TurbineDataRepository dataRepository) {
        this.visitsRepository = visitsRepository;
        this.dataRepository = dataRepository;
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
    @GetMapping("/getdata")
    public String getData()
    {
        Gson gson = new Gson();
        Iterable<TurbineData> dataIterable = dataRepository.findAll();
        List<TurbineData> dataList = new ArrayList<>();
        dataIterable.forEach(dataList::add);
        return gson.toJson(dataList);
    }
//    @GetMapping("/test")
//    public String test(){
//        visitsRepository.
//        return "";
//    }
}
