package org.example.entities;


import java.time.LocalDateTime;
import java.util.Set;


public class Inscripcion {
    private Set<Materia> materiasACursar;
    private boolean fueAprobada;
    private Alumno alumno;
    private LocalDateTime fechaDeEvaluacion;

    public Inscripcion(Alumno alumno, Set<Materia> materiasACursar) {
        this.alumno = alumno;
        this.materiasACursar = materiasACursar;
        this.fechaDeEvaluacion = LocalDateTime.now();
        this.fueAprobada = false;
    }

    public boolean aprobada() {
        for (Materia materia : materiasACursar) {
            if (!materia.cumpleCorrelativas(alumno.getMateriasAprobadas())) {
                return false;
            }
        }
        fueAprobada = true;
        return true;
    }
}
