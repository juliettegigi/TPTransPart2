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

        try {
            p = c.prepareStatement("INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) VALUES (?,?,?,?,?);");
            p.setInt(1, a.getDni());
            p.setString(2, a.getApellido());
            p.setString(3, a.getNombre());
            p.setDate(4, Date.valueOf(a.getFechaNacimiento()));
            p.setBoolean(5, a.isEstado());
            p.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("guardarAlumno ()");

        } finally {
            cerrarcyp();
            System.out.println("ewqe");
        }
        return false;
    }

    public static Alumno buscarAlumno(int id) {
        c = Conexion.getConexion();

        Alumno a = null;
        ResultSet rs = null;
        try {
            p = c.prepareStatement("SELECT * FROM alumno WHERE idAlumno=?;");
            p.setInt(1, id);
            rs = p.executeQuery();
            if (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
            }

        } catch (SQLException ex) {
            System.out.println("buscarAlumno()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return a;
    }

    public static Alumno buscarAlumnoPorDni(int dni) {
        c = Conexion.getConexion();
        Alumno a = null;
        try {
            p = c.prepareStatement("SELECT * FROM alumno WHERE dni=?");
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
            }
            p.close();
        } catch (SQLException ex) {
            System.out.println("buscarAlumnoPorDni()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return a;
    }

    public static List<Alumno> listarAlumnos() {
        c = Conexion.getConexion();

        Alumno a = null;
        List<Alumno> alumnos = new ArrayList<>();
        try {
            p = c.prepareStatement("SELECT * FROM alumno");
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

        } catch (SQLException ex) {
            System.out.println("listarAlumnos()");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return alumnos;
    }

    public static boolean modificarAlumno(Alumno a) {
        c = Conexion.getConexion();

        try {
            p = c.prepareStatement("UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaNacimiento=?,estado=? WHERE idAlumno=?;");
            p.setInt(1, a.getDni());
            p.setString(2, a.getApellido());
            p.setString(3, a.getNombre());
            p.setDate(4, Date.valueOf(a.getFechaNacimiento()));
            p.setBoolean(5, a.isEstado());
            p.setInt(6, a.getIdAlumno());
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

    public static boolean darBajaAlumno(int id) {
        c = Conexion.getConexion();

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

    public static boolean eliminarAlumno(int id) {
        c = Conexion.getConexion();

        try {
            p = c.prepareStatement("DELETE FROM alumno WHERE idAlumno=?;");
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
