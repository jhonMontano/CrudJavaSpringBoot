package com.example.demo.interfaceService;

import com.example.demo.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    List<Persona> obtenerTodasLasPersonas();
    Persona obtenerPersonaPorId(int id);

    Persona guardarPersona(Persona persona);

    boolean eliminarPersona(int id);

}
