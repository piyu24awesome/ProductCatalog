package org.example.productcatalogservice_feb2025.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, updatable = false)
    Instant createdDate;
    @Column(nullable = false)
    Instant lastUpdatedAt;
    @Enumerated(EnumType.STRING) // Ensures `State` is stored as a String
    State state;

    @PrePersist
    protected void onCreate() {
        //Runs before a new entity is saved in the database.
        createdDate = Instant.now();
        lastUpdatedAt = Instant.now();
        state = State.ACTIVE;
    }
    @PreUpdate
    protected  void onUpdate() {
        //Runs before an entity is updated in the database.
        lastUpdatedAt = Instant.now();
    }
}
