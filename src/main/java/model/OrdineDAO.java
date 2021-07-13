package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
