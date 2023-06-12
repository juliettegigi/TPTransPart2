/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tptranspart2.accesoADatos.AlumnoData;
import tptranspart2.accesoADatos.MateriaData;
import tptranspart2.entidades.Alumno;
import tptranspart2.entidades.Materia;

/**
 *
 * @author julie
 */
public class ActivarMateriaView extends javax.swing.JInternalFrame {
    private MateriaData materiaData=new MateriaData();
    private DefaultTableModel modelo;
    
    public ActivarMateriaView() {
        initComponents();
         modelo=new DefaultTableModel();
         armarCabeceraTabla();
         llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableT = new javax.swing.JTable();
        btnActivar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("LISTADO DE MATERIAS NO ACTIVAS");

        jTableT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableT);

        btnActivar.setText("Activar");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(btnActivar)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnActivar)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
      int fila=jTableT.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this,"Tiene que seleccionar a una materia.");
            return;
        }
        //recupero el id 
        int id=(int) jTableT.getValueAt(fila, 0);
        materiaData.activarMateria(id);
        llenarTabla();
    }//GEN-LAST:event_btnActivarActionPerformed


    
     private void armarCabeceraTabla(){
        //creo las columnas de la tabla
        ArrayList<Object> columns=new ArrayList();
        columns.add("ID");
        columns.add("NOMBRE");
        columns.add("AÑO");
       
        //recorro el arrayList, a nuestro modelo le agrego columnas
        for(Object it:columns)
            modelo.addColumn(it);
        //a la tabla alumno le cambio el modelo, le pongo este que tiene estas columnas(id,nombre, nota)
        jTableT.setModel(modelo);
                
    }
    
    public void borrarFilas(){
      int a=modelo.getRowCount()-1;
      for(int i=a;i>=0;i--)
          modelo.removeRow(i);
      
    }
    
    
   private void llenarTabla(){
        borrarFilas();
        ArrayList<Materia> listaMateria=null;
        
        //obtengo la lista de las materias q cursa el alumno seleccionado
        
            listaMateria=(ArrayList<Materia>) materiaData.listarMateriasActivas(false);
       
            if(listaMateria.isEmpty())
                return;
            
        for(Materia a:listaMateria){
                modelo.addRow(new Object[]{a.getIdMateria(),a.getNombre(),a.getAnio()});
               
            }
             
       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableT;
    // End of variables declaration//GEN-END:variables
}
