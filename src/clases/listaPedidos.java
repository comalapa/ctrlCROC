/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Garcia
 */
public class listaPedidos extends javax.swing.JDialog {

    
    private String[] titulos = new String[]{ "Id", "Chofer", "Camion", "Material","Estado", "Ciudad", "Colonia", "Direccion", "Contacto", "Telefono", "Celular", "Estatus",""};
    public DefaultTableModel model=new DefaultTableModel(titulos,0);
    
    public listaPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Pedidos");
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);        
        getDataPedidos();        
    }

    public void getModel(){
        tblPedidos.setModel(model);
        tblPedidos.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblPedidos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblPedidos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblPedidos.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblPedidos.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblPedidos.getColumnModel().getColumn(5).setPreferredWidth(80);
        tblPedidos.getColumnModel().getColumn(6).setPreferredWidth(80);
        tblPedidos.getColumnModel().getColumn(7).setPreferredWidth(120);
        tblPedidos.getColumnModel().getColumn(8).setPreferredWidth(120);
        tblPedidos.getColumnModel().getColumn(9).setPreferredWidth(50);
        tblPedidos.getColumnModel().getColumn(10).setPreferredWidth(80);
        tblPedidos.getColumnModel().getColumn(11).setPreferredWidth(80);
        tblPedidos.getColumnModel().getColumn(12).setPreferredWidth(10);
        
    }
    
    private void deleteRowModelTable(){
        // Limpiamos el Modelo de la Tabla
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
    }
        
        private void getDataPedidos(){
        getModel();
        deleteRowModelTable();
        conexion consql = new conexion();
        Statement stat = consql.conectar();
        
        if(stat!=null){
            System.out.println("SELECT a.id,a.chofer_id, d.nombre AS nombreChofer, a.camion_id, e.no_control,a.material_id, f.nombre AS nombreMaterial,a.estatus_id, c.nombre AS nombreEstatus, b.estado, b.ciudad,b.colonia,b.direccion,b.contacto,b.telefono,b.celular FROM tb_pedidos a, tb_destino b, tb_estatus c, tb_chofer d, tb_camion e, tb_materiales f WHERE a.id = b.pedido_id AND a.estatus_id = c.id AND a.chofer_id = d.id AND a.camion_id = e.id AND a.material_id = f.id and a.estatus_id != 4;");
           ResultSet result = consql.ejecutarSQLSelect("SELECT DISTINCT a.id,a.chofer_id, d.nombre AS nombreChofer, a.camion_id, e.no_control,a.material_id, f.nombre AS nombreMaterial,a.estatus_id, c.nombre AS nombreEstatus, b.estado, b.ciudad,b.colonia,b.direccion,b.contacto,b.telefono,b.celular FROM tb_pedidos a, tb_destino b, tb_estatus c, tb_chofer d, tb_camion e, tb_materiales f WHERE a.id = b.pedido_id AND a.estatus_id = c.id AND a.chofer_id = d.id AND a.camion_id = e.id AND a.material_id = f.id and a.estatus_id != 4;");
            try {
                while(result.next()){
                    model.addRow(new Object[]{result.getInt("id"),result.getString("nombreChofer"),result.getString("no_control"),result.getString("nombreMaterial"),result.getString("estado"),result.getString("ciudad"),result.getString("colonia"),result.getString("direccion"),result.getString("contacto"),result.getString("telefono"),result.getString("celular"),result.getString("nombreEstatus"),""});
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Seleccione una opcion para los pedidos");

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Chofer", "Camion", "Material", "Estado", "Ciudad", "Colonia", "Direccion", "Contacto", "Telefono", "Celular", "Estado"
            }
        ));
        tblPedidos.setToolTipText("");
        jScrollPane1.setViewportView(tblPedidos);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/application_add.png"))); // NOI18N
        btnNuevo.setText("Nueva Orden");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/application_edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/note_edit.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(31, 31, 31)
                        .addComponent(btnActualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnActualizar))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        pedido nuevoPedido = new pedido(this,true);
        nuevoPedido.cargarDatos();
        if(nuevoPedido.cargar)
            nuevoPedido.setVisible(true);
        if(nuevoPedido.agregoOk)
              getDataPedidos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tblPedidos.getSelectedRow() != -1) {
                pedido modPedido = new pedido(this,true);
                modPedido.modificar = true;
                modPedido.id = Integer.parseInt(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0).toString());
                modPedido.getDatosModificar();
                modPedido.setVisible(true);
                
                if(modPedido.mod){
                    getDataPedidos();
                }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un camion del catalogo");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(tblPedidos.getSelectedRow() != -1){
            conexion conectar = new conexion();
            Statement st = conectar.conectar();
            int pedidoId = Integer.parseInt(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0).toString());
            int choferId = 0;
            String choferNombre = "";
            String controlCamion = "";
            String estado = tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 11).toString();
            
            ResultSet rs = conectar.ejecutarSQLSelect("SELECT a.chofer_id, b.no_control, c.nombre FROM tb_pedidos a, tb_camion b, tb_chofer c WHERE a.camion_id = b.id AND a.chofer_id = c.id AND a.id ="+pedidoId+";");
            try {
                if(rs.next()){
                    choferId = rs.getInt("chofer_id");
                    choferNombre = rs.getString("nombre");
                    controlCamion = rs.getString("no_control");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(listaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(estado.equals("Asignado")){
                if(JOptionPane.YES_NO_OPTION == JOptionPane.showConfirmDialog(null,"Esta a punto enviar del pedido\n¿Desea continuar?","Alerta",JOptionPane.YES_NO_OPTION)){                    
                    System.out.println("UPDATE tb_pedidos SET estatus_id = 5 WHERE id="+pedidoId);
                    conectar.ejecutarSQL("UPDATE tb_pedidos SET estatus_id = 5 WHERE id="+pedidoId);
                    getDataPedidos();
                    imprimir(pedidoId);
                    
                }
            }
            else if(estado.equals("En ruta")){
                if(JOptionPane.YES_NO_OPTION == JOptionPane.showConfirmDialog(null,"Confirmar entrega\n¿Desea continuar?","Alerta",JOptionPane.YES_NO_OPTION)){
                    int camionId = 0;
                    try {
                        ResultSet result = conectar.ejecutarSQLSelect("SELECT camion_id FROM tb_pedidos WHERE id="+pedidoId);
                        
                        if(result.next()){
                            camionId = result.getInt("camion_id");
                        }
                        
                        
                        
                        conectar.ejecutarSQL("UPDATE tb_pedidos SET estatus_id = 4, fecha_completado= NOW() WHERE id="+pedidoId);
                        conectar.ejecutarSQL("UPDATE tb_camion SET estatus_id = 1 WHERE id = "+camionId+";");
                        conectar.ejecutarSQL("INSERT INTO tb_cola (chofer_id,nombre,camion_control)VALUES("+choferId+",'"+choferNombre+"','"+controlCamion+"');");
                        
                        
                        getDataPedidos();
                    } catch (SQLException ex) {
                        Logger.getLogger(listaPedidos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un camion del catalogo");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed
    private void imprimir(int id_pedido){
        imprimirPedido imprimir= new imprimirPedido();
        imprimir.imprimirPedido(id_pedido);
    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                listaPedidos dialog = new listaPedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables
   
}
