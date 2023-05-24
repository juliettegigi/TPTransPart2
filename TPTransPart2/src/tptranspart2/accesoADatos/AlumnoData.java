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
import java.util.ArrayList;
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
    }

    public static boolean guardarAlumno(Alumno a) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("INSERT INTO alumno(dni,nombre,apellido,estado,fechaNacimiento) VALUES (?,?,?,?,?);");
            p.setInt(1, a.getDni());
            p.setString(2, a.getNombre());
            p.setString(3, a.getApellido());
            p.setBoolean(4, a.isEstado());
            p.setDate(5, Date.valueOf(a.getFechaNacimiento()));
            p.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("guardarAlumno ()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return false;
    }

    public static Alumno buscarAlumno(int id) {
        Alumno a = null;
        String query = "SELECT * FROM alumno WHERE idAlumno=?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                //a.setFechaNacimiento(rs.getDate("fechaNacimiento"))); PROBLEMA DATE
                a.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex){
            System.out.println("buscarAlumno()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public static Alumno buscarAlumnoPorDni(int dni){
        Alumno a = null;
        String query = "SELECT * FROM alumno WHERE dni=?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                //a.setFechaNacimiento(rs.getDate("fechaNacimiento"))); PROBLEMA DATE
                a.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex){
            System.out.println("buscarAlumnoPorDni()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public static List<Alumno> listarAlumnos() {
        Alumno a = null;
        List<Alumno> alumnos = new ArrayList<>();
        String query = "SELECT * FROM alumno";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                //a.setFechaNacimiento(rs.getDate("fechaNacimiento"))); PROBLEMA DATE
                a.setEstado(rs.getBoolean("estado"));
                alumnos.add(a);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("listarAlumnos()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

    public static boolean darBajaAlumno(int id) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("UPDATE alumno SET estado=false WHERE idAlumno=?");
            p.setInt(1, id);
            p.execute();
            
        } catch (SQLException ex) {
            System.out.println("darBajaAlumno()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return true;
    }
    
    public static boolean eliminarAlumno (int id){
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("DELETE alumno WHERE idAlumno=?");
            p.setInt(1, id);
            p.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("eliminarAlumno()");
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
            System.out.println("modificarAlumno()");
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
