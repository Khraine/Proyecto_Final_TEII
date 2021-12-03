package com.emergentes.modelo;
import java.sql.Date;
public class Depositos {
    private int id_registro;
    private int monto;
    private Date fecha;
    private int cod_cli;

    public Depositos() {
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

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    @Override
    public String toString() {
        return "Depositos{" + "id_registro=" + id_registro + ", monto=" + monto + ", fecha=" + fecha + ", cod_cli=" + cod_cli + '}';
    }
    
}
