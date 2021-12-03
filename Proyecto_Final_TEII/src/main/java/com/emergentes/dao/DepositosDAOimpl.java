package com.emergentes.dao;
import com.emergentes.modelo.Depositos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

public class DepositosDAOimpl extends ConexionDB implements DepositosDAO{
    
    @Override
    public void insert(Depositos depositos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into movimientos (MONTO,TIPO,COD_CLI) values (?,'DEPOSITO',?)");
            ps.setInt(1, depositos.getMonto());
            ps.setInt(2,depositos.getCod_cli());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Depositos depositos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Depositos getById(int id) throws Exception {
        Depositos dep = new Depositos();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM movimientos WHERE ID_CLIENTE=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                dep.setId_registro(rs.getInt("id_registro"));
                dep.setMonto(rs.getInt("monto"));
                dep.setFecha(rs.getDate("fecha"));
                dep.setCod_cli(rs.getInt("cod_cli"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return dep;
    }

    @Override
    public List<Depositos> getAll(int id) throws Exception {
        List<Depositos> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from movimientos where ID_CLIENTE=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            lista = new ArrayList<Depositos>();
            while (rs.next()) {
                Depositos dep = new Depositos();
                dep.setId_registro(rs.getInt("id_registro"));
                dep.setMonto(rs.getInt("monto"));
                dep.setFecha(rs.getDate("fecha"));
                dep.setCod_cli(rs.getInt("cod_cli"));
                lista.add(dep);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
