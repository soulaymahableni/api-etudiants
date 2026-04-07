package com.example.etudiants_api.steps;

import com.example.etudiants_api.Etudiant;
import io.cucumber.java.en.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EtudiantAgeSteps {

    private Etudiant etudiant;
    private int ageCalcule;

    @Given("un étudiant avec la date de naissance {string}")
    public void unEtudiantAvecDateDeNaissance(String dateStr) {
        etudiant = new Etudiant(null, "12345", "Dupont", LocalDate.parse(dateStr));
    }

    @Given("un étudiant sans date de naissance")
    public void unEtudiantSansDateDeNaissance() {
        etudiant = new Etudiant(null, "12345", "Dupont", null);
    }

    @When("on calcule son âge")
    public void onCalculeSonAge() {
        ageCalcule = etudiant.age();
    }

    @Then("l'âge retourné doit être {int}")
    public void lAgeRetournéDoitEtre(int ageAttendu) {
        assertThat(ageCalcule)
                .as("Âge attendu: %d, obtenu: %d", ageAttendu, ageCalcule)
                .isEqualTo(ageAttendu);
    }
}