package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdineDAO {

  public static ArrayList<Ordine> doRetrieveAllByIdUtente(int idUtente){
    try(Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT * FROM ordine WHERE idUtente=?");
      ps.setInt(1, idUtente);
      ResultSet rs = ps.executeQuery();
      ArrayList<Ordine> listaOrdini = new ArrayList<>();
      while (rs.next()) {

        Ordine ordine = new Ordine();
        ordine.setId(rs.getInt(1));
        ordine.setDataOrdine(rs.getDate(2));
        PreparedStatement ps2 = con.prepareStatement("SELECT * FROM ordineProdotto WHERE idOrdine=?");
        ps2.setInt(1, rs.getInt(1));
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
          ProdottoCarrello prodottoCarrello = new ProdottoCarrello(ProdottoDAO.doRetrieveById(rs2.getInt(4)), rs2.getInt(2));
          prodottoCarrello.getProdotto().setImmagini(ImmaginiProdottiDAO.doRetrieveByIdProduct(prodottoCarrello.getProdotto().getId()));
          ordine.addProdotto(prodottoCarrello);
        }
        listaOrdini.add(ordine);
      }
      if (listaOrdini.size() > 0)
        return listaOrdini;

      return null;
    }catch (SQLException ex){
      throw new RuntimeException(ex);
    }
  }

  public static void doSave(Carrello carrello, int idUtente){
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO ordine (dataOrdine, idUtente) VALUES (curdate(), ?)", Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, idUtente);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        for (ProdottoCarrello prodottoCarrello: carrello.getProdotti()) {
          PreparedStatement ps2 = con.prepareStatement(
              "INSERT INTO ordineProdotto (quantita, idOrdine, idProdotto) VALUES (?, ?, ?)");
          ps2.setInt(1, prodottoCarrello.getQuantita());
          ps2.setInt(2, rs.getInt(1));
          ps2.setInt(3, prodottoCarrello.getProdotto().getId());
          if (ps2.executeUpdate() != 1) {
            throw new RuntimeException("INSERT error.");
          }
        }

      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
