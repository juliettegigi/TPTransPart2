/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.accesoADatos;

import tptranspart2.accesoADatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tptranspart2.entidades.Materia;


/**
 *
 * @author julie
 */
public class MateriaData {

    static Connection c;
    static PreparedStatement p;
   
    public static boolean insertarMateria(Materia m){
        
        c=Conexion.getConexion();
        if(c==null)  
           return false;
        
        try {
           
            System.out.println("hola");
            p= c.prepareStatement("INSERT INTO materia(nombre,año, estado) VALUES (?,?,?);");
            p.setString(1,m.getNombre());
            p.setInt(2,m.getAnio());
            p.setBoolean(3,m.isEstado());
            p.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("insertarMateria(Materia m)");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        finally{ 
            cerrarcyp();         
        }
        return false;
    }
   
    
       public static boolean borrarMateria(int id){
        c=Conexion.getConexion();
        if(c==null)
            return false;
        try {
            p= c.prepareStatement("UPDATE materia SET estado=false WHERE idMateria=?");
            p.setInt(1,id);
            p.execute();
            return true;
           } catch (SQLException ex) {
                System.out.println("borrarMateria()");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
             finally{
               cerrarcyp();
           }
        return false;
    }
    
 private static void cerrarcyp(){
         try {
                    
                    p.close();
                    c.close();
                } catch (SQLException ex1) {
                    System.out.println("cerrarcyp()");
                    Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex1);
                }
                catch(Exception e){
                     System.out.println("cerrarcyp()");
                    e.printStackTrace();
                }
 }
    
    
    
}
