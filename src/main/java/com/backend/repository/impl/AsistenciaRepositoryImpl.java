package com.backend.repository.impl;

import com.backend.entities.Asistencia;
import com.backend.entities.Docente;
import com.backend.entities.Usuario;
import com.backend.repository.IAsistenciaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class AsistenciaRepositoryImpl implements IAsistenciaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Asistencia> getAsistencias() {
        String consulta = "SELECT a FROM Asistencia a";
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
    public Asistencia getAsistencia(long id) {
        try{
            return em.find(Asistencia.class, id);
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
    public void guardarAsistencia(Asistencia asistencia) {
        try {
            em.merge(asistencia);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarAsistencia(long id) {
        Asistencia asistencia;
        try {
            asistencia = em.find(Asistencia.class, id);
            em.remove(asistencia);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void registrarAsistencia(long ci) {
        java.sql.Date fecha = new java.sql.Date(new java.util.Date().getTime());
        java.sql.Time hora = new java.sql.Time(new java.util.Date().getTime());
        Docente docente = null;
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, 2L);
            docente = em.find(Docente.class, ci);
            Asistencia asistencia = new Asistencia(fecha, hora, 17, usuario, docente);
            em.merge(asistencia);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
