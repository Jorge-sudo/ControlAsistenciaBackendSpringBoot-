package com.backend.repository.impl;

import com.backend.entities.Docente;
import com.backend.repository.IDocenteRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DocenteRepositoryImpl implements IDocenteRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Docente> getDocentes() {
        String consulta = "SELECT d FROM Docente d";
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
    public Docente getDocente(long id) {
        try{
            return em.find(Docente.class, id);
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
    public void guardarDocente(Docente docente) {
        try {
            em.merge(docente);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarDocente(long id) {
        Docente docente;
        try {
            docente = em.find(Docente.class, id);
            System.out.println("usuario = " + docente);
            em.remove(docente);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
