/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2;

import java.time.LocalDate;
import tptranspart2.accesoADatos.AlumnoData;
import tptranspart2.entidades.Materia;
import tptranspart2.accesoADatos.MateriaData;
import tptranspart2.entidades.Alumno;

/**
 *
 * @author julie
 */
public class TPTransPart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //(int dni, String nombre, String apellido, boolean estado, LocalDate fechaNacimiento)
        //Alumno a = new Alumno(1585289,"Roberto","Gomez",true,LocalDate.of(1985, 5, 5));
        //AlumnoData alumno = new AlumnoData();
        AlumnoData.darBajaAlumno(5);
    }
}
