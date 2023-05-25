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


//-----------------------------AGREGO ALUMNO-----------------------------
        //AlumnoData.guardarAlumno(new Alumno(11122233, "Garro", "Juan", LocalDate.of(2000, 5, 22), true));
        
//-------------------------BUSCO ALUMNO POR ID---------------------------
        //System.out.println(AlumnoData.buscarAlumno(3));
        
//------------------------BUSCO ALUMNO POR DNI---------------------------   
        //System.out.println(AlumnoData.buscarAlumnoPorDni(38959654));
        
//-----------------------------LISTO ALUMNO------------------------------
        //System.out.println("Alumnos: \n" + AlumnoData.listarAlumnos());
        
//---------------------------MODIFICO ALUMNO----------------------------- 
        //AlumnoData.modificarAlumno(new Alumno(4, 30956879, "Messi", "Lionel", LocalDate.of(1987, 6, 24), true));
        
//---------------------------DAR BAJA ALUMNO----------------------------- BORRADO LÓGICO
        //AlumnoData.darBajaAlumno(2);
        
//----------------------------ELIMINO ALUMNO----------------------------- BORRADO DEFINITIVO
        //AlumnoData.eliminarAlumno(5);
        
//__________________________________________________________________________________________________________________
        
//------------------------------AGREGO MATERIA---------------------------
        //MateriaData.guardarMateria(new Materia("Sociologia", 2, true));
        
//-----------------------------LISTO MATERIAS----------------------------       
        //System.out.println("Materias: \n" + MateriaData.listarMaterias());
        
//--------------------------BUSCO MATERIA POR ID-------------------------
        //System.out.println(MateriaData.buscarMateria(3));
        
//---------------------------MODIFICO MATERIA----------------------------   
        //MateriaData.modificarMateria(new Materia(5, "Ingles II", 3, true));
        
//---------------------------DAR BAJA MATERIA---------------------------- BORRADO LÓGICO
        //MateriaData.darBajaMaterias(6);
        
//----------------------------ELIMINO MATERIA---------------------------- BORRADO DEFINITIVO
        //MateriaData.eliminarMateria(6);
        
//__________________________________________________________________________________________________________________      

//---------------------------AGREGO INSCRIPCION--------------------------
        //Alumno a = AlumnoData.buscarAlumno(1);
        //Materia m = MateriaData.buscarMateria(4);
        //InscripcionData.guardarInscripcion(new Inscripcion(a, 10, m));
        
//---------------------------LISTO INSCRIPCIONES-------------------------
        //System.out.println(InscripcionData.obtenerInscripciones());
        
//------------------------LISTO MATERIAS CURSADAS------------------------
        //System.out.println(InscripcionData.obtenerMateriasCursadas(3));
        
//----------------------LISTO MATERIAS NO CURSADAS-----------------------
        //System.out.println(InscripcionData.obtenerMateriasNOCursadas(3));
        
//---------------------LISTO INSCRIPCIONES X ALUMNO----------------------
        //for(Inscripcion inscrip:InscripcionData.obtenerInscripcionesPorAlumno(3)){
           //System.out.println(inscrip.getAlumno().getNombre()+" "+inscrip.getMateria().getNombre());}
       
//-----------------------------ACTUALIZO NOTA----------------------------
        //InscripcionData.actualizarNota(2, 4, 10);
        
//-------------------------LISTO ALUMNOS X MATERIA-----------------------
        //System.out.println(InscripcionData.obtenerAlumnosPorMateria(1));
        
//--------------------------ELIMINO INSCRIPCION-------------------------- BORRADO DEFINITIVO
        //InscripcionData.borrarInscripcionMateriaAlumno(2, 4);
        
    }
}
