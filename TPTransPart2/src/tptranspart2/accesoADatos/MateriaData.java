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
import javax.swing.JOptionPane;
import tptranspart2.entidades.Materia;

/**
 *
 * @author julie
 */
public class MateriaData {
    
    Connection con=null;
    
    public MateriaData(){
        con=Conexion.getConexion();
    }
    
    public void guardarMateria(Materia m) {
      

        try {
            PreparedStatement p = con.prepareStatement("INSERT INTO materia(nombre,año, estado) VALUES (?,?,?);",Statement.RETURN_GENERATED_KEYS);
            p.setString(1, m.getNombre());
            p.setInt(2, m.getAnio());
            p.setBoolean(3, m.isEstado());
            int filasAfectadas=p.executeUpdate();
            ResultSet r=p.getGeneratedKeys();
            if(r.next())
                m.setIdMateria(r.getInt("idMateria"));
            
              if(filasAfectadas>0)
              JOptionPane.showMessageDialog(null,"Materia insertada.");
            else JOptionPane.showMessageDialog(null,"La materia ingresado no ha sido insertada.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en guardarMateria.\n" +ex.getMessage());

        }
     
        
    }

    public  List<Materia> listarMaterias() {
        
        Materia m = null;
        List<Materia> materias = new ArrayList<>();

        try {
           PreparedStatement p = con.prepareStatement("SELECT * FROM materia where estado=true;");
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
            JOptionPane.showMessageDialog(null, "Error en listarMaterias.\n"+ex.getMessage());
        }catch(Exception e){} 
       
        return materias;
    }

    
   
    public Materia buscarMateria(int id) {
        Materia m = null;
        try { 
            PreparedStatement p = con.prepareStatement("SELECT * FROM materia WHERE idMateria=? and estado=1;");
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("año"));
                m.setEstado(rs.getBoolean("estado"));
                return m;
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al buscar materia.\n"+ ex.getMessage());
        }catch(Exception e){} 
      
     
               

        return m;
    }

    public void modificarMateria(Materia materia) {
        

        try {
            PreparedStatement p = con.prepareStatement("UPDATE materia SET nombre=?,año=?,estado=? WHERE idMateria=? and estado=true;");
            p.setString(1, materia.getNombre());
            p.setInt(2, materia.getAnio());
            p.setBoolean(3, materia.isEstado());
            p.setInt(4, materia.getIdMateria());
           int filasAfectadas=p.executeUpdate();
           if(filasAfectadas>0)
               JOptionPane.showMessageDialog(null,"Materia modificada.\n");
           else JOptionPane.showMessageDialog(null,"La materia no existe.");
            
            p.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error en modificarMateria"+ ex.getMessage());

        } 
      
       
    }

    public void desactivarMateria(int id) {
        try {
            PreparedStatement p = con.prepareStatement("UPDATE materia SET estado=false WHERE idMateria=?");
            p.setInt(1, id);
            int filasAfectadas=p.executeUpdate();
           if(filasAfectadas>0)
               JOptionPane.showMessageDialog(null, "Materia con, id=+"+id+ ", dada de baja.");
           else
               JOptionPane.showMessageDialog(null, "La materia no existe.");
           p.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error en desactivarMateria"+ex.getMessage());

        }
      
      
    }
    
        public void activarMateria(int id) {
        try {
            PreparedStatement p = con.prepareStatement("UPDATE materia SET estado=true WHERE idMateria=?");
            p.setInt(1, id);
            int filasAfectadas=p.executeUpdate();
           if(filasAfectadas>0)
               JOptionPane.showMessageDialog(null, "Materia dada de alta.");
           else
               JOptionPane.showMessageDialog(null, "La materia no existe o la materia ya está en alta");
           p.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error en activarMateria"+ex.getMessage());

        }
      
      
    }

    public void eliminarMateria(int id) {
        
        try {
            PreparedStatement p = con.prepareStatement("DELETE FROM materia WHERE idMateria=?");
            p.setInt(1, id);
            int filasAfectadas = p.executeUpdate();
            if(filasAfectadas>0)
                JOptionPane.showMessageDialog(null, "Materia eliminada.");
            else JOptionPane.showMessageDialog(null, "La materia no existe");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en eliminarMateria.\n"+ex.getMessage());

        } 
    }
    
    
    
          public  List<Materia> listarMateriasActivas(boolean activo) {
       

        List<Materia> materias = new ArrayList<>();
        try { 
            
            PreparedStatement p = con.prepareStatement("SELECT * FROM materia WHERE estado=?");
           p.setBoolean(1, activo);
            ResultSet rs = p.executeQuery();
             
            while (rs.next()) {
                Materia a = new Materia();
                a.setIdMateria(rs.getInt("idMateria"));
                a.setNombre(rs.getString("nombre"));
                a.setAnio(rs.getInt("año"));
                a.setEstado(rs.getBoolean("estado"));
                materias.add(a);
            }
            rs.close();
            p.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al listarAlumnosActivos.\n"+ex.getMessage());
        };

        return materias;
    }


    
    


}
