package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
