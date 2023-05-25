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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tptranspart2.entidades.Alumno;
import tptranspart2.entidades.Inscripcion;
import tptranspart2.entidades.Materia;

/**
 *
 * @author julie
 */
public class InscripcionData {

    private static Connection c;
    private static PreparedStatement p;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
    }

    public static boolean guardarInscripcion(Inscripcion i) {
        c = Conexion.getConexion();
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?,?,?)";
        try {
            p = Conexion.getConexion().prepareStatement(sql);
            p.setInt(1, i.getAlumno().getIdAlumno());
            p.setInt(2, i.getMateria().getIdMateria());
            p.setDouble(3, i.getNota());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR en guardarInscripcion()");
            return false;
        }
    }

    public static List<Inscripcion> obtenerInscripciones() {
        c = Conexion.getConexion();
        List<Inscripcion> retorno = new ArrayList();

        try {
            p = c.prepareStatement("SELECT * FROM inscripcion;");
            ResultSet r = p.executeQuery();
            while (r.next()) {

                int id = r.getInt("idInscripto");
                Inscripcion i = new Inscripcion();
                i.setIdInscripto(id);

                id = r.getInt("idAlumno");
                Alumno a = AlumnoData.buscarAlumno(id);
                i.setAlumno(a);

                id = r.getInt("idMateria");
                Materia m = MateriaData.buscarMateria(id);
                i.setMateria(m);
                i.setNota(r.getDouble("nota"));
                retorno.add(i);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR en obtenerInscripcion()");
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            cerrarcyp();
        }

        return retorno;
    }

    public static List<Materia> obtenerMateriasCursadas(int id) {
        c = Conexion.getConexion();
        List<Materia> m = new ArrayList<Materia>();

        try {
            String sql = "SELECT * FROM materia WHERE id IN (SELECT idMateria FROM cursada WHERE idAlumno=?);";
            p = c.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(r.getInt("idMateria"));
                mat.setNombre(r.getString("nombre"));
                m.add(mat);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR en obtenerMateriasCursadas " + ex.toString());
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            cerrarcyp();
        }
        return m;
    }

    public static List<Materia> obtenerMateriasNOCursadas(int id) {
        c = Conexion.getConexion();
        List<Materia> materias = new ArrayList<Materia>();
        try {
            String sql = "SELECT * FROM materia WHERE id NOT IN (SELECT idMateria FROM cursada WHERE idAlumno =?);";
            p = c.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(r.getInt("idMateria"));
                materia.setNombre(r.getString("nombre"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR en obtenerMateriasNOCursadas(int id)");
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            cerrarcyp();
        }
        return materias;
    }

    public static void actualizarNota(int idAlumno, int idMateria, int nota) {
        c = Conexion.getConexion();
        try {
            p = c.prepareStatement("UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?;");
            p.setInt(1, nota);
            p.setInt(2, idAlumno);
            p.setInt(3, idMateria);
            p.execute();

        } catch (SQLException ex) {
            System.out.println("ERROR en actualizarNota()");
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
    }

    public static List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        c = Conexion.getConexion();
        List<Alumno> lista = new ArrayList();
        try {
            p = c.prepareStatement("SELECT inscripcion.idalumno\n"
                    + "FROM materia,alumno,inscripcion\n"
                    + "WHERE inscripcion.idAlumno = alumno.idAlumno \n"
                    + "AND inscripcion.idMateria=materia.idMateria\n"
                    + "AND materia.idMateria=?;");
            p.setInt(1, idMateria);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Alumno a = AlumnoData.buscarAlumno(rs.getInt("idAlumno"));
                lista.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR en obtenerAlumnosPorMateria()");
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }

        return lista;
    }

    //obtenerInscripcionesPorAlumno ()
    
    public static void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        c = Conexion.getConexion();

        try {
            p = c.prepareStatement("DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?;");
            p.setInt(1, idAlumno);
            p.setInt(2, idMateria);
            p.execute();

        } catch (SQLException ex) {
            System.out.println("ERROR en borrarInscripcionMateriaAlumno()");
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
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
