package com.example.Proyecto_Final_Progra3.model.freelancer;

import com.example.Proyecto_Final_Progra3.model.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name="employee")
public class Freelancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long freelancerId;

    private String nombre;
    private String apellido;
    private String email;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private boolean freelancer = true;
    private boolean enterprise = false;

    @OneToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}
