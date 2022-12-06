package com.backend.repository.impl;

import com.backend.entities.Carrera;
import com.backend.entities.Horario;
import com.backend.repository.IHorarioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Horario> getHorarios() {
        String consulta = "SELECT h FROM Horario h";
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
    public Horario getHorario(long id) {
        try{
            return em.find(Horario.class, id);
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
    public void guardarHorario(Horario horario) {
        try {
            em.merge(horario);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarHorario(long id) {
        Horario horario;
        try {
            horario = em.find(Horario.class, id);
            em.remove(horario);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
