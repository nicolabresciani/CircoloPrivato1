package it.paleocapa.bresciani;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class CircoloPrivatoTest {

    private circoloPrivato circolo = new circoloPrivato();
    

    @Test
    public void testAggiungiSocio() {
        Socio socio1 = new Socio("Nicola", "luchini", 35, 'M');
        circolo.aggiungiSocio(socio1);
        assertEquals(1, circolo.getSoci().size());

        Socio socio2 = new Socio("federica", "bianchi", 40, 'F');
        circolo.aggiungiSocio(socio2);
        assertEquals(2, circolo.getSoci().size());
    }

    @Test
    public void testModificaSocio() {
        Socio socio = new Socio("Nicola", "luchini", 35, 'M');
        circolo.aggiungiSocio(socio);
        assertEquals(35, circolo.getSoci().get("Nicolaluchini").getEta());

        circolo.modificaSocio("Nicola", "luchini", 36, 'M');
        assertEquals(36, circolo.getSoci().get("Nicolaluchini").getEta());
    }

    @Test
    public void testRimuoviSocio() {
        Socio socio = new Socio("Nicola", "luchini", 35, 'M');
        circolo.aggiungiSocio(socio);
        assertEquals(1, circolo.getSoci().size());

        circolo.rimuoviSocio("Nicola", "luchini");
        assertEquals(0, circolo.getSoci().size());
    }

    @Test
    public void testCalcolaEtaMedia() {
        Socio socio1 = new Socio("Nicola", "luchini", 35, 'M');
        Socio socio2 = new Socio("federica", "bianchi", 40, 'F');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        double etaMedia = circolo.calcolaEtaMedia();
        assertEquals(37.5, etaMedia, 0.001);
    }

    @Test
    public void testCalcolaEtaMediaSesso() {
        Socio socio1 = new Socio("Nicola", "luchini", 35, 'M');
        Socio socio2 = new Socio("federica", "bianchi", 40, 'F');
        Socio socio3 = new Socio("Bianchi", "Luca", 25, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);

        double etaMediaMaschi = circolo.calcolaEtaMediaSesso('M');
        assertEquals(30.0, etaMediaMaschi, 0.001);

        double etaMediaFemmine = circolo.calcolaEtaMediaSesso('F');
        assertEquals(40.0, etaMediaFemmine, 0.001); 
    }

    @Test
    public void testCalcolaDistribuzionePercentualeSesso() {
        Socio socio1 = new Socio("Nicola", "luchini", 35, 'M');
        Socio socio2 = new Socio("federica", "bianchi", 40, 'F');
        Socio socio3 = new Socio("Bianchi", "Luca", 25, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);

        HashMap<Character, Double> distribuzioneSesso = circolo.calcolaDistribuzionePercentualeSesso();

        assertEquals(66.67, distribuzioneSesso.get('M'), 0.01); 
        assertEquals(33.33, distribuzioneSesso.get('F'), 0.01); 
    }
}
