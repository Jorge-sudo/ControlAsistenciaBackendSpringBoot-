package com.backend.repository.impl;

import com.backend.entities.Materia;
import com.backend.repository.IMateriaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Materia> getMaterias() {
        String consulta = "SELECT m FROM Materia m";
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
    public Materia getMateria(long id) {
        try{
            return em.find(Materia.class, id);
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
    public void guardarMateria(Materia materia) {
        try {
            em.merge(materia);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarMateria(String sigla) {
        Materia materia;
        try {
            materia = em.find(Materia.class, sigla);
            em.remove(materia);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
