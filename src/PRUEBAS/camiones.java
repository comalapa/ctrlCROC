/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PRUEBAS;

import clases.*;
import Conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Garcia
 */
public class camiones extends javax.swing.JDialog {
    
    private DefaultTableModel modelTable = null;
    private registroCamiones alta = null;
    private String[] titulos = new String[]{"Id","Marca","Modelo","Color","Placa","No. Serie","Contol Interno","Capacidad","Propietario"};
    public DefaultTableModel model=new DefaultTableModel(titulos,0);
    
    public camiones(java.awt.Frame parent, boolean modal) {
        super(parent,modal);    
        this.setTitle("Catalogo de Camiones");
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargarDatos();
        
    }
    
    public void getModel(){
        tblCamiones.setModel(model);
        tblCamiones.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblCamiones.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblCamiones.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblCamiones.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblCamiones.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblCamiones.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblCamiones.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblCamiones.getColumnModel().getColumn(7).setPreferredWidth(100);
        tblCamiones.getColumnModel().getColumn(8).setPreferredWidth(300);
    }
    
    private void deleteRowModelTable(){
        // Limpiamos el Modelo de la Tabla
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    
    private void cargarDatos(){
        getModel();
        deleteRowModelTable();
        conexion consql = new conexion();
        Statement stat = consql.conectar();
        
        if(stat!=null){
           ResultSet result = consql.ejecutarSQLSelect("SELECT * FROM tb_camion WHERE estatus_id = 1;");
            try {
                while(result.next()){
                            
                    model.addRow(new Object[]{result.getInt("id"),result.getString("marca"),result.getString("modelo"),result.getString("color"),result.getString("no_placa"),result.getString("no_serie"),result.getString("no_control"),result.getString("capacidad"),result.getString("propietario")});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCamiones = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Eliga una de las siguientes opciones para los camiones:");

        tblCamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MARCA", "MODELO", "PLACA", "SERIE", "CONTROL INTERNO", "CAPACIDAD", "PROPIETARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCamiones);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/application_edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRegistro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/application_add.png"))); // NOI18N
        btnRegistro.setText("Registro");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/application_remove.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistro)
                .addGap(31, 31, 31)
                .addComponent(btnModificar)
                .addGap(44, 44, 44)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistro)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        REGISTROCAMIONES registro = new REGISTROCAMIONES(this, true);
        registro.setVisible(true);
        boolean registrook= registro.registrook;
        if(registrook)
            cargarDatos();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tblCamiones.getSelectedRow() != -1){
            if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Esta a punto de eliminar el camion seleccionado.\n¿Desea continuar?","Alerta",JOptionPane.YES_NO_OPTION)){
                conexion consql = new conexion();

                    Statement stat = consql.conectar();
                    if(stat!=null){
                        if(consql.ejecutarSQL("UPDATE tb_camion SET estatus_id = 2 WHERE id="+Integer.parseInt(tblCamiones.getValueAt(tblCamiones.getSelectedRow(), 0).toString())+";")){
                            JOptionPane.showMessageDialog(this, "El camion se elimino correctamente");
                            cargarDatos();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Error al intentar aliminer el camion.\nPonsgase en contacto con el administrador del sistema");
                        }
                    }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un camion del catalogo");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tblCamiones.getSelectedRow() != -1) {
            conexion consql = new conexion();
            Statement stat = consql.conectar();
            if (stat != null) {
                REGISTROCAMIONES registrocamioneS = new REGISTROCAMIONES(this, true);
                registrocamioneS.id=Integer.parseInt(tblCamiones.getValueAt(tblCamiones.getSelectedRow(), 0).toString());
                registrocamioneS.cargarDatos();
                registrocamioneS.setVisible(true);
                if(registrocamioneS.modif){
                    cargarDatos();
                }
                //                 tblCamiones.getValueAt(tblCamiones.getSelectedRow(), 0).toString();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un camion del catalogo");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                camiones dialog = new camiones(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCamiones;
    // End of variables declaration//GEN-END:variables
    
}
