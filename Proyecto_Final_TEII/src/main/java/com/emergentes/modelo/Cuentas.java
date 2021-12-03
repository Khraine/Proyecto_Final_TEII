//CLASE PARA ENCAPSULAR LOS DATOS QUE ALMACENEMOS, nada fuera de lo comun como en sus ejemplos.
//CUENTAS
package com.emergentes.modelo;
import java.sql.Date;
public class Cuentas {
    private int id_registro;
    private int saldo;
    private Date fecha;
    private int cod_cliente;

    public Cuentas() {
    }
    

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    @Override
    public String toString() {
        return "Cuentas{" + "id_registro=" + id_registro + ", saldo=" + saldo + ", fecha=" + fecha + ", cod_cliente=" + cod_cliente + '}';
    }
    
}
