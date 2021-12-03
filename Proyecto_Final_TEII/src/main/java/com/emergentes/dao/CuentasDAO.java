//EL DAO pues no es muy complejo, primero creamos una INTERFACE JAVA, si no aparece en tu catalogo de creacion tienes que darle a other.
//Luego tienes que crear los metodos que utilizaras para cada Modelo que creaste. Como es Cuentas, aqui están ciertas acciones nomas
//como te mencione, solo están la de Insert, getById y getAll
//Ahora getById nos devuelve un objeto de tipo Cuentas, esto se usa cuando deseamos editar o visualizar la info del Usuario.
//creo que casi siempre solo va a corresponder a una consulta que devuelva una fila de la BD.
//El getAll nos devuelve una lista de objetos, y mas que nada se usa para visualizar 2 o mas registros.
package com.emergentes.dao;
import com.emergentes.modelo.Cuentas;
import java.util.List;
public interface CuentasDAO {
    public void insert(Cuentas cuentas) throws Exception;
    public Cuentas getById(int id) throws Exception;
    public List<Cuentas> getAll(int id) throws Exception; 
}
