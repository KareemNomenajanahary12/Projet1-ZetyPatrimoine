package org.example.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vetements extends Possession {
    public static final double TAUX_DEPRECIATION_ANNUEL = -0.50;

    public Vetements(double valeurInitiale, LocalDate dateAchat) {
        super(valeurInitiale, dateAchat);
    }

    @Override
    public double calculerValeur(LocalDate date) {
        long jours = ChronoUnit.DAYS.between(dateAchat, date);
        double tauxDepreciationJournalier = Math.pow(1 + TAUX_DEPRECIATION_ANNUEL, 1.0 / 365) - 1;
        return valeurInitiale * Math.pow(1 + tauxDepreciationJournalier, jours);
    }
}
