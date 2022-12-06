package com.backend.controllers;

import com.backend.entities.Usuario;
import com.backend.repository.IUsuarioRepository;
import com.backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    //Esto es la injeccion de dependencias hace que se cree un objeto y se guarde en esta variable
    @Autowired
    private IUsuarioRepository iUsuarioRepository; //si esta variable se crea en otra clase se utilizara el mismo objeto
    //entonces quiere decir que se compartira el mismo objeto

    @Autowired //es necesario
    private JWTUtil jwtUtil;

    @PostMapping("/api/login")
    public boolean login(@RequestBody Usuario usuario){//con requestBody convierte el JSON que recibe a un usuario
        Usuario usuarioLogeado = iUsuarioRepository.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogeado != null){
            return true;
        }
        return false;
    }

}
