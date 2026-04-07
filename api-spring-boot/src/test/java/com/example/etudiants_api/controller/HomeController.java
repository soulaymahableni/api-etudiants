package com.example.etudiants_api.controller;

import com.example.etudiants_api.Etudiant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return List.of(
                new Etudiant(1L, "123456", "Soulayma", null)
        );
    }
}