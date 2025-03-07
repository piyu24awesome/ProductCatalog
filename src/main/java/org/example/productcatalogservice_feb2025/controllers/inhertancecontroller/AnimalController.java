package org.example.productcatalogservice_feb2025.controllers.inhertancecontroller;

import org.example.productcatalogservice_feb2025.Service.others.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping()
   void getAllAnimals()
    {
        System.out.println("in animal controller");
        animalService.getAllAnimals();
        System.out.println("after service");
    }
}
