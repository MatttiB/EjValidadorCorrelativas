package org.example.entities;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }

    public boolean cumpleCorrelativas(Set<Materia> materiasAprobadas) {
        return materiasAprobadas.containsAll(correlativas);
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }
}
