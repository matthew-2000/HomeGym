package model;

import java.util.Objects;

public class ProdottoCarrello {

  private Prodotto prodotto;
  private int quantita;

  public ProdottoCarrello(Prodotto prodotto, int quantita) {
    this.prodotto = prodotto;
    this.quantita = quantita;
  }

  public Prodotto getProdotto() {
    return prodotto;
  }

  public void setProdotto(Prodotto prodotto) {
    this.prodotto = prodotto;
  }

  public int getQuantita() {
    return quantita;
  }

  public void setQuantita(int quantita) {
    this.quantita = quantita;
  }

  public void incrementQuantita(int increment) {
    this.quantita += increment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProdottoCarrello that = (ProdottoCarrello) o;
    return Objects.equals(prodotto, that.prodotto);
  }

}
