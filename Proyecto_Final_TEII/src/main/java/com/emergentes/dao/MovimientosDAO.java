//EL DAO pues no es muy complejo, primero creamos una INTERFACE JAVA, si no aparece en tu catalogo de creacion tienes que darle a other.
//Luego tienes que crear los metodos que utilizaras para cada Modelo que creaste. Como es Movimientos, es muy similar a Cuentas.
//Aunque como te mencione hay algunos metodos que no se si deban estar, si no te late eliminalos.
//Ahora getById nos devuelve un objeto de tipo Movimientos, esto se usa cuando deseamos editar o visualizar la info del Usuario.
//creo que casi siempre solo va a corresponder a una consulta que devuelva una fila de la BD.
//El getAll nos devuelve una lista de objetos, y mas que nada se usa para visualizar 2 o mas filas de registros.
package com.emergentes.dao;
import com.emergentes.modelo.Movimientos;
import java.util.List;
public interface MovimientosDAO {
    public void insert(Movimientos movimientos)throws Exception;
    public void update(Movimientos movimientos)throws Exception;
    public Movimientos getById(int id) throws Exception;
    public List<Movimientos> getAll(int id) throws Exception;
    
}
