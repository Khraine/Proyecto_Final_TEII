//Esto es una clase Java normal, que extiende la Conexion a la BD e implementa los metodos creados en las Interfaces DAO
package com.emergentes.dao;
import com.emergentes.modelo.Clientes;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
public class ClientesDAOimpl extends ConexionDB implements ClientesDAO{
    //Sin mucho lio solo la accion de Insertar un registro, siempre tiene que ir tal y como está su sintaxis.
    //los signos de admiracion referencian los campos que queremos guardar y son representados debajo, en orden por un Numero y encapsulados.
    @Override
    public void insert(Clientes clientes) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into clientes (NOMBRES,APELLIDOS,CEDULA_IDENTIDAD,SEXO,DIRECCION,CELULAR,CORREO) values (?,?,?,?,?,?,?)");
            ps.setString(1, clientes.getNombres());
            ps.setString(2, clientes.getApellidos());
            ps.setString(3, clientes.getCedula_identidad());
            ps.setString(4, clientes.getSexo());
            ps.setString(5, clientes.getDireccion());
            ps.setString(6, clientes.getCelular());
            ps.setString(7, clientes.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    //ACTUALIZACION DE DATOS
    //Similar al anterior con la diferencia que al ultimo (?) referenciamos al ID
    @Override
    public void update(Clientes clientes) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps =this.conn.prepareStatement("update clientes set NOMBRES=?,APELLIDOS=?,CEDULA_IDENTIDAD=?, SEXO=?,DIRECCION=?,CELULAR=?,CORREO=? where ID_CLIENTE=?");
            ps.setString(1, clientes.getNombres());
            ps.setString(2, clientes.getApellidos());
            ps.setString(3, clientes.getCedula_identidad());
            ps.setString(4, clientes.getSexo());
            ps.setString(5, clientes.getDireccion());
            ps.setString(6, clientes.getCelular());
            ps.setString(7, clientes.getCorreo());
            ps.setInt(8, clientes.getId_cliente());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    //PARA ELIMINAR, aunque no estoy seguro si debamos usarlo
    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from clientes where ID_CLIENTE=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    //PARA OBTENER UNA FILA DE DATOS
    //recibe la variable ID y a partir de eso obtenemos los datos del Cliente, mas que nada se usó para el momento de la Edicion de Datos Personales
    //Oomo vez se encapsula cada dato y la funcion devuelve un objeto de tipo Clientes.
    @Override
    public Clientes getById(int id) throws Exception {
        Clientes cli = new Clientes();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM clientes WHERE ID_CLIENTE=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCedula_identidad(rs.getString("cedula_identidad"));
                cli.setSexo(rs.getString("sexo"));
                cli.setCelular(rs.getString("celular"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
        
    }
    //PARA OBTENER UNA LISTA DE OBJETOS
    //recibe la variable ID y a partir de eso obtenemos Todas las filas que contienen datos del Cliente
    //Se usa al momento de mostrar los datos de Reg_cuentas y Movimientos.
    //Oomo vez se encapsula cada dato en un objeto y ese objeto se agrega a la lista y la funcion devuelve un objeto de tipo Lista.
    @Override
    public List<Clientes> getAll(int id) throws Exception {
        List<Clientes> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from clientes where ID_CLIENTE=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            lista = new ArrayList<Clientes>();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCedula_identidad(rs.getString("cedula_identidad"));
                cli.setSexo(rs.getString("sexo"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCelular(rs.getString("celular"));
                cli.setCorreo(rs.getString("correo"));
                lista.add(cli);
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
