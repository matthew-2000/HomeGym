package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImmaginiProdottiDAO {

    public static List<ImmaginiProdotti> doRetrieveById(int id){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  immaginiprodotto WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ImmaginiProdotti> lista = new ArrayList<>();
            while(rs.next()){
                ImmaginiProdotti im = new ImmaginiProdotti();
                im.setId(rs.getInt(1));
                im.setIdProdotto(rs.getInt(2));
                im.setPath(rs.getString(3));
                lista.add(im);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<ImmaginiProdotti> doRetrieveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM immaginiprodotto");
            ResultSet rs = ps.executeQuery();
            List<ImmaginiProdotti> lista = new ArrayList<>();
            while(rs.next()){
                ImmaginiProdotti im = new ImmaginiProdotti();
                im.setId(rs.getInt(1));
                im.setIdProdotto(rs.getInt(2));
                im.setPath(rs.getString(3));
                lista.add(im);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<ImmaginiProdotti> doRetrieveByIdProduct(int idProdotto){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM immaginiprodotto WHERE id=?");
            ps.setInt(1, idProdotto);
            ResultSet rs = ps.executeQuery();
            List<ImmaginiProdotti> lista = new ArrayList<>();
            while(rs.next()){
                ImmaginiProdotti im = new ImmaginiProdotti();
                im.setId(rs.getInt(1));
                im.setIdProdotto(rs.getInt(2));
                im.setPath(rs.getString(3));
                lista.add(im);
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
