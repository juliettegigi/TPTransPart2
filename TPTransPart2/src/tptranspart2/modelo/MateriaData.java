/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author julie
 */
public class MateriaData {

    static Connection c;
    static PreparedStatement p;
    static String sql;
    public static boolean insertarMateria(Materia m){
        
        c=Conexion.getConexion();
        if(c==null)  //agregar esto
           return false;
        
        try {
            //quito el modo automático, le voy a decir cuando confirmo realizar todo, q es antes de cerrar el try sino ejecuta todo
       //     c.setAutoCommit(false);
            System.out.println("hola");
            p= c.prepareStatement("INSERT INTO materia(nombre,año, estado) VALUES (?,?,?);");
            p.setString(1,m.getNombre());
            p.setInt(2,m.getAnio());
            p.setBoolean(3,m.isEstado());
            p.execute();
         //    c.commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
         //   hacerRollback();
        
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
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
             finally{
               cerrarcyp();
           }
        return false;
    }
    
 private static void cerrarcyp(){
         try {
                    // cierro las
                    p.close();
                    c.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex1);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
 }
    
    
    
}
