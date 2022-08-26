package com.tareas.tareas.Controller;

import com.tareas.tareas.Model.Tarea;
import com.tareas.tareas.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    //listar
    @GetMapping("/tareas")
    public List<Tarea> listar() {

        return tareaService.findAll();
    }

    //guardar
    @PostMapping("/tareas")
    public Tarea guardar(@RequestBody Tarea tarea) {

        return tareaService.save(tarea);
    }

    //seleccionar
    @GetMapping("/tareas/{id}")
        public Tarea unaTarea(@PathVariable Integer id) {

        return tareaService.findById(id);
        }
     //modificar
    @PutMapping("/tareas/{id}")
    public Tarea modificar(@RequestBody Tarea tarea, @PathVariable Integer id)
    {
      Tarea tareaActual = tareaService.findById(id);
      tareaActual.setTarea(tarea.getTarea());
      tareaActual.setFinalizado(tarea.getFinalizado());

      return tareaService.save(tareaActual);
    }

    @DeleteMapping("/tareas/{id}")
    public void eliminar(@PathVariable Integer id){

        tareaService.delete(id);
    }
}
