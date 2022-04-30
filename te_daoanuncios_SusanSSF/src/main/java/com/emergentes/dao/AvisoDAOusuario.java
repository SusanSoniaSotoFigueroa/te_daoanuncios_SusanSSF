
package com.emergentes.dao;

import com.emergentes.modelo.Avisousuario;
import java.util.List;

public interface AvisoDAOusuario {
    public void insert(Avisousuario avisousuario) throws Exception;
    public void update(Avisousuario avisousuario) throws Exception;
    public void delete(int id) throws Exception;
    public List<Avisousuario> getAll() throws Exception;
    public Avisousuario getById(int id) throws Exception;
}
