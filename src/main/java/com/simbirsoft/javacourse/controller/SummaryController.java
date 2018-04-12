package com.simbirsoft.javacourse.controller;

import com.simbirsoft.javacourse.repository.SummaryRepository;
import com.simbirsoft.javacourse.data.PropertyReader;
import com.simbirsoft.javacourse.entity.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Properties;

@Controller
public class SummaryController {
    @Autowired
    private SummaryRepository repository;

    @Autowired
    private PropertyReader propertyReader;


    @GetMapping("/summary")
    public String save(){

        Properties prop = propertyReader.loadFile();
        System.out.println("property FIO = " + prop.getProperty("FIO"));

        Summary summary = new Summary();
        summary.setFio(prop.getProperty("FIO"));
        summary.setDob(prop.getProperty("DOB"));
        summary.setPhone(prop.getProperty("phone"));
        summary.setEmail(prop.getProperty("email"));
        summary.setSkype(prop.getProperty("skype"));
        summary.setTarget(prop.getProperty("target"));
        summary.setExperience(prop.getProperty("experiences"));
        summary.setEducations(prop.getProperty("educations"));
        repository.save(summary);
        System.out.println("fio = " + repository.findAll().get(0).getFio());
        return "summary";
    }

//    @GetMapping("/summary/{fio}/{dob}/{phone}")
//    public String save(@PathVariable(value="fio") String fio,
//                       @PathVariable(value="dob") String dob,
//                       @PathVariable(value="phone") String phone){
//
//        Properties prop = propertyReader.loadFile();
//        System.out.println("property FIO = " + prop.getProperty("FIO"));
//
//        Summary summary = new Summary();
//        summary.setFio(fio);
//        summary.setDob(dob);
//        summary.setPhone(phone);
//        repository.save(summary);
//        return "summary";
//    }


    @RequestMapping("/info")
    public String get(Model model, @RequestParam(value="id") Long id)
    {
        List<Summary> list = repository.findSummaryById(id);
        System.out.println("id = "+id);
        //System.out.println("size = "+list.size());
        System.out.println("list.get(0).getFio() = "+list.get(0).getFio());

        model.addAttribute("fio", list.get(0).getFio());
        model.addAttribute("dob", list.get(0).getDob());
        model.addAttribute("phone", list.get(0).getPhone());
        model.addAttribute("email", list.get(0).getEmail());
        model.addAttribute("skype", list.get(0).getSkype());
        model.addAttribute("target", list.get(0).getTarget());
        model.addAttribute("experience", list.get(0).getExperience());
        model.addAttribute("educations", list.get(0).getEducations());
        return  "summary";
    }

//    @RequestMapping("/summary")
//    public String get(Model model) {
//        Summary sum = new Summary();
//        model.addAttribute("fio", "Alena");
//        model.addAttribute("dob", "25");
//        model.addAttribute("phone", "51");
//        return "summary";
//    }

}
