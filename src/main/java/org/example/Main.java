package org.example;

import org.example.models.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate dateDebut = LocalDate.of(2023, 11, 1);
        LocalDate dateAujourdhui = LocalDate.of(2024, 9, 17);

        Ordinateur ordinateur = new Ordinateur(1200000, dateDebut);
        Vetements vetements = new Vetements(1500000, dateDebut);
        ArgentLiquide argentLiquide = new ArgentLiquide(800000, dateDebut);
        FraisScolarite fraisScolarite = new FraisScolarite(200000, dateDebut, LocalDate.of(2024, 8, 27));
        CompteBancaire compteBancaire = new CompteBancaire(100000, dateDebut, 20000);

        double valeurOrdinateur = ordinateur.calculerValeur(dateAujourdhui);
        double valeurVetements = vetements.calculerValeur(dateAujourdhui);
        double valeurArgentLiquide = argentLiquide.calculerValeur(dateAujourdhui);
        double soldeCompteBancaire = compteBancaire.calculerSolde(dateAujourdhui);

        double patrimoineTotal = valeurOrdinateur + valeurVetements + valeurArgentLiquide + soldeCompteBancaire - fraisScolarite.calculerFraisTotal(dateAujourdhui);

        System.out.println("Valeur totale du patrimoine de Zety le 17 septembre 2024 : " + patrimoineTotal + " Ar");
    }
}
