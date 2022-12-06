package com.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario_rol")
public class UsuarioRol {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_userol")
    private long idUsuarioRol;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public UsuarioRol() {

    }

    public UsuarioRol(long idUsuarioRol, Usuario usuario, Rol rol) {
        this.idUsuarioRol = idUsuarioRol;
        this.usuario = usuario;
        this.rol = rol;
    }
}
