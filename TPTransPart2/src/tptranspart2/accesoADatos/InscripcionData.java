/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.accesoADatos;

import java.sql.Connection;
import java.util.List;
import tptranspart2.entidades.Inscripcion;
import tptranspart2.entidades.Materia;

/**
 *
 * @author julie
 */

public class InscripcionData {
   private static Connection c;
   private MateriaData matData;
   private AlumnoData aluData;

   public InscripcionData() {
   }
   
   /*public static boolean guardarInscripcion (Inscripcion i){
       
   }
   
   public static List <Inscripcion> obtenerInscripciones(){
       
   }
   
   public static List <Inscripcion> obtenerInscripcionesPorAlumno(int id){
       
   }
   
   public static List <Materia> obtenerMateriasCursadas(int id){
       
   }
   
   public static List <Materia> obtenerMateriasNOCursadas(int id){
       
   }
   
   public static void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
       
   }
   
   */
}
