package com.emergentes.dao;
import com.emergentes.modelo.Retiros;
import java.util.List;

public interface RetirosDAO {
    public void insert(Retiros retiros) throws Exception;
    public void update(Retiros retiros) throws Exception;
    public void delete(int id) throws Exception;
    public Retiros getById(int id) throws Exception;
    public List<Retiros> getAll(int id) throws Exception;
}
