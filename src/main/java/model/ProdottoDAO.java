package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public static Prodotto doRetrieveById(int id){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  prodotto WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setDescrizione(rs.getString(4));
                p.setQuantita(rs.getInt(5));
                p.setVoto(rs.getDouble(6));
                p.setIdGruppo(rs.getInt(8));
                return p;
            }
            return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<Prodotto> doRetrieveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM prodotto");
            ResultSet rs = ps.executeQuery();
            List<Prodotto> lista = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setDescrizione(rs.getString(4));
                p.setQuantita(rs.getInt(5));
                p.setVoto(rs.getDouble(6));
                p.setIdGruppo(rs.getInt(8));
                lista.add(p);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<Prodotto> doRetrieveByIdGruppo(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM prodotto WHERE idGruppo=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            List<Prodotto> lista = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setDescrizione(rs.getString(4));
                p.setQuantita(rs.getInt(5));
                p.setVoto(rs.getDouble(6));
                p.setIdGruppo(rs.getInt(8));
                lista.add(p);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static void doSave(Prodotto prodotto){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodotto (nome, prezzo, descrizione, quantita, voto, idGruppo) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prodotto.getNome());
            ps.setDouble(2, prodotto.getPrezzo());
            ps.setString(3, prodotto.getDescrizione());
            ps.setInt(4, prodotto.getQuantita());
            ps.setDouble(5, prodotto.getVoto());
            ps.setInt(6, prodotto.getIdGruppo());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            prodotto.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doDelete(int id){
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("delete from prodotto where id=?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static void doUpdate(Prodotto prodotto){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE prodotto SET nome=?, prezzo=?, descrizione=?, quantita=?, voto=?, idGruppo=? WHERE id=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prodotto.getNome());
            ps.setDouble(2, prodotto.getPrezzo());
            ps.setString(3, prodotto.getDescrizione());
            ps.setInt(4, prodotto.getQuantita());
            ps.setDouble(5, prodotto.getVoto());
            ps.setInt(6, prodotto.getIdGruppo());
            ps.setInt(7, prodotto.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Prodotto> doRetrieveByNome(String against, int offset, int limit) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM prodotto WHERE MATCH(nome) AGAINST(? IN BOOLEAN MODE) LIMIT ?, ?");
            ps.setString(1, against);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setDescrizione(rs.getString(4));
                p.setQuantita(rs.getInt(5));
                p.setVoto(rs.getDouble(6));
                p.setIdGruppo(rs.getInt(8));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
