package com.emergentes.dao;
//PARA EJECUTAR ACCIONES DAO
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegCuentasDAOimpl extends ConexionDB implements RegCuentasDAO{
        @Override
    public int obtenerId(String ci) throws Exception {
        int id = 0;
        try {
            this.conectar();
            String sql = "select ID_CLIENTE from clientes where CEDULA_IDENTIDAD=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ci);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_cliente");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }

        return id;
    }
    
}
