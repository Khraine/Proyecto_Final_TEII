package com.emergentes.dao;
import com.emergentes.modelo.Retiros;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

public class RetirosDAOimpl extends ConexionDB implements RetirosDAO{

    @Override
    public void insert(Retiros retiros) throws Exception {
         try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into movimientos (MONTO,TIPO,COD_CLI) values (?,'RETIRO',?)");
            ps.setInt(1, retiros.getMonto());
            ps.setInt(2,retiros.getCod_cli());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Retiros retiros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retiros getById(int id) throws Exception {
        Retiros ret = new Retiros();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM movimientos WHERE ID_CLIENTE=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                ret.setId_registro(rs.getInt("id_registro"));
                ret.setMonto(rs.getInt("monto"));
                ret.setFecha(rs.getDate("fecha"));
                ret.setCod_cli(rs.getInt("cod_cli"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ret;
    }

    @Override
    public List<Retiros> getAll(int id) throws Exception {
        List<Retiros> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from movimientos where ID_CLIENTE=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            lista = new ArrayList<Retiros>();
            while (rs.next()) {
                Retiros ret = new Retiros();
                ret.setId_registro(rs.getInt("id_registro"));
                ret.setMonto(rs.getInt("monto"));
                ret.setFecha(rs.getDate("fecha"));
                ret.setCod_cli(rs.getInt("cod_cli"));
                lista.add(ret);
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
