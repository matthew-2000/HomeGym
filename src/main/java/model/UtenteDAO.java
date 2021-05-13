package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    public static Utente doRetrieveById(int id){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  utente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setEmail(rs.getString(2));
                u.setPasswordHash(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setCognome(rs.getString(5));
                u.setVia(rs.getString(6));
                u.setCap(rs.getInt(7));
                u.setPaese(rs.getString(8));
                u.setNumero(rs.getInt(9));
                u.setAdmin(rs.getBoolean(10));
                return u;
            }
            return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<Utente> doRetrieveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente");
            ResultSet rs = ps.executeQuery();
            List<Utente> lista = new ArrayList<>();
            while(rs.next()){
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setEmail(rs.getString(2));
                u.setPasswordHash(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setCognome(rs.getString(5));
                u.setVia(rs.getString(6));
                u.setCap(rs.getInt(7));
                u.setPaese(rs.getString(8));
                u.setNumero(rs.getInt(9));
                u.setAdmin(rs.getBoolean(10));
                lista.add(u);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static Utente  doRetrieveByEmailPassword(String email, String password){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " +
                    "utente WHERE email=? AND passwordHash=SHA1(?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setPasswordHash(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setAdmin(rs.getBoolean(6));
                return u;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void doSave(Utente utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (email, passwordHash, nome, cognome, via, cap, paese, numero) VALUES(?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getEmail());
            ps.setString(2, utente.getPasswordHash());
            ps.setString(3, utente.getNome());
            ps.setString(4, utente.getCognome());
            ps.setString(5, utente.getVia());
            ps.setInt(6, utente.getCap());
            ps.setString(7, utente.getPaese());
            ps.setInt(8, utente.getNumero());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
