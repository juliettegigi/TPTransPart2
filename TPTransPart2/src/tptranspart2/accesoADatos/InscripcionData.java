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

    public boolean guardarInscripcion(Inscripcion i) {
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?,?,?)";
        try {
            p = Conexion.getConexion().prepareStatement(sql);
            p.setInt(1, i.getAlumno().getIdAlumno());
            p.setInt(2, i.getMateria().getIdMateria());
            p.setDouble(3, i.getNota());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar inscripcion: " + e.toString());
            return false;
        }
    }

    public static List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> retorno = new ArrayList();
        c = Conexion.getConexion();

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
            System.out.println("updateInscripcion(Inscripcion ins)");
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            cerrarcyp();
        }

        return retorno;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        
    }

    public List<Materia> obtenerMateriasNOCursadas(int id) {
        
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        
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
