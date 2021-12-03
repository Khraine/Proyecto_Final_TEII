//Si ya viste el CuentasDAOimpl y ClientesDAOimpl es lo mismo
package com.emergentes.dao;
import com.emergentes.modelo.Movimientos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class MovimientosDAOimpl extends ConexionDB implements MovimientosDAO{
    //Funcion para insertar
    @Override
    public void insert(Movimientos movimientos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into movimientos(MONTO,FECHA,TIPO,COD_CLI) values (?,?,?,?)");
            ps.setInt(1, movimientos.getMonto());
            ps.setDate(2, movimientos.getFecha());
            ps.setString(3, movimientos.getTipo());
            ps.setInt(4, movimientos.getCod_cli());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    //funcion para actualizar
    @Override
    public void update(Movimientos movimientos) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update movimientos set MONTO=?,FECHA=?,TIPO=?,COD_CLI=? WHERE ID_REGISTRO=?");
            ps.setInt(1, movimientos.getMonto());
            ps.setDate(2, movimientos.getFecha());
            ps.setString(3, movimientos.getTipo());
            ps.setInt(4, movimientos.getCod_cli());
            ps.setInt(5, movimientos.getId_registro());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    //Funcion que devuelve un objeto con los datos extraidos de una consulta que devuelve una sola fila utilizando el ID del cliente.
    @Override
    public Movimientos getById(int id) throws Exception {
        Movimientos mov = new Movimientos();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from movimientos where ID_REGISTRO=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                mov.setId_registro(rs.getInt("id_registro"));
                mov.setMonto(rs.getInt("monto"));
                mov.setFecha(rs.getDate("fecha"));
                mov.setTipo(rs.getString("tipo"));
                mov.setCod_cli(rs.getInt("cod_cli"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return mov;
    //Funcion para devolver una lista de objetos con los datos extraidos de una consulta que devuelve varias filas de datos utilizando el ID del cliente.
    }
    @Override
    public List<Movimientos> getAll(int id) throws Exception {
        List<Movimientos> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from movimientos WHERE COD_CLI=? ORDER BY ID_REGISTRO DESC");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            lista = new ArrayList<Movimientos>();
            while (rs.next()) {
                Movimientos mov = new Movimientos();
                mov.setId_registro(rs.getInt("id_registro"));
                mov.setMonto(rs.getInt("monto"));
                mov.setFecha(rs.getDate("fecha"));
                mov.setTipo(rs.getString("tipo"));
                mov.setCod_cli(rs.getInt("cod_cli"));
                lista.add(mov);
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
