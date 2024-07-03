package hei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;
import org.example.models.CompteBancaire; // Assure-toi que cette importation est correcte

public class ZetyEndettementTest {

    @Test
    public void testDiminutionPatrimoine() {
        LocalDate dateAvantEndettement = LocalDate.of(2024, 9, 17);
        LocalDate dateApresEndettement = LocalDate.of(2024, 9, 18);

        CompteBancaire compteBancaire = new CompteBancaire(5220000, LocalDate.of(2023, 9, 18), 0); // Assure-toi que les valeurs sont correctes
        double patrimoineAvant = calculerPatrimoineTotal(compteBancaire, dateAvantEndettement);


        compteBancaire.enregistrerFlux(10000000);

        double patrimoineApres = calculerPatrimoineTotal(compteBancaire, dateApresEndettement);


        double diminutionPatrimoine = patrimoineAvant - patrimoineApres;


        System.out.println("Patrimoine avant endettement : " + patrimoineAvant);
        System.out.println("Patrimoine après endettement : " + patrimoineApres);
        System.out.println("Diminution du patrimoine : " + diminutionPatrimoine);

        assertEquals(11000000, diminutionPatrimoine, 0.01);
    }


    private double calculerPatrimoineTotal(CompteBancaire compteBancaire, LocalDate date) {
        double valeurOrdinateur = 1200000;
        double valeurVetements = 1500000;
        double valeurArgentLiquide = 800000;
        double valeurFraisScolarite = 200000 * ChronoUnit.MONTHS.between(LocalDate.of(2023, 11, 27), date.plusDays(1)); // Frais de scolarité accumulés
        double valeurCompteBancaire = compteBancaire.calculerSolde(date);

        return valeurOrdinateur + valeurVetements + valeurArgentLiquide + valeurFraisScolarite + valeurCompteBancaire;
    }
}
