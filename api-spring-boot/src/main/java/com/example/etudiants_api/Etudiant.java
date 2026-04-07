// src/main/java/com/example/etudiants_api/Etudiant.java
package com.example.etudiants_api;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cin;
    private String nom;
    private LocalDate dateNaissance;

    @JsonIgnore
    public int age() {
        if (this.dateNaissance == null) {
            return 0;
        }
        return Period.between(this.dateNaissance, LocalDate.now()).getYears();
    }

    @JsonProperty("age")
    public int getAgeForJson() {
        return age();
    }
}