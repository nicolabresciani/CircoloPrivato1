package it.paleocapa.bresciani;

public class Socio {
    private String nome;
    private String cognome;
    private int eta;
    private char sesso;

    public Socio(String nome, String cognome, int eta, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.sesso = sesso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public void incrementaEta() {
        eta++;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }
}