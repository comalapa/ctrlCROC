/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Conexion.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        btnRegistro = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCamiones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        btnRegistro.setText("Registro");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("Eliga una de las siguientes opciones para los camiones:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnRegistro)
                        .addGap(31, 31, 31)
                        .addComponent(btnModificar)
                        .addGap(43, 43, 43)
                        .addComponent(btnEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistro)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        if(alta != null){
            alta.setVisible(false);
            alta.dispose();
            alta = null;
            System.gc();
        }
        alta = new registroCamiones(this,true);
        alta.btnGuardar.setActionCommand("guardarCamion");
        alta.btnGuardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("guardarCamion")){
                    alta.clickGuardar();
                    cargarDatos();
                }
            }
       
            public void windowClosing(java.awt.event.WindowEvent e) {
                alta.dispose();
            }
        }); 
        alta.setVisible(true);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                camiones dialog = new camiones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCamiones;
    // End of variables declaration//GEN-END:variables
}
