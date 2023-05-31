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
import javax.swing.JOptionPane;
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

        try {
            p = c.prepareStatement("INSERT INTO materia(nombre,año, estado) VALUES (?,?,?);");
            p.setString(1, m.getNombre());
            p.setInt(2, m.getAnio());
            p.setBoolean(3, m.isEstado());
            p.execute();
            obtenetIdGenerado(m); 
           
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
           // Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            cerrarcyp();
        }
        return false;
    }

    public static List<Materia> listarMaterias() {
        c = Conexion.getConexion();
        Materia m = null;
        List<Materia> materias = new ArrayList<>();

        try {
            p = c.prepareStatement("SELECT * FROM materia;");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }
            p.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
           // Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return materias;
    }

    
   
    public static Materia buscarMateria(int id) {
        c = Conexion.getConexion();
        Materia m = null;
        try { //SELECT * FROM materia WHERE idMateria=5 AND estado=1;
            p = c.prepareStatement("SELECT * FROM materia WHERE idMateria=? AND estado=1;");
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            //Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarcyp();
        }
        return m;
    }

    public static boolean modificarMateria(Materia materia) {
        c = Conexion.getConexion();

        try {
            p = c.prepareStatement("UPDATE materia SET nombre=?,año=?,estado=? WHERE idMateria=?;");
            p.setString(1, materia.getNombre());
            p.setInt(2, materia.getAnio());
            p.setBoolean(3, materia.isEstado());
            p.setInt(4, materia.getIdMateria());
            p.executeUpdate();
            return true;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
           // Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            cerrarcyp();
        }
        return false;
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
            return true;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
           // Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            cerrarcyp();
        }
        return false;
    }

    public static boolean eliminarMateria(int id) {
        c = Conexion.getConexion();
        try {
            p = c.prepareStatement("DELETE FROM materia WHERE idMateria=?");
            p.setInt(1, id);
            p.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("eliminarMateria()");
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
    
    
    
    private static void obtenetIdGenerado(Materia m){
        c = Conexion.getConexion();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT MAX(idMateria) FROM materia");
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
               int idGenerado = resultSet.getInt(1);
               m.setIdMateria(idGenerado);
                
               
               ps.close();
               resultSet.close();
}
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

}
