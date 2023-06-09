/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tptranspart2.accesoADatos.AlumnoData;
import tptranspart2.accesoADatos.InscripcionData;
import tptranspart2.entidades.Alumno;
import tptranspart2.entidades.Inscripcion;
import tptranspart2.entidades.Materia;



/**
 *
 * @author julie
 */
public class ManejoInscripcionesView extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private ArrayList<Alumno> listaAlumnos;
    private AlumnoData alumnoData=new AlumnoData();
    private InscripcionData inscripcionData=new InscripcionData();
    /**
     * Creates new form ManejoInscripcionesView
     */
    public ManejoInscripcionesView() {
        
        initComponents();
        modelo=new DefaultTableModel();
        listaAlumnos=(ArrayList<Alumno>) alumnoData.listarAlumnosActivos(true);
        cargarAlumnos();
        armarCabeceraTabla();
        jRadioButtonIns.setSelected(true);
        llenarTabla(true);
        jbInscribir.setEnabled(false);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButtonSeleccionado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAlumnos = new javax.swing.JComboBox<>();
        jbAnular = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jRadioButtonNoIns = new javax.swing.JRadioButton();
        jRadioButtonIns = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableT = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jbInscribir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de inscripcion");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alumno");

        jComboBoxAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlumnosActionPerformed(evt);
            }
        });

        jbAnular.setText("Anular inscrpcion");
        jbAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        radioButtonSeleccionado.add(jRadioButtonNoIns);
        jRadioButtonNoIns.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonNoIns.setText("No inscripto");
        jRadioButtonNoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNoInsActionPerformed(evt);
            }
        });

        radioButtonSeleccionado.add(jRadioButtonIns);
        jRadioButtonIns.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonIns.setText("Inscripto");
        jRadioButtonIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInsActionPerformed(evt);
            }
        });

        jTableT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTableT);

        jDesktopPane1.setLayer(jRadioButtonNoIns, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jRadioButtonIns, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jRadioButtonIns)
                .addGap(62, 62, 62)
                .addComponent(jRadioButtonNoIns)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonNoIns)
                    .addComponent(jRadioButtonIns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Listado de materias");

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jbInscribir)
                        .addGap(44, 44, 44)
                        .addComponent(jbAnular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbInscribir)
                        .addComponent(jbAnular))
                    .addComponent(jButtonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //boton salir
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed
   
    private void jComboBoxAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlumnosActionPerformed
      if(jRadioButtonIns.isSelected()){
          botonInscripto(true);
      }
      if(jRadioButtonNoIns.isSelected()){
          botonInscripto(false);
      }
      
    }//GEN-LAST:event_jComboBoxAlumnosActionPerformed
    
    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
                        

// boton Inscribir
        
        //ver que fila de la tabla me seleccionó el user(empizan desde cero, me retorna -1 si no hay nada seleccionado)
        int fila=jTableT.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this,"Tiene que seleccionar una materia");
            return;
        }
            
        Materia m=new Materia();
        // cargo en una variable todos los datos de la materia seleccionada
        m.setIdMateria((int) jTableT.getValueAt(fila, 0));
        m.setNombre((String) jTableT.getValueAt(fila, 1));
        m.setAnio((int) jTableT.getValueAt(fila, 2));
        m.setEstado(true);
        
        
        // public Inscripcion(Alumno alumno, int nota, Materia materia)
        Alumno a=(Alumno)jComboBoxAlumnos.getSelectedItem();
        Inscripcion i=new Inscripcion(a,0,m);
        //ahora inscribo, tengo q pasarle una inscripción
        inscripcionData.guardarInscripcion(i);
        llenarTabla(false);
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jbAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularActionPerformed
        // boton Anular Inscripcion
        
        ////ver que fila de la tabla me seleccionó el user(empizan desde cero, me retorna -1 si no hay nada seleccionado)
          int fila=jTableT.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this,"Tiene que seleccionar una materia");
            return;
        }
        
        //tengo que eliminar la inscripcion
        // tengo que usar esto:  borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) 
        
        // obtengo el alumno del combobox
        int ida =((Alumno)jComboBoxAlumnos.getSelectedItem()).getIdAlumno();
        //obtengo el id de la mteria seleccionada en la tabla
        int idm=(int) jTableT.getValueAt(fila, 0);
        
        inscripcionData.borrarInscripcionMateriaAlumno(ida, idm);
        llenarTabla(true);      
      
    }//GEN-LAST:event_jbAnularActionPerformed

    
    private void botonInscripto(boolean f){
           //boton Inscripto
        
         
        //las muestro en la tablas
        llenarTabla(f);
        // deshabilito el botón "inscribir"
        jbAnular.setEnabled(f);
        jbInscribir.setEnabled(!f);
    }
    
    
    
    private void jRadioButtonInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInsActionPerformed
       botonInscripto(true);
    }//GEN-LAST:event_jRadioButtonInsActionPerformed

    private void jRadioButtonNoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNoInsActionPerformed
       botonInscripto(false);
    }//GEN-LAST:event_jRadioButtonNoInsActionPerformed
    
    

    
       private void cargarAlumnos(){
     
        for(Alumno item:listaAlumnos)
            jComboBoxAlumnos.addItem(item);
        
    }
    
    private void armarCabeceraTabla(){
           ArrayList<Object> columna=new ArrayList<>();
           columna.add("ID");
           columna.add("Nombre");
           columna.add("Año");

           for(Object it:columna){
               modelo.addColumn(it);
           }
           
          
           jTableT.setModel(modelo);
       }
    
    private void llenarTabla(boolean f){
        borrarFilas();
        ArrayList<Materia> listaMaterias=null;
         
          Alumno a=(Alumno)jComboBoxAlumnos.getSelectedItem();
        //obtengo la lista de las materias q cursa el alumno seleccionado
        if(f==true)
            listaMaterias=(ArrayList<Materia>) inscripcionData.obtenerMateriasCursadas(a.getIdAlumno());
        else listaMaterias=(ArrayList<Materia>) inscripcionData.obtenerMateriasNOCursadas(a.getIdAlumno()); 
            
        for(Materia m:listaMaterias){
                modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(),m.getAnio()});
               
            }
             
       
    }
    public void borrarFilas(){
        int a=modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<Alumno> jComboBoxAlumnos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonIns;
    private javax.swing.JRadioButton jRadioButtonNoIns;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableT;
    private javax.swing.JButton jbAnular;
    private javax.swing.JButton jbInscribir;
    private javax.swing.ButtonGroup radioButtonSeleccionado;
    // End of variables declaration//GEN-END:variables
}
