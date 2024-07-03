package org.example.models;

import java.time.LocalDate;

public abstract class Possession {
    protected double valeurInitiale;
    protected LocalDate dateAchat;

    public Possession(double valeurInitiale, LocalDate dateAchat) {
        this.valeurInitiale = valeurInitiale;
        this.dateAchat = dateAchat;
    }

    public abstract double calculerValeur(LocalDate date);
}
