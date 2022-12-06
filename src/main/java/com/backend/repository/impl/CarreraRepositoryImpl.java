package com.backend.repository.impl;

import com.backend.entities.Carrera;
import com.backend.repository.ICarreraRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CarreraRepositoryImpl implements ICarreraRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Carrera> getCarreras() {
        String consulta = "SELECT c FROM Carrera c";
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
    public Carrera getCarrera(long id) {
        try{
            return em.find(Carrera.class, id);
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
    public void guardarCarrera(Carrera carrera) {
        try {
            em.merge(carrera);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarCarrera(long id) {
        Carrera carrera;
        try {
            carrera = em.find(Carrera.class, id);
            em.remove(carrera);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
