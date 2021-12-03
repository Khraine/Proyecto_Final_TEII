//Si ya viste masomenos como funcionan las clases DAOimpl en ClientesDAOimpl entonces aqui será mas facil.
package com.emergentes.dao;

import com.emergentes.modelo.Cuentas;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentasDAOimpl extends ConexionDB implements CuentasDAO {

    //INSERTAR DATOS
    //usualmente yo solo copio y pego las lineas de codigo ya que se repiten, solo debes cambiar una o 2 cosas y tambien tener en cuenta
    //que tipo de dato estás subiendo o guardando, ojo con la Base de Datos y el Modelo.
    @Override
    public void insert(Cuentas cuentas) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into reg_cuentas (SALDO,COD_CLIENTE) values (?,?)");
            ps.setInt(1, cuentas.getSaldo());
            ps.setInt(2, cuentas.getCod_cliente());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    //Funcion para obtener una fila de datos y encapsularla.
    //Devuelve un objeto.
    //Ojo con el Id
    @Override
    public Cuentas getById(int id) throws Exception {
        Cuentas cts = new Cuentas();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from cuentas where ID_REGISTRO=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cts.setId_registro(rs.getInt("id_registro"));
                cts.setSaldo(rs.getInt("saldo"));
                cts.setFecha(rs.getDate("fecha"));
                cts.setCod_cliente(rs.getInt("cod_cliente"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cts;
    }

    //Funcion para obtener una lista de objetos de datos.
    //Devuelva una lista con muchos objetos
    //se usa al momento de mostrar varias filas de datos de 1 cliente
    @Override
    public List<Cuentas> getAll(int id) throws Exception {
        List<Cuentas> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM reg_cuentas WHERE COD_CLIENTE=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Cuentas>();
            while (rs.next()) {
                Cuentas cts = new Cuentas();
                cts.setId_registro(rs.getInt("id_registro"));
                cts.setSaldo(rs.getInt("saldo"));
                cts.setFecha(rs.getDate("fecha"));
                cts.setCod_cliente(rs.getInt("cod_cliente"));
                lista.add(cts);
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
