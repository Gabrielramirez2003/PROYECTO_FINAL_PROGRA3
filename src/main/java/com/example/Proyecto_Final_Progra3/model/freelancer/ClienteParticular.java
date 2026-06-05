package com.example.Proyecto_Final_Progra3.model.freelancer;

import com.example.Proyecto_Final_Progra3.model.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name="cliente_particular")
public class ClienteParticular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cliente_particular_id")
    private int cliente_id;

    private String nombre;
    private String apellido;
    private String email;

    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private String telefono;
    private String pais;

    @OneToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}
