/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2;

import tptranspart2.modelo.Materia;
import tptranspart2.modelo.MateriaData;



/**
 *
 * @author julie
 */
public class TPTransPart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Materia m=new Materia("jjjjj",5,true);
       
     
       
        System.out.println(MateriaData.insertarMateria(m));
    }
    
}
