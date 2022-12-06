package com.backend.repository.impl;

import com.backend.entities.Usuario;
import com.backend.repository.IUsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Usuario> getUsuarios() {
        String consulta = "SELECT u FROM Usuario u";
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
    public Usuario getUsuario(long id) {
        try{
            return em.find(Usuario.class, id);
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
    public void guardarUsuario(Usuario usuario) {
        try {
            em.merge(usuario);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
               em.close();
            }
        }
    }

    @Override
    public void eliminarUsuario(long id) {
        Usuario usuario;
        try {
            usuario = em.find(Usuario.class, id);
            em.remove(usuario);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
           }
        }
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        //En este query no podemos concatenar el usuario y password por que es vulnerable a hacker y daria true y tendria acceso
        //por los tanto utilizamos :email y :password
        String query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario";
        List<Usuario> lista =  em.createQuery(query).
                setParameter("usuario", usuario.getUsuario())
                .getResultList();
        //si la lista esta vacia
        if (lista.isEmpty()){
            return null;
        }

        //obtenemos el primer elemento de la lista (0) y sacamos el password
        String passwordHashed = lista.get(0).getContrasenia();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        //comparamos los passwords encriptados
        if(argon2.verify(passwordHashed, usuario.getContrasenia())){//retorna un boolean
            return lista.get(0);
        }
        return null;
    }
}
