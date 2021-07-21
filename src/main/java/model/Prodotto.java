package model;

import java.util.List;
import java.util.Objects;

public class Prodotto {

    private int id;
    private String nome;
    private double prezzo;
    private String descrizione;
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
        return !immagini.isEmpty() ? immagini.get(0) : "";
    }

    public void setImmagini(List<String> immagini) {
        if (immagini.isEmpty()) {
            immagini.add("./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/1.png");
            immagini.add("./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/2.png");
            immagini.add("./images/prodotti/Categoria 1/Gruppo 1 - Manubri e Pesi/KIT MANUBRI BODYBUILDING 20KG FILETTATI/3.png");
        }
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
        return id == prodotto.id && Double.compare(prodotto.prezzo, prezzo) == 0 &&
            idGruppo == prodotto.idGruppo && Objects.equals(nome, prodotto.nome) &&
            Objects.equals(descrizione, prodotto.descrizione) &&
            Objects.equals(immagini, prodotto.immagini);
    }

}
