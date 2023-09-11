package com.example.demo.service;

import com.example.demo.interfaceService.IPersonaService;
import com.example.demo.modelo.Persona;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonaServiceImpl implements IPersonaService {

    private final List<Persona> personas = new ArrayList<>();

    @Override
    public List<Persona> obtenerTodasLasPersonas() {
        return personas;
    }

    @Override
    public Persona obtenerPersonaPorId(int id) {
        // Implementa la lógica para obtener una persona por su ID
        return null;
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    @Override
    public boolean eliminarPersona(int id) {
        // Implementa la lógica para eliminar una persona por su ID
        return false;
    }
}
