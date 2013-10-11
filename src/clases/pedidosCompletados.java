
package clases;

import Conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    

public class pedidosCompletados extends javax.swing.JDialog {
    
    private String[] titulos = new String[]{ "id", "Chofer", "Material", "Destino"};
    public DefaultTableModel model=new DefaultTableModel(titulos,0);
    
    public pedidosCompletados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        
        
        cargarFechas();
        cargarChoferes();
        getPedidos();
        cmbChofer.setSelectedIndex(0);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jdHasta = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbChofer = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jdDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdDesdePropertyChange(evt);
            }
        });

        jLabel1.setText("DESDE");

        jdHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdHastaPropertyChange(evt);
            }
        });

        jLabel2.setText("HASTA");

        jLabel3.setText("Chofer");

        cmbChofer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        cmbChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbChoferActionPerformed(evt);
            }
        });
        cmbChofer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbChoferPropertyChange(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Chofer", "Material", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPedidos);
        tblPedidos.getColumnModel().getColumn(0).setResizable(false);
        tblPedidos.getColumnModel().getColumn(1).setResizable(false);
        tblPedidos.getColumnModel().getColumn(2).setResizable(false);
        tblPedidos.getColumnModel().getColumn(3).setResizable(false);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jdDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jdHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdDesdePropertyChange
        
    }//GEN-LAST:event_jdDesdePropertyChange

    private void cmbChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbChoferActionPerformed
        getPedidos();
    }//GEN-LAST:event_cmbChoferActionPerformed

    private void cmbChoferPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbChoferPropertyChange
        
    }//GEN-LAST:event_cmbChoferPropertyChange

    private void jdHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdHastaPropertyChange
       
    }//GEN-LAST:event_jdHastaPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getPedidos();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pedidosCompletados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pedidosCompletados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pedidosCompletados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pedidosCompletados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pedidosCompletados dialog = new pedidosCompletados(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cmbChofer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdDesde;
    private com.toedter.calendar.JDateChooser jdHasta;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables
    
    private void cargarFechas(){
        Date Hoy = new Date();
        DateFormat df = DateFormat.getDateInstance();
               
        jdDesde.setDate(Hoy);
        jdHasta.setDate(Hoy);
    }
    
    private void cargarChoferes(){
        conexion conectar = new conexion();
        Statement st =conectar.conectar();
        
        cmbChofer.removeAllItems();
        cmbChofer.addItem("Todos");
        
        ResultSet rs = conectar.ejecutarSQLSelect("SELECT nombre FROM tb_chofer WHERE estatus_id = 1");
        
        try {
            while(rs.next()){
            
                cmbChofer.addItem(rs.getString("nombre"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(pedidosCompletados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getModel(){
        tblPedidos.setModel(model);
        tblPedidos.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblPedidos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblPedidos.getColumnModel().getColumn(2).setPreferredWidth(350);
        tblPedidos.getColumnModel().getColumn(3).setPreferredWidth(100);
        
    }
    
    private void deleteRowModelTable(){
        // Limpiamos el Modelo de la Tabla
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    
    private void getPedidos() {
        getModel();
        deleteRowModelTable();
        String cadena = "";
        conexion conectar = new conexion();
        Statement st =conectar.conectar();
        ResultSet rs = null;
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String inicio = df.format(jdDesde.getDate()) + " 00:00:00";
        String fin = df.format(jdHasta.getDate()) + " 12:59:59";
        
        if(cmbChofer.getSelectedIndex() > 0){
            
            
                
                 rs = conectar.ejecutarSQLSelect("SELECT id FROM tb_chofer WHERE nombre = '"+ cmbChofer.getSelectedItem().toString()+"';");
                try {
                    if(rs.next()){
                        cadena = " AND a.chofer_id = " + rs.getInt("id");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(pedidosCompletados.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        }
        rs = conectar.ejecutarSQLSelect("SELECT DISTINCT a.id,b.nombre,b.apellido_p,b.apellido_m,c.direccion,c.colonia,c.ciudad,d.nombre AS nombreM, a.fecha_completado FROM tb_pedidos a, tb_chofer b, tb_destino c, tb_materiales d WHERE a.chofer_id = b.id AND a.estatus_id = 4 AND c.pedido_id = a.id AND a.material_id = d.id AND DATE(a.fecha_completado) BETWEEN '"+inicio+"' AND '"+fin+"'"+cadena+";");
        try {
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("id"),rs.getString("nombre")+" "+rs.getString("apellido_p")+" "+rs.getString("apellido_m"),rs.getString("direccion")+" "+rs.getString("ciudad"),rs.getString("nombreM")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(pedidosCompletados.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }
        
        
            
