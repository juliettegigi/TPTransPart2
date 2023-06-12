/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tptranspart2.entidades.Alumno;
import tptranspart2.entidades.Inscripcion;
import tptranspart2.entidades.Materia;

/**
 *
 * @author julie
 */
public class InscripcionData {

  Connection con=null;

    public InscripcionData() {
        con=Conexion.getConexion();
    }

    
    public void guardarInscripcion(Inscripcion i) {
        
        try {
            PreparedStatement p = con.prepareStatement( "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            p.setInt(1, i.getAlumno().getIdAlumno());
            p.setInt(2, i.getMateria().getIdMateria());
            p.setDouble(3, i.getNota());
           int filasAfectadas= p.executeUpdate();
            ResultSet r=p.getGeneratedKeys();
            if(r.next())
                i.setIdInscripto(r.getInt("idInscripto"));
           if(filasAfectadas>0)
              JOptionPane.showMessageDialog(null,"Alumno insertado");
            else JOptionPane.showMessageDialog(null,"El alumno ingresado no ha sido insertado");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Error en guardarInscripción.\n"+e.getMessage());
            
        }
    }

    public  List<Inscripcion> obtenerInscripciones() {
        MateriaData m=new MateriaData();
        AlumnoData a=new AlumnoData();
        List<Inscripcion> retorno = new ArrayList();

        try {
             PreparedStatement p = con.prepareStatement("SELECT * FROM inscripcion;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Inscripcion i = new Inscripcion();
                i.setIdInscripto(r.getInt("idInscripto"));
                i.setAlumno(a.buscarAlumnoActivo(r.getInt("idAlumno")));
                i.setMateria(m.buscarMateria(r.getInt("idMateria")));
                i.setNota(r.getDouble("nota"));
                retorno.add(i);
            }
            

        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error en obtenerInscripciones.\n"+ex.getMessage());
        }
        return retorno;
    }

    
    // INGRESA EL ID DE UN ALUMNO Y RETORNO LAS MATERIAS CURSADAS POR ESE ALUMNO
    public List<Materia> obtenerMateriasCursadas(int id) {
        
        List<Materia> m = new ArrayList<Materia>();

        try {
            String sql = "SELECT * FROM materia WHERE idMateria IN (SELECT idMateria FROM inscripcion WHERE idAlumno=?);";
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(r.getInt("idMateria"));
                mat.setNombre(r.getString("nombre"));
                mat.setAnio(r.getInt("año"));
                mat.setEstado(r.getBoolean("estado"));
                m.add(mat);
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error en obtenerMateriasCursadas.\n"+ex.getMessage());
        }
        return m;
    }

    public List<Materia> obtenerMateriasNOCursadas(int id) {
       
        List<Materia> materias = new ArrayList<Materia>();
        try {
            PreparedStatement p = con.prepareStatement( "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno =? and estado=true) and estado=true;");
            p.setInt(1, id);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(r.getInt("idMateria"));
                materia.setNombre(r.getString("nombre"));
                materia.setAnio(r.getInt("año"));
                materia.setEstado(r.getBoolean("estado"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en obtenerMateriasNOCursadas.\n"+ex.getMessage());
        }
        return materias;
    }

    public  boolean actualizarNota(int idAlumno, int idMateria, double nota) {
        
        try {
            PreparedStatement p = con.prepareStatement("UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?;");
            p.setDouble(1, nota);
            p.setInt(2, idAlumno);
            p.setInt(3, idMateria);
            int filasAfectadas=p.executeUpdate();
            if(filasAfectadas>0)
                  return true;
          //      JOptionPane.showMessageDialog(null,"Nota actualizada.\n");
            else //JOptionPane.showMessageDialog(null," La inscripción no existe .\n");
               return false;
                } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en obtenerMateriasCursadas.\n"+ex.getMessage());
            return false;
        }
    }

    public  List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
       AlumnoData alumnoData=new AlumnoData();
        List<Alumno> lista = new ArrayList();
        try {
            PreparedStatement p = con.prepareStatement("SELECT inscripcion.idalumno\n"
                    + "FROM materia,alumno,inscripcion\n"
                    + "WHERE inscripcion.idAlumno = alumno.idAlumno \n"
                    + "AND inscripcion.idMateria=materia.idMateria\n"
                    + "AND materia.idMateria=?;");
            p.setInt(1, idMateria);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                
                Alumno a=alumnoData.buscarAlumnoActivo(rs.getInt("idAlumno"));
                lista.add(a);
            }
        } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Error en obtenerAlumnoPor materia.\n"+ex.getMessage());
        }

        return lista;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlum){
        AlumnoData alumnoData=new AlumnoData();
        MateriaData materiaData=new MateriaData();
        List<Inscripcion> i= new ArrayList();
        try{
            
           PreparedStatement p=con.prepareStatement("SELECT * FROM inscripcion WHERE inscripcion.idAlumno =?");
            p.setInt(1, idAlum);
            ResultSet resulS=p.executeQuery();
            while(resulS.next()){
                Inscripcion ins;
                Alumno a=alumnoData.buscarAlumnoActivo(idAlum);
                Materia m=materiaData.buscarMateria(resulS.getInt("idMateria"));
                ins=new Inscripcion(resulS.getInt("idInscripto"),a,resulS.getInt("nota"),m);
                i.add(ins);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en obtener inscripciones por materia.\n"+e.getMessage());
        }
        return i;
    }

    
    public  void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
       

        try {
            PreparedStatement p = con.prepareStatement("DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?;");
            p.setInt(1, idAlumno);
            p.setInt(2, idMateria);
            int filasAfectadas=p.executeUpdate();
            if(filasAfectadas>0)
                JOptionPane.showMessageDialog(null,"Inscripción eliminada.\n");
            else
                JOptionPane.showMessageDialog(null,"La inscripción no pertenece a la base de datos.\n");

            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error en borrar inscripción materia/alumno.\n"+ex.getMessage());
        }
        
        
       
        
        
        
    }
    
    
    
    public void eliminarInscripcionPorIdAlumno(int id){
      try {
          PreparedStatement p=con.prepareStatement("Delete from inscripcion where idalumno=?");
          p.setInt(1,id);
          p.executeUpdate();
              
                  } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error en borrar inscripción por id alumno.\n"+ex.getMessage());
      }
    }
    
    
       public void eliminarInscripcionPorIdMateria(int id){
      try {
          PreparedStatement p=con.prepareStatement("Delete from inscripcion where idMateria=?");
          p.setInt(1,id);
          p.executeUpdate();
              
                  } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error en borrar inscripción por id alumno.\n"+ex.getMessage());
      }
    }
    
       public List<Alumno> alumnosInscriptos(){
         ArrayList<Alumno> lista=new ArrayList();
           
           try {
          
          
          PreparedStatement p=con.prepareStatement("select * \n" +
                                                   "from alumno\n" +
                                                   "where idAlumno in (\n" +
                                                   "select distinct idAlumno\n" +
                                                   "from inscripcion\n" +
                                                   ") ;");
          ResultSet r=p.executeQuery();
          while(r.next()){
              Alumno a=new Alumno();
              a.setIdAlumno(r.getInt("idAlumno"));
              a.setDni(r.getInt("dni"));
              a.setApellido(r.getString("apellido"));
              a.setNombre(r.getString("nombre"));
              a.setFechaNacimiento(r.getDate("fechaNacimiento").toLocalDate());
              a.setEstado(r.getBoolean("estado"));
              lista.add(a);
          }
          r.close();
          p.close();
                  
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Error en inscripciónData, al buscar a los alumnos inscriptos.\n"+ex.getMessage());
      }
            return lista;
        }

   
}
