package org.example.productcatalogservice_feb2025.Service.others;

import org.example.productcatalogservice_feb2025.models.SingleClass.Animal;
import org.example.productcatalogservice_feb2025.repo.inheritance.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService implements IAnimalService {

    @Autowired
    AnimalRepo animalRepo;


    @Override
    public List<Animal> getAllAnimals() {
       List<Animal> animals= animalRepo.findAll();
        animals.forEach(a -> System.out.println(a.getClass().getSimpleName()));
        return animals;
    }
}
