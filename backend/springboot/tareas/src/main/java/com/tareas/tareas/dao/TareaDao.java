package com.tareas.tareas.dao;

import com.tareas.tareas.Model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.Model;

public interface TareaDao  extends CrudRepository<Tarea, Integer> {
}
