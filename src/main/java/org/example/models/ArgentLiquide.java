package org.example.models;

import java.time.LocalDate;

public class ArgentLiquide extends Possession {
    public ArgentLiquide(double valeurInitiale, LocalDate dateAchat) {
        super(valeurInitiale, dateAchat);
    }

    @Override
    public double calculerValeur(LocalDate date) {
        return valeurInitiale;
    }
}
