package com.example.demo.controler;

import com.example.demo.interfaceService.IPersonaService;
import com.example.demo.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final IPersonaService personaService;

    @Autowired
    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/listar")
    public List<Persona> listarPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }

    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable int id) {
        return personaService.obtenerPersonaPorId(id);
    }

    @PostMapping("/crear")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @PostMapping("/crearPersonas")
    public List<Persona> crearPersonas(@RequestBody List<Persona> personas){
        return personaService.guardarPersonas(personas);
    }

    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable ("id") int id, @RequestBody Persona persona){
        return personaService.actualizarPersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable int id) {
        boolean resultado = personaService.eliminarPersona(id);
        if (resultado) {
            return new ResponseEntity<>("Persona eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo eliminar la persona", HttpStatus.NOT_FOUND);
        }
    }
}


