/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2;

import java.time.LocalDate;
import tptranspart2.accesoADatos.AlumnoData;
import tptranspart2.accesoADatos.InscripcionData;
import tptranspart2.entidades.Materia;
import tptranspart2.accesoADatos.MateriaData;
import tptranspart2.entidades.Alumno;
import tptranspart2.entidades.Inscripcion;

/**
 *
 * @author julie
 */
public class TPTransPart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//------------------AGREGO ALUMNO------------------
        //AlumnoData.guardarAlumno(new Alumno(11122233, "Garro", "Juan", LocalDate.of(2000, 5, 22), true));
        
//--------------BUSCO ALUMNO POR ID----------------
        //System.out.println(AlumnoData.buscarAlumno(3));
        
//-------------BUSCO ALUMNO POR DNI----------------   
        //System.out.println(AlumnoData.buscarAlumnoPorDni(11122233));
        
//------------------LISTO ALUMNO-------------------
        //System.out.println("Alumnos: \n" + AlumnoData.listarAlumnos());
        
//----------------MODIFICO ALUMNO------------------  
        //AlumnoData.modificarAlumno(new Alumno(4, 30956879, "Messi", "Lionel", LocalDate.of(1987, 6, 24), true));
        
//----------------DAR BAJA ALUMNO------------------ BORRADO LÓGICO
        //AlumnoData.darBajaAlumno(2);
        
//-----------------ELIMINO ALUMNO------------------ BORRADO DEFINITIVO
        //AlumnoData.eliminarAlumno(6);
        
        
//-------------------AGREGO MATERIA----------------
        //MateriaData.guardarMateria(new Materia("Sociologia", 2, true));
        
//------------------LISTO MATERIAS-----------------       
        //System.out.println("Materias: \n" + MateriaData.listarMaterias());
        
//---------------BUSCO MATERIA POR ID--------------
        //System.out.println(MateriaData.buscarMateria(3));
        
//----------------MODIFICO MATERIA-----------------   
        //MateriaData.modificarMateria(new Materia(6, "Ingles II", 3, true));
        
//----------------DAR BAJA MATERIA----------------- BORRADO LÓGICO
        //MateriaData.darBajaMaterias(6);
        
//-----------------ELIMINO MATERIA----------------- BORRADO DEFINITIVO
        //MateriaData.eliminarMateria(6);
        
        
//----------------AGREGO INSCRIPCION---------------
        //Alumno a = AlumnoData.buscarAlumno(1);
        //Materia m = MateriaData.buscarMateria(4);
        //InscripcionData.guardarInscripcion(new Inscripcion(a, 10, m));
        
//----------------LISTO INSCRIPCIONES--------------
        //System.out.println(InscripcionData.obtenerInscripciones());
        
//-------------LISTO MATERIAS CURSADAS-------------
        //InscripcionData.obtenerMateriasCursadas(3);                          ERROR
        
//-----------LISTO MATERIAS NO CURSADAS------------
        //InscripcionData.obtenerMateriasNOCursadas(3);                        ERROR
        
//----------LISTO INSCRIPCIONES X ALUMNO-----------

//------------------ACTUALIZO NOTA-----------------
        //InscripcionData.actualizarNota(2, 4, 9);
        
//--------------LISTO ALUMNOS X MATERIA------------
        //System.out.println(InscripcionData.obtenerAlumnosPorMateria(1));
        
//---------------ELIMINO INSCRIPCION--------------- BORRADO DEFINITIVO
        //InscripcionData.borrarInscripcionMateriaAlumno(1, 4);
    }
}
