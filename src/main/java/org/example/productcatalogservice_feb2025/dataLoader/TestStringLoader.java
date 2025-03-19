package org.example.productcatalogservice_feb2025.dataLoader;

import lombok.extern.slf4j.Slf4j;
import org.example.productcatalogservice_feb2025.repo.ProductRepo;
import org.example.productcatalogservice_feb2025.repo.inheritance.TestStringRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
//@Component
public class TestStringLoader implements CommandLineRunner {

    private final TestStringRepo testStringRepo;

    private final ProductRepo productRepo;

    public TestStringLoader(TestStringRepo testStringRepo, ProductRepo productRepo) {
        this.testStringRepo = testStringRepo;
        this.productRepo = productRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
       /* testStringRepo.save(new TestString(1, "Priya"));
        testStringRepo.save(new TestString(2, "Piyu"));
        testStringRepo.save(new TestString(3, "Baba"));*/
        log.info("initial data loaded successfully");
      //  testStringRepo.findAll().forEach(a -> log.info(a.getName()));


     //  productRepo.save(new Product("name","dewscpriont","url",39.50, Boolean.FALSE,new Category("grofers")));
     /*  List<Product> productList=productRepo.findAll();
        for (Product product : productList) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName());
        }

        Object[] result = productRepo.findRawProductById(1L);
*/
    }
}
