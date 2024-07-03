package org.example.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CompteBancaire {
    private double solde;
    private LocalDate dateOuverture;
    private double fraisTenue;

    public CompteBancaire(double soldeInitial, LocalDate dateOuverture, double fraisTenue) {
        this.solde = soldeInitial;
        this.dateOuverture = dateOuverture;
        this.fraisTenue = fraisTenue;
    }

    public double calculerSolde(LocalDate dateActuelle) {
        long mois = ChronoUnit.MONTHS.between(dateOuverture, dateActuelle.plusDays(1));
        return solde - (mois * fraisTenue);
    }

    public void enregistrerFlux(double montant) {
        this.solde += montant;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(LocalDate dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public double getFraisTenue() {
        return fraisTenue;
    }

    public void setFraisTenue(double fraisTenue) {
        this.fraisTenue = fraisTenue;
    }
}
