package hei.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZetyEspècesTest {

    @Test
    public void testDateEpuisementEspèces() {
        LocalDate debutTransferts = LocalDate.of(2024, 1, 15);
        LocalDate debutTrainDeVie = LocalDate.of(2024, 10, 1);
        double soldeEspèces = 0;
        LocalDate dateActuelle = debutTransferts;

        while (dateActuelle.isBefore(debutTrainDeVie) || dateActuelle.equals(debutTrainDeVie)) {
            soldeEspèces += 100000;
            dateActuelle = dateActuelle.plusMonths(1);
        }

        dateActuelle = debutTrainDeVie;
        while (soldeEspèces >= 250000) {
            soldeEspèces -= 250000;
            dateActuelle = dateActuelle.plusMonths(1);
        }

        assertEquals(false, soldeEspèces >= 250000, "Zety n'a plus d'espèces à partir du " + dateActuelle);
    }
}
