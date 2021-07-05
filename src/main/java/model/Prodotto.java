package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prodotto {

    private int id;
    private String nome;
    private double prezzo;
    private String descrizione;
    private int quantita;
    private double voto;
    private int idGruppo;
    private List<String> immagini;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getVoto() {
        return voto;
    }

    public void setVoto(double voto) {
        this.voto = voto;
    }

    public int getIdGruppo() {
        return idGruppo;
    }

    public void setIdGruppo(int idGruppo) {
        this.idGruppo = idGruppo;
    }

    public void addImagine(String immagine) {
        immagini.add(immagine);
    }

    public String getFirstImmagine() {
        return immagini.get(0);
    }

    public void setImmagini(List<String> immagini) {
        this.immagini = immagini;
    }

    public List<String> getImmagini() {
        return immagini;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prodotto prodotto = (Prodotto) o;
        return id == prodotto.id && idGruppo == prodotto.idGruppo &&
            Objects.equals(nome, prodotto.nome);
    }

}
