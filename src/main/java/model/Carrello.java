package model;

import java.util.ArrayList;

public class Carrello {

  private ArrayList<ProdottoCarrello> prodotti;

  public Carrello(ArrayList<ProdottoCarrello> prodotti) {
    this.prodotti = prodotti;
  }

  public Carrello() {
    this.prodotti = new ArrayList<>();
  }

  public ArrayList<ProdottoCarrello> getProdotti() {
    return prodotti;
  }

  public void setProdotti(ArrayList<ProdottoCarrello> prodotti) {
    this.prodotti = prodotti;
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

}
