//CONEXION A LA BASE DE DATOS, no hay mucho lio en esta parte es tal cual en sus ejemplos, solo ojo en la parte de URL
//El nombre de la base de Datos que crearas.
package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {
    static String url="jdbc:mysql://localhost:3306/bd_proyecto";
    static String driver ="com.mysql.jdbc.Driver";
    static String usuario="root";
    static String password="";
    protected Connection conn=null;

    public ConexionDB(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, usuario, password);
            if (conn!=null) {
                System.out.println("Conexion exitosa"+conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en especificacion del Driver "+ex.getMessage());;
        } catch (SQLException ex) {
            System.out.println("Error al conectar"+ex.getMessage());
        }  
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar"+ex.getMessage());
        }
        
    }
    
}
