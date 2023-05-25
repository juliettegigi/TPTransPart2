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

//------------------INGRESO ALUMNO-----------------
        AlumnoData.guardarAlumno(new Alumno(111222333, "Apellido1", "nombre1", LocalDate.of(2000, 5, 22), true));

//------------------BUSCO ALUMNO-------------------
       System.out.println(AlumnoData.buscarAlumno(3));
        System.out.println(AlumnoData.buscarAlumnoPorDni(30986785));

//------------------LISTO ALUMNO-------------------
        System.out.println(AlumnoData.listarAlumnos());
        
//----------------MODIFICO ALUMNO------------------  
        AlumnoData.modificarAlumno(new Alumno(15, 10, "Apellido1", "nombre1", LocalDate.of(2000, 5, 22), true));

//----------------DAR BAJA ALUMNO------------------
        AlumnoData.darBajaAlumno(2); //BORRADO LÓGICO
        //AlumnoData.eliminarAlumno(16); BORRADO DEFINITIVO

    }
}
