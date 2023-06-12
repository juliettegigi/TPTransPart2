

package tptranspart2.vistas;


import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import tptranspart2.accesoADatos.AlumnoData;
import tptranspart2.accesoADatos.InscripcionData;
import tptranspart2.accesoADatos.MateriaData;
import tptranspart2.entidades.Alumno;
import tptranspart2.entidades.Inscripcion;
import tptranspart2.entidades.Materia;


public class ListadoDeAlumnosPorMateriaView extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;// para crear un objeto para guardar el modelo q va a tener la tabla. a ese modelo le digo q columnas va a tener la tabla y q fila quiero q visualice la tabla 
    private ArrayList<Inscripcion> listaInscripcion;
    private ArrayList<Materia> listaMaterias;
    private ArrayList<Alumno> listaAlumnos;
  
    
    
    public ListadoDeAlumnosPorMateriaView() {
        
       initComponents();
       InscripcionData inscripcionData=new InscripcionData();
       MateriaData materiaData=new MateriaData();
       AlumnoData alumnoData=new AlumnoData();
       modelo=new DefaultTableModel();
       listaInscripcion=(ArrayList<Inscripcion>) inscripcionData.obtenerInscripciones();
       listaMaterias=(ArrayList<Materia>) materiaData.listarMaterias();
       listaAlumnos=(ArrayList<Alumno>) alumnoData.listarAlumnosActivos(true);
       cargarMaterias();
       armarCabeceraTabla();
       cargarDatos();
       
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlumnos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(600, 450));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("LISTADO DE ALUMNOS POR MATERIA");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("MATERIA");

        cbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriasActionPerformed(evt);
            }
        });

        tAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tAlumnos);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("ALUMNOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriasActionPerformed
        cargarDatos();
    }//GEN-LAST:event_cbMateriasActionPerformed

    
    //inicializo el combo box
    private void cargarMaterias(){
        for(Materia item:listaMaterias)
            cbMaterias.addItem(item);
        
    }
    
    private void armarCabeceraTabla(){
        //creo las columnas de la tabla
        ArrayList<Object> columns=new ArrayList();
        columns.add("ID");
        columns.add("NOMBRE");
        columns.add("NOTA");
        //recorro el arrayList, a nuestro modelo le agrego columnas
        for(Object it:columns)
            modelo.addColumn(it);
        //a la tabla alumno le cambio el modelo, le pongo este que tiene estas columnas(id,nombre, nota)
        tAlumnos.setModel(modelo);
                
    }
    
    
    public void borrarFilasTabla(){
      int a=modelo.getRowCount()-1;
      for(int i=a;i>=0;i--)
          modelo.removeRow(i);
      
    }
    
    
    private void cargarDatos(){
        borrarFilasTabla();
        Materia mat=(Materia)cbMaterias.getSelectedItem();
        for(Inscripcion m:listaInscripcion){
            if(m.getMateria().getIdMateria()==mat.getIdMateria())
                 modelo.addRow(new Object[]{m.getAlumno().getIdAlumno(),m.getAlumno().getNombre(),m.getNota()});// agrego una fila compuesta por estos 3 elementos
                
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> cbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tAlumnos;
    // End of variables declaration//GEN-END:variables
}
