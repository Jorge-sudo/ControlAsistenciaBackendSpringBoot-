package com.backend.repository.impl;

import com.backend.entities.Carrera;
import com.backend.entities.Turno;
import com.backend.repository.ITurnoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TurnoRepositoryImpl implements ITurnoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Turno> getTurnos() {
        String consulta = "SELECT t FROM Turno t";
        try{
            Query query = em.createQuery(consulta);
            return query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace(System.out);
            return  null;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Turno getTurno(long id) {
        try{
            return em.find(Turno.class, id);
        }catch (Exception ex){
            ex.printStackTrace(System.out);
            return  null;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void guardarTurno(Turno turno) {

    }

    @Override
    public void eliminarTurno(long id) {

    }
}
