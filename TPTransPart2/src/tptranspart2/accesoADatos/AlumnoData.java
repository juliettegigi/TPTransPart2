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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tptranspart2.entidades.Alumno;

/**
 *
 * @author julie
 */

public class AlumnoData {
    
    private static Connection c;
    private static PreparedStatement p;

    public AlumnoData() {
        c = Conexion.getConexion();
    }
    

    public static boolean guardarAlumno(Alumno a) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }

        try {
            System.out.println("hola");
            p = c.prepareStatement("INSERT INTO alumno(dni,nombre,apellido,estado,fechaNacimiento) VALUES (?,?,?,?,?);");
            p.setInt(1, a.getDni());
            p.setString(2, a.getNombre());
            p.setString(3, a.getApellido());
            p.setBoolean(4, a.isEstado());
            p.setDate(5, Date.valueOf(a.getFechaNacimiento()));
            p.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("guardarAlumno (Alumno a)");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            cerrarcyp();
        }
        return false;
    }
    
    /* FALTAN 4 METODOS Y ARREGLAR FECHA
    
    public static Alumno buscarAlumno(int id){
    }
    
    public  Alumno buscarAlumnoPorDni(int dni){
    }
    
    public static List<Alumno> listasAlumnos(){  
    }
    
    public static boolean eliminarAlumno (ind id) CON DELETE {
    CON DELETE
    }
    */
    
    public static boolean darBajaAlumno(int id) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("UPDATE alumno SET estado=false WHERE idAlumno=?");
            p.setInt(1, id);
            p.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("darBajaAlumno()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return false;
    }

    public static boolean modificarAlumno(Alumno a) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("UPDATE alumno SET dni=?,nombre=?,apellido=?,estado=?,fechaNacimiento=? WHERE idAlumno=?");
            
            p.setInt(1, a.getDni());
            p.setString(2, a.getNombre());
            p.setString(3, a.getApellido());
            p.setBoolean(4, a.isEstado());
            p.setDate(5, Date.valueOf(a.getFechaNacimiento()));
            
            p.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("updateAlumno()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return false;
    }

    private static void cerrarcyp() {
        try {
            p.close();
            c.close();
        } catch (SQLException ex1) {
            System.out.println("cerrarcyp()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (Exception e) {
            System.out.println("cerrarcyp()");
            e.printStackTrace();
        }
    }

    
}
