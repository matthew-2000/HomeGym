package model;

import java.util.ArrayList;

public class Categoria {

    private int id;
    private String nome;
    private String descrizione;
    private ArrayList<Gruppo> listaGruppi;

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void addGruppo(Gruppo g) {
        listaGruppi.add(g);
    }

    public void setListaGruppi(ArrayList<Gruppo> listaGruppi) {
        this.listaGruppi = listaGruppi;
    }

    public ArrayList<Gruppo> getListaGruppi() {
        return listaGruppi;
    }

}
