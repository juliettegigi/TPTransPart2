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
import tptranspart2.entidades.Materia;

/**
 *
 * @author julie
 */
public class MateriaData {

    private static Connection c;
    private static PreparedStatement p;

    public MateriaData() {
    }

    public static boolean guardarMateria(Materia m) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }

        try {
            System.out.println("hola");
            p = c.prepareStatement("INSERT INTO materia(nombre,año, estado) VALUES (?,?,?);");
            p.setString(1, m.getNombre());
            p.setInt(2, m.getAnio());
            p.setBoolean(3, m.isEstado());
            p.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("guardarMateria(Materia m)");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            cerrarcyp();
        }
        return false;
    }
    
    public static List<Materia> listarMaterias(){ 
       Materia m = null;
        List<Materia> materias = new ArrayList<>();
        String query = "SELECT * FROM materia";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio")); //VER SI FUNCIONA CON EL NOMBRE DEL SQL
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("listarMaterias()");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }

    public static Materia buscarMateria(int id){ 
        Materia m = null;
        String query = "SELECT * FROM materia WHERE idMateria=?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio")); //VER SI FUNCIONA CON EL NOMBRE DEL SQL
                m.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex){
            System.out.println("buscarMateria()");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
 
    public static boolean eliminarMateria(int id) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("DELETE materia WHERE idMateria=?");
            p.setInt(1, id);
            p.execute();

        } catch (SQLException ex) {
            System.out.println("eliminarMateria()");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return true;
    }

    public static boolean darBajaMaterias(int id) {
        c = Conexion.getConexion();
        if (c == null) {
            return false;
        }
        try {
            p = c.prepareStatement("UPDATE materia SET estado=false WHERE idMateria=?");
            p.setInt(1, id);
            p.execute();

        } catch (SQLException ex) {
            System.out.println("darBajaMateria()");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return true;
    }

    public static boolean modificarMateria(Materia materia) {
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
            System.out.println("modificarMateria()");
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
