//EL DAO pues no es muy complejo, primero creamos una INTERFACE JAVA, si no aparece en tu catalogo de creacion tienes que darle a other.
//Luego tienes que crear los metodos que utilizaras para cada Modelo que creaste. Como es Clientes, aqui están las acciones de CRUD
//Insert, Update, talvez Delete esto no estoy seguro, getByID y GetAll
//Como puedes ver los ultimos dos tienen el Modelo utilizado, el getById devolverá un objeto
//mientras que el GetAll devolverá una lista de objetos.
package com.emergentes.dao;
import com.emergentes.modelo.Clientes;
import java.util.List;
public interface ClientesDAO {
    public void insert(Clientes clientes) throws Exception;
    public void update(Clientes clientes) throws Exception;
    public void delete(int id) throws Exception;
    public Clientes getById(int id) throws Exception;
    public List<Clientes> getAll(int id) throws Exception; 
}
