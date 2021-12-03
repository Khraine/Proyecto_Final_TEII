package com.emergentes.dao;
import com.emergentes.modelo.Depositos;
import java.util.List;

public interface DepositosDAO {
    public void insert(Depositos depositos) throws Exception;
    public void update(Depositos depositos) throws Exception;
    public void delete(int id) throws Exception;
    public Depositos getById(int id) throws Exception;
    public List<Depositos> getAll(int id) throws Exception; 
}
