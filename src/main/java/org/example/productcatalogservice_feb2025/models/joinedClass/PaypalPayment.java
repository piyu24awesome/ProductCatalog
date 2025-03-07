package org.example.productcatalogservice_feb2025.models.joinedClass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class PaypalPayment extends Payment {

    String paypalAccount;

    public PaypalPayment() {

    }
    public PaypalPayment( long id, double amount, String paypalAccount) {
        this.id = id;
        this.amount = amount;
        this.paypalAccount = paypalAccount;
    }

}
