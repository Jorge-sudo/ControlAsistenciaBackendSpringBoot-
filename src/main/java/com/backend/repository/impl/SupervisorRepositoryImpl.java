package com.backend.repository.impl;

import com.backend.entities.Carrera;
import com.backend.entities.Supervisor;
import com.backend.repository.ISupervisorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SupervisorRepositoryImpl implements ISupervisorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Supervisor> getSupervisores() {
        String consulta = "SELECT s FROM Supervisor s";
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
    public Supervisor getSupervisor(long id) {
        try{
            return em.find(Supervisor.class, id);
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
    public void guardarSupervisor(Supervisor supervisor) {
        try {
            em.merge(supervisor);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
               em.close();
            }
        }
    }

    @Override
    public void eliminarSupervisor(long id) {
        Supervisor supervisor1 ;
        try {
            supervisor1 = em.find(Supervisor.class, id);
            em.remove(supervisor1);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
           }
        }
    }
}
