package com.example.Proyecto_Final_Progra3.model.perfil;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rol;
}
