/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tptranspart2.entidades.Alumno;

/**
 *
 * @author julie
 */
public class AlumnoData {
    
    static Connection c;
    static PreparedStatement p;

    public static boolean insertarAlumno(Alumno a) {
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
            p.setDate(5, new java.sql.Date(a.getFechaNacimiento().));
            p.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("insertarAlumno (Alumno a)");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            cerrarcyp();
        }
        return false;
    }

    public static boolean borrarAlumno(int id) {
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
            System.out.println("borrarAlumno()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return false;
    }

    public static boolean updateMateria(Alumno materia) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("UPDATE materia SET nombre=?,año=?,estado=? WHERE idMateria=?");
            p.setString(1, materia.getNombre());
            p.setInt(2, materia.getAnio());
            p.setBoolean(3, materia.isEstado());
            p.setInt(4, materia.getIdMateria());
            p.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("updateMateria()");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (Exception e) {
            System.out.println("cerrarcyp()");
            e.printStackTrace();
        }
    }

    
}
