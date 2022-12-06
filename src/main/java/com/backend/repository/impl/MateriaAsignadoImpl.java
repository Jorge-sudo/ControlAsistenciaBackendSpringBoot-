package com.backend.repository.impl;

import com.backend.entities.MateriaAsignado;
import com.backend.repository.IMateriaAsignadoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MateriaAsignadoImpl implements IMateriaAsignadoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MateriaAsignado> getMateriasAsignados() {
        String consulta = "SELECT m FROM MateriaAsignado m";
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
    public MateriaAsignado getMateriaAsignado(long id) {
        try{
            return em.find(MateriaAsignado.class, id);
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
    public void guardarMateriaAsignado(MateriaAsignado materiaAsignado) {
        try {
            em.merge(materiaAsignado);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarMateriaAsignado(long id) {
        MateriaAsignado materiaAsignado;
        try {
            materiaAsignado = em.find(MateriaAsignado.class, id);
            em.remove(materiaAsignado);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
