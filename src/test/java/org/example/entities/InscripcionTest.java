package org.example.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;

class InscripcionTest {
    private Materia paradigmas;
    private Materia diseño;
    private Materia algoritmos;
    private Alumno alumno;

    @BeforeEach
    void setUp() {
        paradigmas = new Materia("Paradigmas de Programación");
        diseño = new Materia("Diseño de Sistemas");
        algoritmos = new Materia("Algoritmos y Estructuras de Datos");

        // Diseño de Sistemas requiere Paradigmas como correlativa
        diseño.agregarCorrelativa(paradigmas);

        // Algoritmos no tiene correlativas

        alumno = new Alumno("Juan", "Pérez");
    }

    @Test
    void inscripcionAprobadaCuandoCumpleCorrelativas() {
        alumno.agregarMateriaAprobada(paradigmas); // Aprueba la correlativa

        Set<Materia> materiasAInscribirse = new HashSet<>();
        materiasAInscribirse.add(diseño);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribirse);

        assertTrue(inscripcion.aprobada(), "La inscripción debería estar aprobada");
    }

    @Test
    void inscripcionRechazadaCuandoNoCumpleCorrelativas() {
        Set<Materia> materiasAInscribirse = new HashSet<>();
        materiasAInscribirse.add(diseño);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribirse);

        assertFalse(inscripcion.aprobada(), "La inscripción debería ser rechazada por falta de correlativas");
    }

    @Test
    void inscripcionAprobadaParaMateriaSinCorrelativas() {
        Set<Materia> materiasAInscribirse = new HashSet<>();
        materiasAInscribirse.add(algoritmos); // Algoritmos no tiene correlativas

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribirse);

        assertTrue(inscripcion.aprobada(), "La inscripción debería aprobarse porque Algoritmos no tiene correlativas");
    }
}