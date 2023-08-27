package it.paleocapa.bresciani;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Creazione di un nuovo circolo privato
        circoloPrivato circolo = new circoloPrivato();

        // Aggiunta di alcuni soci
        Socio socio1 = new Socio("Nicola", "luchini", 35, 'M');
        Socio socio2 = new Socio("federica", "bianchi", 40, 'F');
        Socio socio3 = new Socio("bianchi", "luca", 25, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);

        // Modifica di un socio esistente
        circolo.modificaSocio("Nicola", "luchini", 36, 'M');

        // Calcolo dell'età media
        double etaMediaTotale = circolo.calcolaEtaMedia();
        System.out.println("Età media dei soci: " + etaMediaTotale);

        // Calcolo dell'età media dei soci di sesso maschile
        double etaMediaMaschi = circolo.calcolaEtaMediaSesso('M');
        System.out.println("Età media dei soci maschi: " + etaMediaMaschi);

        // Calcolo dell'età media dei soci di sesso femminile
        double etaMediaFemmine = circolo.calcolaEtaMediaSesso('F');
        System.out.println("Età media dei soci femmine: " + etaMediaFemmine);

        // Calcolo della distribuzione percentuale dei soci in base al sesso
        HashMap<Character, Double> distribuzioneSesso = circolo.calcolaDistribuzionePercentualeSesso();
        System.out.println("Distribuzione percentuale dei soci maschi: " + distribuzioneSesso.get('M') + "%");
        System.out.println("Distribuzione percentuale dei soci femmine: " + distribuzioneSesso.get('F') + "%");


        // Rimozione di un socio
        circolo.rimuoviSocio("bianchi", "luca");

        
    }
}