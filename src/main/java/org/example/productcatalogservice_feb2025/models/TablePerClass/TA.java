package org.example.productcatalogservice_feb2025.models.TablePerClass;

import jakarta.persistence.Entity;

@Entity
public class TA extends InheritanceUser {
    int noOfHelpRequests;


    public TA( long id, String name , String email, int noOfHelpRequests ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.noOfHelpRequests = noOfHelpRequests;

    }

    public TA() {

    }
}
