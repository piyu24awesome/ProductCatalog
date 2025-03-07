package org.example.productcatalogservice_feb2025.dataLoader;

import org.example.productcatalogservice_feb2025.models.TablePerClass.InheritanceUser;
import org.example.productcatalogservice_feb2025.models.TablePerClass.Instructor;
import org.example.productcatalogservice_feb2025.models.TablePerClass.TA;
import org.example.productcatalogservice_feb2025.repo.inheritance.InheritanceUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


//@Component
public class InheritanceUserDataLoader implements CommandLineRunner {

    private final InheritanceUserRepo inheritanceUserRepo;

    public InheritanceUserDataLoader(InheritanceUserRepo inheritanceUserRepo1) {
        this.inheritanceUserRepo = inheritanceUserRepo1;
    }

    @Override
    public void run(String... args) throws Exception {


        inheritanceUserRepo.save(new Instructor(1L, "Anurag", "abc@gmail.com", "Microsoft"));
        inheritanceUserRepo.save(new Instructor(2L, "Tanmay", "tan@gmail.com", "excellence"));

        inheritanceUserRepo.save(new TA(3L, "abc", "some@gmail.com", 5));
        inheritanceUserRepo.save(new TA(4L, "pqr", "put@gmail.com", 10));
        inheritanceUserRepo.save(new InheritanceUser(500L, "piyu@gmail.com", "Piyu"));

        List<InheritanceUser> users = inheritanceUserRepo.findAll();
        users.forEach(a -> System.out.println(a.getClass().getSimpleName()));


    }
}
