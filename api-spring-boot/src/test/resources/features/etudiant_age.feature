Feature: Calcul de l'âge d'un étudiant

  Scenario: Étudiant né il y a 22 ans
    Given un étudiant avec la date de naissance "2003-04-07"
    When on calcule son âge
    Then l'âge retourné doit être 22

  Scenario: Date de naissance nulle
    Given un étudiant sans date de naissance
    When on calcule son âge
    Then l'âge retourné doit être 0