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
        for( Persona persona : personas){
            if(persona.getId() == id){
                return persona;
            }
        }
        return null;
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    @Override
    public List<Persona> guardarPersonas(List<Persona> personasNuevas) {
        personas.addAll(personasNuevas);
        return personasNuevas;
    }

    public Persona actualizarPersona(int id,Persona persona){
        int index = 0;
        for (Persona p: personas){
            if (p.getId() == id){
                persona.setId(id);
                personas.set(index,persona);
            }
        }
        return persona;
    }

    @Override
    public boolean eliminarPersona(int id) {
        for( Persona persona : personas){
            if(persona.getId() == id){
                return personas.remove(persona);
            }
        }
        return false;
    }
}
