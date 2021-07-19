package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GruppoDAO {

    public static Gruppo doRetrieveById(int id){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  gruppo WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Gruppo g = new Gruppo();
                g.setId(rs.getInt(1));
                g.setNome(rs.getString(2));
                g.setIdCategoria(rs.getInt(3));
                return g;
            }
            return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<Gruppo> doRetrieveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gruppo");
            ResultSet rs = ps.executeQuery();
            List<Gruppo> lista = new ArrayList<>();
            while(rs.next()){
                Gruppo g = new Gruppo();
                g.setId(rs.getInt(1));
                g.setNome(rs.getString(2));
                g.setIdCategoria(rs.getInt(3));
                lista.add(g);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<Gruppo> doRetrieveByIdCategoria(int idCategoria){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  gruppo WHERE idCategoria=?");
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            List<Gruppo> lista = new ArrayList<>();
            while(rs.next()){
                Gruppo g = new Gruppo();
                g.setId(rs.getInt(1));
                g.setNome(rs.getString(2));
                g.setIdCategoria(rs.getInt(3));
                lista.add(g);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static void doSave(Gruppo gruppo){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO gruppo (nome, idCategoria) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gruppo.getNome());
            ps.setInt(2, gruppo.getIdCategoria());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            gruppo.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doDelete(int id){
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("delete from gruppo where id=?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static void doUpdate(Gruppo gruppo){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE gruppo SET nome=?, idCategoria=? WHERE id=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gruppo.getNome());
            ps.setInt(2, gruppo.getIdCategoria());
            ps.setInt(3, gruppo.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
