package model;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.crypto.Data;

public class Ordine {

  private int id;
  private ArrayList<ProdottoCarrello> prodotti;
  private Date dataOrdine;

  public Ordine(ArrayList<ProdottoCarrello> listaProdotti, Date dataOrdine) {
    this.prodotti = listaProdotti;
    this.dataOrdine = dataOrdine;
  }

  public Ordine(Date dataOrdine) {
    this.dataOrdine = dataOrdine;
    prodotti = new ArrayList<>();
  }

  public Ordine() {
    prodotti = new ArrayList<>();
  }

  public ArrayList<ProdottoCarrello> getProdotti() {
    return prodotti;
  }

  public void setProdotti(ArrayList<ProdottoCarrello> listaProdotti) {
    this.prodotti = listaProdotti;
  }

  public Date getDataOrdine() {
    return dataOrdine;
  }

  public void setDataOrdine(Date dataOrdine) {
    this.dataOrdine = dataOrdine;
  }

  public void addProdotto(ProdottoCarrello prodottoCarrello) {
    int index = prodotti.indexOf(prodottoCarrello);
    if(index != -1) {
      prodotti.get(index).incrementQuantita(prodottoCarrello.getQuantita());
    } else {
      prodotti.add(prodottoCarrello);
    }
  }

  public void removeProdotto(int idProdotto) {
    prodotti.removeIf(p -> p.getProdotto().getId() == idProdotto);
  }

  public float getPrezzoTotale() {
    float tot = 0;
    for (ProdottoCarrello p : prodotti) {
      tot += p.getProdotto().getPrezzo() * p.getQuantita();
    }
    return tot;
  }

  public int getQuantitaTotale() {
    int tot = 0;
    for (ProdottoCarrello p : prodotti) {
      tot += p.getQuantita();
    }
    return tot;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
