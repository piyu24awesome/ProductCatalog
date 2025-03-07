package org.example.productcatalogservice_feb2025.dataLoader;

import org.example.productcatalogservice_feb2025.models.joinedClass.CreditCardPayment;
import org.example.productcatalogservice_feb2025.models.joinedClass.Payment;
import org.example.productcatalogservice_feb2025.models.joinedClass.PaypalPayment;
import org.example.productcatalogservice_feb2025.repo.inheritance.PaymentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class PaymentDataloader implements CommandLineRunner {

    //constructor based dependency injection
    private final PaymentRepo paymentRepo;

    public PaymentDataloader(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }


    @Override
    public void run(String... args) throws Exception {

        paymentRepo.save(new CreditCardPayment(1L, 3000, "134556666"));
        paymentRepo.save(new CreditCardPayment(2L, 6000, "234566666"));
        paymentRepo.save(new PaypalPayment(3L, 2000, "P-123"));
        paymentRepo.save(new PaypalPayment(4L, 3000, "P-666"));

        //fetch all animals using polymorphic query
        List<Payment> payments = paymentRepo.findAll();
        payments.forEach(a -> System.out.println(a.getClass().getSimpleName()));


    }
}
