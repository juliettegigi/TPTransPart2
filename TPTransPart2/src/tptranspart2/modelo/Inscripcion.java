/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.modelo;

/**
 *
 * @author julie
 */
public class Inscripcion {
      private int idInscripto;
    private Alumno alumano;
    private int nota;
    private Materia materia;

    public Inscripcion(Alumno alumano, int nota, Materia materia) {
        this.alumano = alumano;
        this.nota = nota;
        this.materia = materia;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public Alumno getAlumano() {
        return alumano;
    }

    public int getNota() {
        return nota;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public void setAlumano(Alumno alumano) {
        this.alumano = alumano;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripto=" + idInscripto + ", alumano=" + alumano + ", nota=" + nota + ", materia=" + materia + '}';
    }
    
    

   
    
}
