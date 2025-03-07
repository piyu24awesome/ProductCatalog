package org.example.productcatalogservice_feb2025.dataLoader;

import org.example.productcatalogservice_feb2025.models.SingleClass.Animal;
import org.example.productcatalogservice_feb2025.models.SingleClass.Cow;
import org.example.productcatalogservice_feb2025.models.SingleClass.Dog;
import org.example.productcatalogservice_feb2025.models.SingleClass.UnknownAnimal;
import org.example.productcatalogservice_feb2025.repo.inheritance.AnimalRepo;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class AnimalDataLoader implements CommandLineRunner {

    private final AnimalRepo animalRepo;

    public AnimalDataLoader(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Dog dog1 = new Dog("sheru",5L, "pomerian");
        Dog dog2= new Dog("rocky",6L, "indian");
        Cow cow1 = new Cow("mau1",7L, true);
        Cow cow2 = new Cow("mau2",8L, true);


        UnknownAnimal a1= new UnknownAnimal();
        a1.setId(200L);
        animalRepo.save(dog1);
        animalRepo.save(dog2);
        animalRepo.save(cow1);
        animalRepo.save(cow2);
        animalRepo.save(a1);

        List<Animal> animals =animalRepo.findAll();

        animals.forEach( animal->System.out.println(animal.getClass().getSimpleName()));



    }
}
