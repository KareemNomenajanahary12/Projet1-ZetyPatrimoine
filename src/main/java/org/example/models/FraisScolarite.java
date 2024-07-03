package org.example.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FraisScolarite {
    private double fraisMensuels;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public FraisScolarite(double fraisMensuels, LocalDate dateDebut, LocalDate dateFin) {
        this.fraisMensuels = fraisMensuels;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public double calculerFraisTotal(LocalDate date) {
        long mois = ChronoUnit.MONTHS.between(dateDebut, dateFin.plusDays(1));
        return mois * fraisMensuels;
    }
}
