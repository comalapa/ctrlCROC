package clases;

import Conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;

public class pedido extends javax.swing.JDialog {
    
    public boolean agregoOk = false;
    public int id = 0;
    public boolean modificar = false;
    public boolean mod = false;
    private int choferId = 0;
    private int camionId = 0;
    private int materialId = 0;
    private int estatusId = 3;
    
    public boolean cargar = false;
    
    public pedido(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        
        

        
        
        getDatosMateriales();
        getDatosCamion();
        
        if(!cargar)
            this.dispose();
        
    }
    
    
    public void getDatosModificar(){
        modificar=true;
        conexion conectar = new conexion();
        Statement st= conectar.conectar();
        String sql="SELECT a.chofer_id, d.nombre AS nombreChofer, a.camion_id, e.no_control,a.material_id, f.nombre AS nombreMaterial,a.estatus_id, c.nombre AS nombreEstatus, b.estado, b.ciudad,b.colonia,b.direccion,b.contacto,b.telefono,b.celular,b.referencia FROM tb_pedidos a, tb_destino b, tb_estatus c, tb_chofer d, tb_camion e, tb_materiales f WHERE a.id = b.pedido_id AND a.estatus_id = c.id AND a.chofer_id = d.id AND a.camion_id = e.id AND a.material_id = f.id AND a.id="+id;
        ResultSet rs=conectar.ejecutarSQLSelect(sql);
        if(rs!=null){
            try {
                while(rs.next()){
                    txtestado.setText(rs.getString("estado"));
                    txtciudad.setText(rs.getString("ciudad"));
                    txtcolonia.setText(rs.getString("colonia"));
                    txtdireccion.setText(rs.getString("direccion"));
                    txtcontacto.setText(rs.getString("contacto"));
                    txttelefono.setText(rs.getString("telefono"));
                    txtcelular.setText(rs.getString("celular"));
                    txtreferencia.setText(rs.getString("referencia"));
                    
                    cmbcamion.setSelectedItem(rs.getString("no_control"));
                    cmbmaterial.setSelectedItem(rs.getString("nombreMaterial"));
                    
//                    cmbEstatus.setSelectedItem(rs.getString("nombreEstatus"));
                    
                    choferId = Integer.parseInt(rs.getString("chofer_id"));
                    camionId = Integer.parseInt(rs.getString("camion_id"));
                    materialId = Integer.parseInt(rs.getString("material_id"));
//                    
//                    lblEstatus.setVisible(true);
//                    cmbEstatus.setVisible(true);
                    
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
        jLabel2 = new javax.swing.JLabel();
        txtestado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtciudad = new javax.swing.JTextField();
        txtcolonia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcontacto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtchofer = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        cmbmaterial = new javax.swing.JComboBox();
        cmbcamion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btncancelar = new javax.swing.JButton();
        btnaceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Devanagari", 1, 12), java.awt.Color.black), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CIUDAD");

        txtestado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DIRECCIÓN");

        txtciudad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        txtcolonia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("CONTACTO");

        txtdireccion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ESTADO");

        txtcontacto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TELEFONO");

        txttelefono.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("COLONIA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CELULAR");

        txtcelular.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("REFERENCIA");

        txtreferencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(265, 265, 265)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcolonia)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(71, 71, 71))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtestado)
                    .addComponent(txtciudad)
                    .addComponent(txtcolonia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontacto)
                    .addComponent(txttelefono)
                    .addComponent(txtcelular))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtreferencia)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Devanagari", 1, 12), new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CHOFER");

        txtchofer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtchofer.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("CAMION NUMERO");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("MATERIAL");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("PRECIO");

        txtprecio.setEditable(false);
        txtprecio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        cmbmaterial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "selecciones" }));
        cmbmaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmaterialActionPerformed(evt);
            }
        });

        cmbcamion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cmbcamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcamionActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnaceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnaceptar.setText("ACEPTAR");
        btnaceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnaceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btncancelar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptar)
                    .addComponent(btncancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtchofer)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(161, 161, 161)
                                .addComponent(jLabel12)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cmbcamion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtchofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbcamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        String s="";
        if(txtestado.getText().isEmpty()){
            s+="Estado\n";
        }
        if(txtciudad.getText().isEmpty()){
            s+="Ciudad\n";
        }
        if(txtcolonia.getText().isEmpty()){
            s+="Colonia\n";
        }
        if(txtdireccion.getText().isEmpty()){
            s+="Direccion\n";
        }
        if(txtcontacto.getText().isEmpty()){
            s+="Contacto\n";
        }
        if(txttelefono.getText().isEmpty()){
            s+="Telefono\n";
        }
        if(txtcelular.getText().isEmpty()){
            s+="Celular\n";
        }
        if(cmbcamion.getSelectedIndex()==0){
            s+="Camion\n";
        }
        if(cmbmaterial.getSelectedIndex()==0){
            s+="Material\n";
        }
        if(txtprecio.getText().isEmpty()){
            s+="Precio\n";
        }
        if(s.length() > 0){
            JOptionPane.showMessageDialog(this, "Corriga los campos:\n" + s);
        }
        else{
            
            if(!modificar){
                conexion conectar= new conexion();
                Statement st= conectar.conectar();
                if(st != null){                
//                    System.out.println("INSERT INTO tb_pedidos (chofer_id, camion_id,material_id,estatus_id,fecha_creado,fecha_completado,fecha_borrado)VALUES("+choferId+","+camionId+","+materialId+",3,NOW(),null,null);");
                    if(conectar.ejecutarSQL("INSERT INTO tb_pedidos (chofer_id, camion_id,material_id,estatus_id,fecha_creado,fecha_completado,fecha_borrado)VALUES("+choferId+","+camionId+","+materialId+",3,NOW(),null,null);")){
                        ResultSet result = conectar.ejecutarSQLSelect("SELECT id FROM tb_pedidos ORDER BY id DESC LIMIT 1;");
                            int ordenId = 0;
                        try {
                            if(result.next())
                                ordenId = Integer.parseInt(result.getString("id"));
                        } catch (SQLException ex) {
                            Logger.getLogger(pedido.class.getName()).log(Level.SEVERE, null, ex);
                        }
                          if(conectar.ejecutarSQL("INSERT INTO tb_destino (estado,ciudad,colonia,direccion,contacto,telefono,celular,referencia,pedido_id)VALUES('"+txtestado.getText()+"','"+txtciudad.getText()+"','"+txtcolonia.getText()+"','"+txtdireccion.getText()+"','"+txtcontacto.getText()+"','"+txttelefono.getText()+"','"+txtcelular.getText()+"','"+txtreferencia.getText()+"',"+ordenId+");")){ 
                                agregoOk = true;
                                JOptionPane.showMessageDialog(null, "Pedido registrado...");
                                this.dispose();
                          }else{
                              JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta");
                              agregoOk = false;
                          }
                          
                          if(conectar.ejecutarSQL("DELETE FROM tb_cola WHERE chofer_id="+choferId)){
                               conectar.ejecutarSQL("UPDATE tb_camion SET estatus_id=6 WHERE id = "+camionId);
                          }
                          else{
                              JOptionPane.showMessageDialog(null, "No se pudo dar de baja al chofer de la cola");
                          }
                    }
                    else{
                        agregoOk = false;
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta");
                    }
                }
                else{
                    agregoOk = false;
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la conexion");
                }
            }else{
                conexion conectar= new conexion();
                Statement st= conectar.conectar();
                if(st != null){                
                    if(conectar.ejecutarSQL("UPDATE tb_pedidos SET chofer_id="+choferId+", camion_id="+camionId+",material_id="+materialId+" WHERE id = "+id+";")){
                          if(conectar.ejecutarSQL("UPDATE tb_destino SET estado='"+txtestado.getText()+"',ciudad='"+txtciudad.getText()+"',colonia='"+txtcolonia.getText()+"',direccion='"+txtdireccion.getText()+"',contacto='"+txtcontacto.getText()+"',telefono='"+txttelefono.getText()+"',celular='"+txtcelular.getText()+"',referencia='"+txtreferencia.getText()+"' WHERE pedido_id = "+id+";")){ 
                                mod = true;
                                JOptionPane.showMessageDialog(null, "Pedido Actualizado...");
                                this.dispose();
                          }else{
                              JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta");
                              mod = false;
                          }
                    }
                    else{
                        mod = false;
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta");
                    }
                }
                else{
                    mod = false;
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la conexion");
                }
            }
        }
        
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void cmbmaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmaterialActionPerformed
        conexion consql = new conexion();
        Statement stat = consql.conectar();
        
        if(stat!=null){
           ResultSet result = consql.ejecutarSQLSelect("SELECT * FROM tb_materiales WHERE nombre = '"+cmbmaterial.getSelectedItem()+"';");
            try {
                if(result.next()){
                    txtprecio.setText(result.getString("precio"));
                    materialId = Integer.parseInt(result.getString("id"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(registroChoferes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmbmaterialActionPerformed

    private void cmbcamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcamionActionPerformed
        if(cmbcamion.getItemCount() > 0)
            camionId = getIdCamion(cmbcamion.getSelectedItem().toString());
    }//GEN-LAST:event_cmbcamionActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                pedido dialog = new pedido(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox cmbcamion;
    private javax.swing.JComboBox cmbmaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtchofer;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtcolonia;
    private javax.swing.JTextField txtcontacto;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtreferencia;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    private void getDatosCamion(){
        conexion consql = new conexion();
        Statement stat = consql.conectar();
        
        if(stat!=null){
           ResultSet result = consql.ejecutarSQLSelect("SELECT no_control FROM tb_camion WHERE estatus_id <> 6");
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
    
    private void getDatosMateriales(){
        conexion consql = new conexion();
        Statement stat = consql.conectar();
        
        if(stat!=null){
           ResultSet result = consql.ejecutarSQLSelect("SELECT nombre FROM tb_materiales");
           cmbmaterial.removeAllItems(); 
           cmbmaterial.addItem("Seleccione...");
            try {
                while(result.next()){
                    cmbmaterial.addItem(result.getString("nombre"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(registroChoferes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    public void cargarDatos() {
        conexion conectar=new conexion();
        Statement st= conectar.conectar();
        if(st != null){
            ResultSet rs = conectar.ejecutarSQLSelect("SELECT * FROM tb_cola a ORDER BY id ASC LIMIT 1;");
            try {
                if(rs.next()){
                    choferId = rs.getInt("chofer_id");
                    txtchofer.setText(rs.getString("nombre"));
                    cmbcamion.setSelectedItem(rs.getString("camion_control"));
                    camionId = getIdCamion(rs.getString("camion_control"));
                    cargar = true;
                    
                }else{
                    JOptionPane.showMessageDialog(null, "NO hay choferes en espera, intentelo mas tarde");
                    cargar = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pudo realizar la conexion");
        }
        
    }
    
    private int getIdCamion(String control){
        conexion consql = new conexion();
        Statement stat = consql.conectar();
        int id=0;
        if(stat!=null){
           ResultSet result = consql.ejecutarSQLSelect("SELECT id FROM tb_camion WHERE no_control = '"+control+"'");
            try {
                if(result.next()){
                    id= Integer.parseInt(result.getString("id"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(registroChoferes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
}
