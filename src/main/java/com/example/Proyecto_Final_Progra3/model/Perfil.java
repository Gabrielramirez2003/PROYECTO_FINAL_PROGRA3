package com.example.Proyecto_Final_Progra3.model;

import com.example.Proyecto_Final_Progra3.model.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="perfil_id")
    private int id;

    @Column(name ="nombre_usuario")
    private String usuario;

    @Column(name="password_usuario")
    private String password;

    @Column(name="rol")
    private Rol rol;

}
