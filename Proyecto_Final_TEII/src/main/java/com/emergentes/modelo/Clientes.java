//CLASE PARA ENCAPSULAR LOS DATOS QUE ALMACENEMOS, nada fuera de lo comun como en sus ejemplos.
//CLIENTES
package com.emergentes.modelo;
public class Clientes {
    private int id_cliente;
    private String nombres;
    private String apellidos;
    private String cedula_identidad;
    private String sexo;
    private String direccion;
    private String celular;
    private String correo;
    public Clientes() {
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula_identidad() {
        return cedula_identidad;
    }
    public void setCedula_identidad(String cedula_identidad) {
        this.cedula_identidad = cedula_identidad;
    }
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + id_cliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cedula_identidad=" + cedula_identidad + ", sexo=" + sexo + ", direccion=" + direccion + ", celular=" + celular + ", correo=" + correo + '}';
    }
    

   
    
}
