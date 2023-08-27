package it.paleocapa.bresciani;

import java.util.*;

public class circoloPrivato {
    private HashMap<String, Socio> soci; // La chiave sarà la concatenazione di nome e cognome del socio

    public circoloPrivato() {
        soci = new HashMap<>();
    }

    public void aggiungiSocio(Socio socio) {
        soci.put(socio.getNome() + socio.getCognome(), socio);
        System.out.println("Socio aggiunto correttamente.");
    }

    public void modificaSocio(String nome, String cognome, int nuovaEta, char nuovoSesso) {
        String key = nome + cognome;
        Socio socio = soci.get(key);
        if (socio != null) {
            socio.setSesso(nuovoSesso);
            socio.incrementaEta();
            System.out.println("Socio modificato correttamente.");
        } else {
            System.out.println("Socio non trovato.");
        }
    }

    public void rimuoviSocio(String nome, String cognome) {
        String key = nome + cognome;
        Socio socio = soci.remove(key);
        if (socio != null) {
            System.out.println("Socio rimosso correttamente.");
        } else {
            System.out.println("Socio non trovato.");
        }
    }

    public double calcolaEtaMedia() {
        int sommaEta = 0;
        for (Socio socio : soci.values()) {
            sommaEta += socio.getEta();
        }
        return (double) sommaEta / soci.size();
    }

    public double calcolaEtaMediaSesso(char sesso) {
        int sommaEta = 0;
        int conteggioSoci = 0;
        for (Socio socio : soci.values()) {
            if (socio.getSesso() == sesso) {
                sommaEta += socio.getEta();
                conteggioSoci++;
            }
        }
        if (conteggioSoci == 0) {
            return 0;
        }
        return (double) sommaEta / conteggioSoci;
    }

    public HashMap<Character, Double> calcolaDistribuzionePercentualeSesso() {
        HashMap<Character, Double> distribuzione = new HashMap<>();
        int conteggioMaschi = 0;
        int conteggioFemmine = 0;
        for (Socio socio : soci.values()) {
            if (socio.getSesso() == 'M') {
                conteggioMaschi++;
            } else if (socio.getSesso() == 'F') {
                conteggioFemmine++;
            }
        }
        int conteggioTotale = conteggioMaschi + conteggioFemmine;
        if (conteggioTotale > 0) {
            double percentualeMaschi = (double) conteggioMaschi / conteggioTotale * 100;
            double percentualeFemmine = (double) conteggioFemmine / conteggioTotale * 100;
            distribuzione.put('M', percentualeMaschi);
            distribuzione.put('F', percentualeFemmine);
        }
        return distribuzione;
    }
    public HashMap<String, Socio> getSoci() {
        return soci;
    }
}