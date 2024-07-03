package org.example.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CompteBancaire {
    private double soldeInitial;
    private LocalDate dateDebut;
    private double fraisMensuels;

    public CompteBancaire(double soldeInitial, LocalDate dateDebut, double fraisMensuels) {
        this.soldeInitial = soldeInitial;
        this.dateDebut = dateDebut;
        this.fraisMensuels = fraisMensuels;
    }

    public double calculerSolde(LocalDate date) {
        long mois = ChronoUnit.MONTHS.between(dateDebut, date.plusDays(1));
        return soldeInitial - (mois * fraisMensuels);
    }
}
