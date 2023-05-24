/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
   
   public boolean guardarInscripcion (Inscripcion i){
       String sql="INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?,?,?)";
       try{
           PreparedStatement ps= Conexion.getConexion().prepareStatement(sql);
           ps.setInt(1, i.getAlumno().getIdAlumno());
           ps.setInt(2, i.getMateria().getIdMateria());
           ps.setDouble(3, i.getNota());
           ps.execute();
           return true;
       } catch (SQLException e){
           System.out.println("Error al guardar inscripcion: "+e.toString());
           return false;
       }
   }
   
   
   public List <Inscripcion> obtenerInscripcionesPorAlumno(int id){
       //crear arraylist
   }
   
   public List <Materia> obtenerMateriasCursadas(int id){
       
   }
   
   public List <Materia> obtenerMateriasNOCursadas(int id){
       
   }
   
   public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
       
   }
   
   
}
