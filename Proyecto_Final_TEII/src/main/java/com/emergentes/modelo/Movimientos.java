//CLASE PARA ENCAPSULAR LOS DATOS QUE ALMACENEMOS, nada fuera de lo comun como en sus ejemplos.
//MOVIMIENTOS
package com.emergentes.modelo;
import java.sql.Date;
public class Movimientos {
    private int id_registro;
    private int monto;
    private Date fecha;
    private String tipo;
    private int cod_cli;

    public Movimientos() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    @Override
    public String toString() {
        return "Movimientos{" + "id_registro=" + id_registro + ", monto=" + monto + ", fecha=" + fecha + ", tipo=" + tipo + ", cod_cli=" + cod_cli + '}';
    }
    
    
}
