package com.backend.repository.impl;

import com.backend.entities.MateriaHorario;
import com.backend.repository.IMateriaHorarioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MateriaHorarioRepositoryImpl implements IMateriaHorarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MateriaHorario> getMateriaHorarios() {
        String consulta = "SELECT m FROM MateriaHorario m";
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
    public MateriaHorario getMateriaHorario(long id) {
        try{
            return em.find(MateriaHorario.class, id);
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
    public void guardarMateriaHorario(MateriaHorario materiaHorario) {
        try {
            em.merge(materiaHorario);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarMateriaHorario(long id) {
        MateriaHorario materiaHorario;
        try {
            materiaHorario = em.find(MateriaHorario.class, id);
            em.remove(materiaHorario);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
