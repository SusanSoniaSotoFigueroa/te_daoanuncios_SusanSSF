
package com.emergentes.dao;

import com.emergentes.modelo.Avisousuario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimplusuario extends ConexionBD implements AvisoDAOusuario {

    @Override
    public void insert(Avisousuario usuarios) throws Exception {
        String sql = "insert into usuarios (nombre,correo,clave) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuarios.getNombre());
        ps.setString(2, usuarios.getCorreo());
        ps.setString(3, usuarios.getClave());
        
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public void update(Avisousuario usuarios) throws Exception {
        String sql = "update usuarios set nombre=?, correo=?, clave=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,usuarios.getNombre());
        ps.setString(2,usuarios.getCorreo());
        ps.setString(3,usuarios.getClave());
        ps.setInt(4, usuarios.getId());
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public void delete(int id) throws Exception {
        
        String sql = "delete from usuarios where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public List<Avisousuario> getAll() throws Exception {
        
          List<Avisousuario> lista = null;
        String sql = "select * from usuarios ";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Avisousuario>();
        while(rs.next()){
            Avisousuario avi = new Avisousuario();
            
            avi.setId(rs.getInt("id"));
            avi.setNombre(rs.getString("nombre"));
            avi.setCorreo(rs.getString("correo"));
            avi.setClave(rs.getString("clave"));
            
            lista.add(avi);
        }
        this.desconectar();
        return lista;

    }

    @Override
    public Avisousuario getById(int id) throws Exception {
        
         Avisousuario avi = new Avisousuario();
        try {
            String sql = "select * from usuarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                avi.setId(rs.getInt("id"));
                avi.setNombre(rs.getString("nombre"));
                avi.setCorreo(rs.getString("correo"));
                avi.setClave(rs.getString("clave"));
            }
        } catch (SQLException e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return avi;
    

    }

    
    
}
