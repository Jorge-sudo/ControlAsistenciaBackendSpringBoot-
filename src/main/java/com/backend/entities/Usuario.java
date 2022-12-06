package com.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario")
    private long idUsuario;
    private String usuario;
    private String contrasenia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci")
    private Supervisor supervisor;

    public Usuario(){

    }

    public Usuario(long idUsuario, String usuario, String contrasenia, Supervisor supervisor) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.supervisor = supervisor;
    }
}
