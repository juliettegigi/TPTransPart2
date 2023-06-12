/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tptranspart2.entidades.Alumno;

/**
 *
 * @author julie
 */
public class AlumnoData {

  Connection con;

    public AlumnoData() {
        con=Conexion.getConexion();
    }

    public void  guardarAlumno(Alumno a) {
       

        try {
            PreparedStatement p = con.prepareStatement("INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) VALUES (?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            p.setInt(1, a.getDni());
            p.setString(2, a.getApellido());
            p.setString(3, a.getNombre());
            p.setDate(4, Date.valueOf(a.getFechaNacimiento()));
            p.setBoolean(5, a.isEstado());
            int filasAfectadas=p.executeUpdate();
            ResultSet r=p.getGeneratedKeys();
            if(r.next())
                a.setIdAlumno(r.getInt("idAlumno"));
            r.close();
            p.close();
            
            if(filasAfectadas>0)
              JOptionPane.showMessageDialog(null,"Alumno insertado");
            else JOptionPane.showMessageDialog(null,"El alumno ingresado no ha sido insertado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar.\n"+ex.getMessage());

        } 
        
     
    }

    public Alumno buscarAlumnoActivo(int id) {

        Alumno a = null;
        try {
            PreparedStatement p = con.prepareStatement("SELECT * FROM alumno WHERE idAlumno=? and estado=true;");
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
            }
            p.close();
            rs.close();
            return a;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar alumno.\n"+ex.getMessage());
        }
         JOptionPane.showMessageDialog(null,"El alumno ingresado no existe.\n");
        return a;
    }

    public Alumno buscarAlumnoPorDni(int dni) {
       
        Alumno a = null;
        try {
            PreparedStatement p = con.prepareStatement("SELECT * FROM alumno WHERE dni=? and estado=true");
            p.setInt(1, dni);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                return a;
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al BuscarAlumnoPorId.\n"+ex.getMessage());
        }
        JOptionPane.showMessageDialog(null,"El alumno ingresado no existe.\n");
        return a;
    }

    public List<Alumno> listarAlumnosTodos() {
        Alumno a = null;
        List<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement("SELECT * FROM alumno");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                alumnos.add(a);
            }
            p.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al listarAlumnos.\n"+ex.getMessage());
        }
        return alumnos;
    }

        public  List<Alumno> listarAlumnosActivos(boolean activo) {
       

        List<Alumno> alumnos = new ArrayList<>();
        try { 
            
            PreparedStatement p = con.prepareStatement("SELECT * FROM alumno WHERE estado=?");
           p.setBoolean(1, activo);
            ResultSet rs = p.executeQuery();
             
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
                alumnos.add(a);
            }
            rs.close();
            p.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al listarAlumnosActivos.\n"+ex.getMessage());
        };

        return alumnos;
    }
    
   
    public void modificarAlumno(Alumno a) {
       

        try {
            PreparedStatement p = con.prepareStatement("UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaNacimiento=? WHERE idAlumno=? and estado=?;");
            p.setInt(1, a.getDni());
            p.setString(2, a.getApellido());
            p.setString(3, a.getNombre());
            p.setDate(4, Date.valueOf(a.getFechaNacimiento()));
            p.setInt(5, a.getIdAlumno());
            p.setBoolean(6, a.isEstado());
            int filasAfectadas=p.executeUpdate();
         
            if(filasAfectadas>0)
                JOptionPane.showMessageDialog(null,"Alumno actualizado.\n");
            else
                JOptionPane.showMessageDialog(null,"El alumno no existe.\n");
            p.close();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificarAlumno.\n"+ex.getMessage());

        } 
    }

    public void desactivarAlumno(int id) {
       InscripcionData inscripcionData=new InscripcionData();

        try {
            PreparedStatement p = con.prepareStatement("UPDATE alumno SET estado=false WHERE idAlumno=? and estado=true");
            p.setInt(1, id);
            int filasAfectadas=p.executeUpdate();
            if(filasAfectadas>0)
                JOptionPane.showMessageDialog(null,"Alumno eliminado.\n");
            else  
                 JOptionPane.showMessageDialog(null,"El alumno no existe.\n");
            p.close();
            inscripcionData.eliminarInscripcionPorIdAlumno(id);
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error en darBajaAlumno.\n"+ex.getMessage());
        }
    }
    
    public void activarAlumno(int id){
        
      try {
          PreparedStatement p=con.prepareStatement("Update alumno set estado=1 where idAlumno=?");
          p.setInt(1, id);
          int filasAfectadas=p.executeUpdate();
          if(filasAfectadas>0)
               JOptionPane.showMessageDialog(null,"Alumno activado\n");
          else  JOptionPane.showMessageDialog(null,"El alumno no existe o ya se encuentra activado.\n");
          p.close();
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Error en activarAlumno.\n"+ex.getMessage());
      }
    }
    

    public void eliminarAlumno(int id) {
        

        try {
            PreparedStatement p = con.prepareStatement("DELETE FROM alumno WHERE idAlumno=?;");
            p.setInt(1, id);
            int filasAfectadas=p.executeUpdate();
            if(filasAfectadas>0)
                  JOptionPane.showMessageDialog(null,"Alumno eliminado de la base de datos.\n");
            else  JOptionPane.showMessageDialog(null,"El alumno ingresado no existe.\n");
            p.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error eliminar alumno.\n"+ex.getMessage());

        }
    }

   
      
    
    
    
}
