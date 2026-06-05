package com.example.Proyecto_Final_Progra3.service.perfil;

import com.example.Proyecto_Final_Progra3.model.perfil.Perfil;
import com.example.Proyecto_Final_Progra3.model.perfil.Rol;
import com.example.Proyecto_Final_Progra3.repository.PerfilRepository;
import com.example.Proyecto_Final_Progra3.repository.Rolrepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilFunctionally {
    private final PerfilRepository repository;
    private final Rolrepository rolrepository;

    public PerfilFunctionally(PerfilRepository repository,  Rolrepository rolrepository) {
        this.repository = repository;
        this.rolrepository = rolrepository;
    }

    public Perfil createPerfil(Perfil profile){
        Optional<Perfil> p = repository.findById(profile.getPerfil_id().intValue());
        List<Rol> roles = rolrepository.findAll();
            if(p.isEmpty()){
                Perfil perfil = new Perfil();
                perfil.setUsuario(profile.getUsuario());
                perfil.setEmail(profile.getEmail());
                perfil.setPassword(profile.getPassword());
                perfil.setFotoPerfil(profile.getFotoPerfil());
                Optional<Rol> r = roles.stream()
                        .filter(role -> profile.getRol().equals(role))
                        .findFirst();
                perfil.setRol(r.orElseThrow(() -> new RuntimeException("Rol no encontrado")));
                perfil.setFechaCreacion(LocalDate.now());
                return repository.save(perfil);
            }else{
                return null;
            }
    }
    public Perfil verPerfil(Perfil perfil){
        Optional<Perfil> p = repository.findById(perfil.getPerfil_id().intValue());
        if (p.get().getActivo() == 0) return null;
        else {
            return p.orElse(null);
        }
    }
    public void eliminarPerfil(Perfil profile){
        Optional<Perfil> p = repository.findById(profile.getPerfil_id().intValue());
        if(p.isPresent()){
            Perfil perfil = p.get();
            perfil.setActivo(0);
            repository.save(perfil);
        }

    }
    public void modificarPerfil(Perfil perfil, String campo, String dato){
        Optional<Perfil> p = repository.findById(perfil.getPerfil_id().intValue());
        if(p.isPresent()){
            switch (campo) {
                case "fotoPerfil": perfil.setFotoPerfil(dato);
                repository.save(perfil);
                break;
                case "username": perfil.setUsuario(dato);
                repository.save(perfil);
                break;
                case "password": perfil.setPassword(dato);
                repository.save(perfil);
                break;
                case "email": perfil.setEmail(dato);
                repository.save(perfil);
                break;
            }
        }
    }
}
