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
import tptranspart2.accesoADatos.InscripcionData;
import tptranspart2.accesoADatos.MateriaData;
import tptranspart2.entidades.Alumno;
import tptranspart2.entidades.Inscripcion;
import tptranspart2.entidades.Materia;

/**
 *
 * @author julie
 */
public class ManipulacionDeNotasView extends javax.swing.JInternalFrame {

    // para crear un objeto para guardar el modelo q va a tener la tabla. a ese 
    //modelo le digo q columnas va a tener la tabla y q fila quiero q visualice la tabla 
    private DefaultTableModel modelo;
    private ArrayList<Inscripcion> listaInscripcion;
    private ArrayList<Materia> listaMaterias;
    private ArrayList<Alumno> listaAlumnos;

    /**
     * Creates new form ManipulacionDeNotasView
     */
    public ManipulacionDeNotasView() {
        initComponents();
        modelo = new DefaultTableModel();
        listaInscripcion = (ArrayList<Inscripcion>) InscripcionData.obtenerInscripciones();
        listaMaterias = (ArrayList<Materia>) MateriaData.listarMaterias();
        listaAlumnos = (ArrayList<Alumno>) AlumnoData.listarAlumnosActivos();
        cargarAlumnos();
        armarCabeceraTabla();
        cargarDatos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbAlumno = new javax.swing.JLabel();
        cbxAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabNotas = new javax.swing.JTable();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setClosable(true);

        lbTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Carga de Notas");

        lbAlumno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAlumno.setText("Alumno");

        cbxAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumnoActionPerformed(evt);
            }
        });

        tabNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabNotas);

        btGuardar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btGuardar)
                        .addGap(97, 97, 97)
                        .addComponent(btCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnoActionPerformed
        cargarDatos();
    }//GEN-LAST:event_cbxAlumnoActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // guardar la nota 
        Alumno a=(Alumno) cbxAlumno.getSelectedItem();
        
        // ver que materia, que  fila de la tabla me seleccionó
              
        //ver que fila de la tabla me seleccionó el user(empizan desde cero, me retorna -1 si no hay nada seleccionado)
        int fila=tabNotas.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this,"Tiene que seleccionar una materia");
            return;
        }
          

            
 
        
        
        
         // Recorrer la tabla y obtener los datos
        for (int row = 0; row < tabNotas.getRowCount(); row++) {
                // recupero el id de la materia                 
                int m=Integer.parseInt(tabNotas.getValueAt(row, 0).toString());
                // valido que la nota sea válida
                double nota=Double.parseDouble((String) tabNotas.getValueAt(row, 2));
                if(nota<0 || nota>10){
                     JOptionPane.showMessageDialog(this, "Ingrese una nota válida(0-10)");
                     return;
                 }
                InscripcionData.actualizarNota(a.getIdAlumno(), m, nota);
        }
        
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    //inicializo el combo box
    public void cargarAlumnos(){
        for(Alumno item:listaAlumnos)
            cbxAlumno.addItem(item);
    }
    
    public void armarCabeceraTabla(){
        ArrayList<Object> columns=new ArrayList();
        columns.add("ID");
        columns.add("MATERIA");
        columns.add("NOTA");
        for(Object it:columns)
            modelo.addColumn(it);
        tabNotas.setModel(modelo);
    }
    
    
    public void borrarFilasTabla(){
      int a=modelo.getRowCount()-1;
      for(int i=a;i>=0;i--)
          modelo.removeRow(i);
    }
    
    public void cargarDatos(){
        borrarFilasTabla();
        Alumno a =(Alumno)cbxAlumno.getSelectedItem();
        for(Inscripcion m:listaInscripcion){
            if(m.getAlumno().getIdAlumno()==a.getIdAlumno())
                 modelo.addRow(new Object[]{m.getMateria().getIdMateria(),m.getMateria().getNombre(),m.getNota()});
                
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JComboBox<Alumno> cbxAlumno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAlumno;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tabNotas;
    // End of variables declaration//GEN-END:variables

}
