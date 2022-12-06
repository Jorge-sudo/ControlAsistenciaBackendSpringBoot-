package com.backend.repository.impl;

import com.backend.entities.Carrera;
import com.backend.entities.UsuarioRol;
import com.backend.repository.IUsuarioRolRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioRolRepositoryImpl implements IUsuarioRolRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UsuarioRol> getUsuariosRols() {
        String consulta = "SELECT u FROM UsuarioRol u";
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
    public UsuarioRol getUsuarioRol(long id) {
        try{
            return em.find(UsuarioRol.class, id);
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
    public void guardarUsuarioRol(UsuarioRol usuarioRol) {
        try {
            em.merge(usuarioRol);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminarUsuarioRol(long id) {
        UsuarioRol usuarioRol;
        try {
            usuarioRol = em.find(UsuarioRol.class, id);
            em.remove(usuarioRol);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
