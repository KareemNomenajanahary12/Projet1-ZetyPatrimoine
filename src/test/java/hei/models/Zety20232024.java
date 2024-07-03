package hei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.models.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

public class Zety20232024 {

    @Test
    public void testCalculerValeurOrdinateur() {
        LocalDate dateAchat = LocalDate.of(2023, 7, 3);
        LocalDate dateAujourdhui = LocalDate.of(2024, 9, 17);

        Ordinateur ordinateur = new Ordinateur(1200000, dateAchat);
        double valeurAttendue = ordinateur.calculerValeur(dateAujourdhui);


        long jours = ChronoUnit.DAYS.between(dateAchat, dateAujourdhui);
        double tauxDepreciationJournalier = Math.pow(1 + Ordinateur.TAUX_DEPRECIATION_ANNUEL, 1.0 / 365) - 1;
        double valeurAttendueCalcul = 1200000 * Math.pow(1 + tauxDepreciationJournalier, jours);

        assertEquals(valeurAttendueCalcul, valeurAttendue, 0.01);
    }

    @Test
    public void testCalculerValeurVetements() {
        LocalDate dateAchat = LocalDate.of(2023, 7, 3);
        LocalDate dateAujourdhui = LocalDate.of(2024, 9, 17);

        Vetements vetements = new Vetements(1500000, dateAchat);
        double valeurAttendue = vetements.calculerValeur(dateAujourdhui);


        long jours = ChronoUnit.DAYS.between(dateAchat, dateAujourdhui);
        double tauxDepreciationJournalier = Math.pow(1 + Vetements.TAUX_DEPRECIATION_ANNUEL, 1.0 / 365) - 1;
        double valeurAttendueCalcul = 1500000 * Math.pow(1 + tauxDepreciationJournalier, jours);

        assertEquals(valeurAttendueCalcul, valeurAttendue, 0.01);
    }

    @Test
    public void testCalculerFraisScolarite() {
        LocalDate dateDebut = LocalDate.of(2023, 11, 27);
        LocalDate dateFin = LocalDate.of(2024, 8, 27);
        LocalDate dateAujourdhui = LocalDate.of(2024, 9, 17);

        FraisScolarite fraisScolarite = new FraisScolarite(200000, dateDebut, dateFin);
        double valeurAttendue = fraisScolarite.calculerFraisTotal(dateAujourdhui);


        long mois = ChronoUnit.MONTHS.between(dateDebut, dateFin.plusDays(1));
        double valeurAttendueCalcul = mois * 200000;

        assertEquals(valeurAttendueCalcul, valeurAttendue, 0.01);
    }

    @Test
    public void testCalculerSoldeCompteBancaire() {
        LocalDate dateDebut = LocalDate.of(2023, 11, 25);
        LocalDate dateAujourdhui = LocalDate.of(2024, 9, 17);

        CompteBancaire compteBancaire = new CompteBancaire(100000, dateDebut, 20000);
        double valeurAttendue = compteBancaire.calculerSolde(dateAujourdhui);


        long mois = ChronoUnit.MONTHS.between(dateDebut, dateAujourdhui.plusDays(1));
        double valeurAttendueCalcul = 100000 - (mois * 20000);

        assertEquals(valeurAttendueCalcul, valeurAttendue, 0.01);
    }

    @Test
    public void testCalculerArgentLiquide() {
        LocalDate dateAchat = LocalDate.of(2023, 7, 3);
        ArgentLiquide argentLiquide = new ArgentLiquide(800000, dateAchat);

        double valeurAttendue = argentLiquide.calculerValeur(LocalDate.of(2024, 9, 17));


        double valeurAttendueCalcul = 800000;

        assertEquals(valeurAttendueCalcul, valeurAttendue, 0.01);
    }
}
