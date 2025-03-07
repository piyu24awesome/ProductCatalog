package org.example.productcatalogservice_feb2025.models.joinedClass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class CreditCardPayment extends Payment{

    String cardNumber;

    public CreditCardPayment(long id, double amount, String cardNumber) {
        this.id = id;
        this.amount = amount;
        this.cardNumber = cardNumber;
    }

    public CreditCardPayment() {

    }
}
