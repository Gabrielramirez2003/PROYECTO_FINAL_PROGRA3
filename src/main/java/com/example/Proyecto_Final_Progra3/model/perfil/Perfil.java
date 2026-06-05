package com.example.Proyecto_Final_Progra3.model.perfil;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name="Perfil")
public class Perfil {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perfil_id;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(nullable=false,  unique=true)
    private String usuario;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;

    private int activo;

    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
