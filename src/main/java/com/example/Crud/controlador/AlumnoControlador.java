package com.example.Crud.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import com.example.Crud.alumnoServicio.AlumnoServicio;
import com.example.Crud.modelo.Alumno;
import com.example.Crud.repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "https://crud-estudiantes-d1a57.web.app")
//@CrossOrigin(origins = "*")
public class AlumnoControlador {

    @Autowired
    private AlumnoRepositorio repositorio;
    @Autowired
    private AlumnoServicio estudianteService;

    @CrossOrigin(origins = "https://crud-estudiantes-d1a57.web.app")
    @GetMapping
    public List<Alumno> ListaAlumno(){
        return estudianteService.obtenerTodosLosProductos();
    }
    
    @PostMapping("/Alumno")
    public Alumno RegistroEstudiante(@RequestBody Alumno alumno){
        return repositorio.save(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarEstudiante(@PathVariable Long id, @RequestBody Alumno estudianteActualizado) {
        Alumno estudianteActualizadoResultado = estudianteService.actualizarEstudiante(id, estudianteActualizado);
        return ResponseEntity.ok(estudianteActualizadoResultado);
    }

    /*@GetMapping("/buscar")
    public ResponseEntity<List<Alumno>> buscarEstudiantes(@RequestParam String nombre) {
        List<Alumno> estudiantes = repositorio.NombreContaining(nombre);
        return ResponseEntity.ok().body(estudiantes);
    }*/


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarEstudiante(@PathVariable Long id) {
        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
