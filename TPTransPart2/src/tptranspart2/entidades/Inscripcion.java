/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.entidades;

/**
 *
 * @author julie
 */
public class Inscripcion {

    private int idInscripto;
    private Alumno alumno;
    private double nota;
    private Materia materia;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripto, Alumno alumno, int nota, Materia materia) {
        this.alumno = alumno;
        this.nota = nota;
        this.materia = materia;
    }

    public Inscripcion(Alumno alumno, int nota, Materia materia) {
        this.alumno = alumno;
        this.nota = nota;
        this.materia = materia;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public double getNota() {
        return nota;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Inscripcion: \n" + "ID Inscripcion: " + idInscripto + " | Alumno:" + alumno + " | Nota:" + nota + " |Materia: " + materia +"\n";
    }

}
