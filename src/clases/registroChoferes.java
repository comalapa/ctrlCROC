/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Conexion.conexion;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Garcia
 */
public class registroChoferes extends javax.swing.JDialog {

    /**
     * Creates new form registroChoferes
     */
    public registroChoferes(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Alta de Choferes");
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        
        getDatos();
    }

    private void getDatos(){
        conexion consql = new conexion();
        Statement stat = consql.conectar();
        
        if(stat!=null){
           ResultSet result = consql.ejecutarSQLSelect("SELECT * FROM tb_camion WHERE estatus_id = 1");
           cmbcamion.removeAllItems();
           cmbcamion.addItem("Seleccione...");
            try {
                while(result.next()){
                    cmbcamion.addItem(result.getString("no_control"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(registroChoferes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    public void getDatosModificar(){
        modificar=true;
        conexion conectar = new conexion();
        Statement st= conectar.conectar();
        String sql="SELECT a.id,a.codigo,a.nombre,a.apellido_p,a.apellido_m,a.direccion,a.estado,a.ciudad,a.cp,a.telefono,a.no_ife,a.no_licencia,a.estatus_id,b.nombre AS estatus, c.id, c.no_control FROM tb_chofer a, tb_estatus b,tb_camion c WHERE a.estatus_id = b.id AND a.camion_id=c.id AND a.id="+id;
        ResultSet rs=conectar.ejecutarSQLSelect(sql);
        if(rs!=null){
            try {
                while(rs.next()){
                    txtcodigo.setText(rs.getString("codigo"));
                    txtnombre.setText(rs.getString("nombre"));
                    txtapellido_p.setText(rs.getString("apellido_p"));
                    txtapellido_m.setText(rs.getString("apellido_m"));
                    txtdireccion.setText(rs.getString("direccion"));
                    txtestado.setText(rs.getString("estado"));
                    txtciudad.setText(rs.getString("ciudad"));
                    txtcp.setText(rs.getString("cp"));
                    txttelefono.setText(rs.getString("telefono"));
                    txtife.setText(rs.getString("no_ife"));
                    txtlicencia.setText(rs.getString("no_licencia"));
                    
                    cmbcamion.setSelectedItem(rs.getString("no_control"));
                    
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al consultar");
        }  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtife = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtlicencia = new javax.swing.JTextField();
        txtguardar = new javax.swing.JButton();
        txtcancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbcamion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtapellido_p = new javax.swing.JTextField();
        txtapellido_m = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtestado = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtciudad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtcp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Telefono");

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel2.setText("No. IFE");

        txtife.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtifeKeyTyped(evt);
            }
        });

        jLabel3.setText("No. Licencia de Conducir");

        txtlicencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlicenciaKeyTyped(evt);
            }
        });

        txtguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        txtguardar.setText("Guardar");
        txtguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtguardarActionPerformed(evt);
            }
        });

        txtcancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        txtcancelar.setText("Cancelar");
        txtcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Camion");

        cmbcamion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbcamion, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(txtguardar)
                .addGap(18, 18, 18)
                .addComponent(txtcancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtife, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtlicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbcamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtguardar)
                    .addComponent(txtcancelar))
                .addGap(119, 119, 119))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtife, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtlicencia, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addGap(296, 296, 296)))
        );

        jLabel9.setText("Codigo");

        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        jLabel10.setText("Nombre");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jLabel11.setText("Apellido Paterno");

        txtapellido_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellido_pKeyTyped(evt);
            }
        });

        txtapellido_m.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellido_mKeyTyped(evt);
            }
        });

        jLabel12.setText("Apellido Materno");

        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        jLabel13.setText("Direccion");

        jLabel14.setText("Estado");

        txtestado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtestadoKeyTyped(evt);
            }
        });

        jLabel15.setText("Ciudad");

        txtciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtciudadKeyTyped(evt);
            }
        });

        jLabel16.setText("C.P.");

        txtcp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcpKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtcp, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtapellido_p, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtapellido_m, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtestado, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtciudad, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcp, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtapellido_p, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtapellido_m, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addGap(242, 242, 242)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtguardarActionPerformed
        String campo = "";
        boolean error = false;
        if(txtcodigo.getText().isEmpty()){
            campo+="Codigo";
            error = true;
        }
        if(txtnombre.getText().isEmpty()){
            campo+="\nNombre";
            error = true;
        }
        if(txtapellido_p.getText().isEmpty()){
            campo+="\nApellido Paterno";
            error = true;
        }
        if(txtapellido_m.getText().isEmpty()){
            campo+="\nApellido Materno";
            error = true;
        }
        if(txtdireccion.getText().isEmpty()){
            campo+="\nDireccion";
            error = true;
        }
        if(txtestado.getText().isEmpty()){
            campo+="\nEstado";
            error = true;
        }
        if(txtciudad.getText().isEmpty()){
            campo+="\nCiudad";
            error = true;
        }
        if(txtcp.getText().isEmpty()){
            campo+="\nCodigo Postal";
            error = true;
        }
        if(txttelefono.getText().isEmpty()){
            campo+="\nTelefono";
            error = true;
        }
        if(txtife.getText().isEmpty()){
            campo+="\nNumero de IFE";
            error = true;
        }
        if(txtlicencia.getText().isEmpty()){
            campo+="\nNumero de Licencia";
            error = true;
        }
        if(cmbcamion.getSelectedIndex() == 0){
            campo+="\nCamion";
            error = true;
        }
        if(!error){
            if(modificar){
                try {
                    conexion consql = new conexion();
                    Statement stat = consql.conectar();
                        
                        ResultSet result = consql.ejecutarSQLSelect("SELECT id FROM tb_camion WHERE no_control = "+cmbcamion.getSelectedItem().toString()+";");
                        System.out.println("SELECT id FROM tb_camion WHERE no_control = "+cmbcamion.getSelectedItem().toString()+";");
                        
                        int idCamion=0;
                        if(result.next())
                            idCamion = result.getInt("id");
                    
                    if (stat != null) {
                        if (consql.ejecutarSQL("UPDATE tb_chofer SET nombre = '"+txtnombre.getText()+"',apellido_p='"+txtapellido_p.getText()+"',apellido_m='"+txtapellido_m.getText()+"',direccion='"+txtdireccion.getText()+"',ciudad ='"+txtciudad.getText()+"',estado='"+txtestado.getText()+"',cp='"+txtcp.getText()+"',telefono='"+txttelefono.getText()+"',no_ife = '"+txtife.getText()+"',no_licencia='"+txtlicencia.getText()+"' WHERE camion_id="+idCamion+";")) {
                            
                            JOptionPane.showMessageDialog(this, "Ok se modifico");
                            //                System.out.println("inserto");
                            modif = true;
                            this.dispose();

                        } else {
                            JOptionPane.showMessageDialog(this, "Error");
                            modif = false;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al realizar la conexion");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(registroChoferes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    conexion consql = new conexion();
                    Statement stat = consql.conectar();
                        
                        ResultSet result = consql.ejecutarSQLSelect("SELECT id FROM tb_camion WHERE no_control = "+cmbcamion.getSelectedItem().toString()+";");
                        System.out.println("SELECT id FROM tb_camion WHERE no_control = "+cmbcamion.getSelectedItem().toString()+";");
                        
                        int idCamion=0;
                        if(result.next())
                            idCamion = result.getInt("id");
                    
                    if (stat != null) {
                        if (consql.ejecutarSQL("INSERT INTO tb_chofer (codigo,nombre,apellido_p,apellido_m,direccion,ciudad,estado,cp,telefono,no_ife,no_licencia,fecha_creacion,fecha_borrado,estatus_id,camion_id)"
                                + "VALUES('" + txtcodigo.getText() + "','" + txtnombre.getText() + "','" + txtapellido_p.getText() + "','" + txtapellido_m.getText() + "','" + txtdireccion.getText() + "','" + txtciudad.getText() + "','" + txtestado.getText() + "','" + txtcp.getText() + "','" + txttelefono.getText() + "','" + txtife.getText() + "','" + txtlicencia.getText() + "',NOW(),null,1,"+idCamion+");")) {
                            
                            JOptionPane.showMessageDialog(this, "Ok se inserto");
                            //                System.out.println("inserto");
                            registrook = true;
                            this.dispose();

                        } else {
                            JOptionPane.showMessageDialog(this, "Error");
                            registrook = false;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al realizar la conexion");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(registroChoferes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Corriga los campos:\n" + campo);
        }
    }//GEN-LAST:event_txtguardarActionPerformed

    private void txtcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_txtcancelarActionPerformed

    private void txtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoKeyPressed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        char caracter = evt.getKeyChar();
        if(txtcodigo.getText().length()>14){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
        if((caracter < '0' || caracter > '9') && caracter != KeyEvent.VK_BACK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && car!=KeyEvent.VK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellido_pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellido_pKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && car!=KeyEvent.VK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtapellido_pKeyTyped

    private void txtapellido_mKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellido_mKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && car!=KeyEvent.VK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtapellido_mKeyTyped

    private void txtestadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtestadoKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && car!=KeyEvent.VK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtestadoKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped

        if(txtdireccion.getText().length()>44){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtciudadKeyTyped
        if(txtciudad.getText().length()>44){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtciudadKeyTyped

    private void txtcpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyTyped
        char caracter = evt.getKeyChar();
        if(txtcp.getText().length()>4){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
        if((caracter < '0' || caracter > '9') && caracter != KeyEvent.VK_BACK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcpKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char caracter = evt.getKeyChar();
        if(txttelefono.getText().length()>9){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
        if((caracter < '0' || caracter > '9') && caracter != KeyEvent.VK_BACK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtifeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtifeKeyTyped
        char caracter = evt.getKeyChar();
        if(txtife.getText().length()>14){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
        if((caracter < '0' || caracter > '9') && caracter != KeyEvent.VK_BACK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtifeKeyTyped

    private void txtlicenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlicenciaKeyTyped
        char car = evt.getKeyChar();
        if(txtlicencia.getText().length()>14){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
        if((car < '0' || car > '9') && (car<'A' || car>'Z') && car!=KeyEvent.VK_SPACE){
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtlicenciaKeyTyped

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
            java.util.logging.Logger.getLogger(registroChoferes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroChoferes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroChoferes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroChoferes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                registroChoferes dialog = new registroChoferes(new javax.swing.JDialog(), true);
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
    private javax.swing.JComboBox cmbcamion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtapellido_m;
    private javax.swing.JTextField txtapellido_p;
    private javax.swing.JButton txtcancelar;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtestado;
    private javax.swing.JButton txtguardar;
    private javax.swing.JTextField txtife;
    private javax.swing.JTextField txtlicencia;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
    public boolean registrook, modificar=false, modif;
    public int id;
}

