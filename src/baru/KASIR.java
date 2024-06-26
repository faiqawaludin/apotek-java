/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package baru;

import java.awt.PageAttributes;
import java.sql.*;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author abet
 */
public class KASIR extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN
     */
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in","ID"));
    public Statement st;
    public ResultSet rs;
    Connection cn = Koneksi.koneksi_database.BukaKoneksi();
    
    public KASIR() {
        initComponents();
        Total();
        
    }
    
    private void Total(){
    txtQTY.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    
        @Override
        public void insertUpdate(DocumentEvent Arg0) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try{
    int hasil = 0;
    if(txtQTY.getText().equals("")){
    hasil = Integer.parseInt(txtHARGAOBAT.getText().replace(".", ""))* 0;
    }else{
    hasil = Integer.parseInt(txtHARGAOBAT.getText().replace(".", ""))* 
            Integer.parseInt(txtQTY.getText());
    }
    txtTOTALHARGA.setText(nf.format(hasil));
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,e );
    }
    }
        

        @Override
        public void removeUpdate(DocumentEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    });
    }
    
    private void TampilData(){
    try {
        String sql = "SELECT * FROM dataobat WHERE ID = '" + txtIDOBAT.getText() + "'";
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        if(rs.next()){}
        txtNAMAOBAT.setText(rs.getString("NAMA"));
        txtHARGAOBAT.setText(rs.getString("HARGA"));
        lblTAMPILSTOCK.setText(rs.getString("STOCK"));
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e );
    }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtMENUUTAMA = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCLEAR = new javax.swing.JButton();
        txtTAMBAH = new javax.swing.JButton();
        txtSAVE = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtNAMAOBAT = new javax.swing.JTextField();
        txtQTY = new javax.swing.JTextField();
        txtTOTALHARGA = new javax.swing.JTextField();
        lblJUMLAHHARGA = new javax.swing.JLabel();
        txtHARGAOBAT = new javax.swing.JTextField();
        txtIDOBAT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblJMLQTY = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLIST = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTAMPILSTOCK = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 440));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 148, 68));
        jLabel3.setText("ID OBAT");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 148, 68));
        jLabel4.setText("NAMA OBAT");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 148, 68));
        jLabel5.setText("HARGA OBAT");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 148, 68));
        jLabel6.setText("QTY");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 148, 68));
        jLabel8.setText("TOTAL HARGA");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 148, 68));
        jLabel10.setText("JUMLAH");

        jPanel2.setBackground(new java.awt.Color(0, 148, 68));

        txtMENUUTAMA.setText("MENU UTAMA");
        txtMENUUTAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMENUUTAMAActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("KASIR");

        txtCLEAR.setText("BERSIHKAN");
        txtCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCLEARActionPerformed(evt);
            }
        });

        txtTAMBAH.setText("TAMBAH");
        txtTAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTAMBAHActionPerformed(evt);
            }
        });

        txtSAVE.setText("SIMPAN");
        txtSAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSAVEActionPerformed(evt);
            }
        });

        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMENUUTAMA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtCLEAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTAMBAH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSAVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtTAMBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(txtMENUUTAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        lblJUMLAHHARGA.setBackground(new java.awt.Color(255, 153, 153));
        lblJUMLAHHARGA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJUMLAHHARGA.setText("Rp.");
        lblJUMLAHHARGA.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtHARGAOBAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHARGAOBATActionPerformed(evt);
            }
        });

        txtIDOBAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDOBATKeyPressed(evt);
            }
        });

        jLabel11.setText("Jumlah Item :");

        lblJMLQTY.setText("0");

        tblLIST.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kode Obat", "Nama Obat", "Harga", "QTY", "Total"
            }
        ));
        jScrollPane2.setViewportView(tblLIST);

        jLabel7.setText("Sisa Stock :");

        lblTAMPILSTOCK.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(txtNAMAOBAT, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(txtIDOBAT))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJMLQTY)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTAMPILSTOCK))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(txtQTY, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(txtHARGAOBAT))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(lblJUMLAHHARGA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTOTALHARGA, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblJUMLAHHARGA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHARGAOBAT)
                            .addComponent(txtIDOBAT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNAMAOBAT, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(txtQTY)
                            .addComponent(txtTOTALHARGA, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblJMLQTY)
                            .addComponent(jLabel7)
                            .addComponent(lblTAMPILSTOCK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 440));

        setSize(new java.awt.Dimension(932, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMENUUTAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMENUUTAMAActionPerformed
        new MENUUTAMA().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtMENUUTAMAActionPerformed

    private void txtHARGAOBATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHARGAOBATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHARGAOBATActionPerformed

    private void txtIDOBATKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDOBATKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10 && txtIDOBAT.getText().equalsIgnoreCase("")== false){
            TampilData();
        }else{ }
    }//GEN-LAST:event_txtIDOBATKeyPressed

    private void txtTAMBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTAMBAHActionPerformed
        // TODO add your handling code here:

            DefaultTableModel model = (DefaultTableModel) tblLIST.getModel();
            Object obj[] = new Object[6];
            obj [1] = txtIDOBAT.getText();
            obj [2] = txtNAMAOBAT.getText();
            obj [3] = txtHARGAOBAT.getText();
            obj [4] = txtQTY.getText();
            obj [5] = txtTOTALHARGA.getText();
                    
            model.addRow(obj);
            int baris = model.getRowCount();
            for(int a = 0; a < baris ; a++){
            String no = String.valueOf(a + 1);
            model.setValueAt(no + ".", a,0);
            }
            tblLIST.setRowHeight(30);
            lblJMLQTY.setText(String.valueOf(baris));
            jmlTOTALHARGA();
            bersih();
            
                    
    }//GEN-LAST:event_txtTAMBAHActionPerformed

    private void txtSAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSAVEActionPerformed
        // TODO add your handling code here :
            DefaultTableModel model = (DefaultTableModel) tblLIST.getModel();
            String sql = "INSERT INTO datapenjualan (ID,NAMA,HARGA,JUMLAH,TOTAL) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = cn.prepareStatement(sql)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    pstmt.setInt(1, Integer.parseInt(model.getValueAt(i, 1).toString()));
                    pstmt.setString(2, model.getValueAt(i, 2).toString());
                    pstmt.setInt(3, Integer.parseInt(model.getValueAt(i, 3).toString().replace(".", "")));
                    pstmt.setInt(4, Integer.parseInt(model.getValueAt(i, 4).toString()));
                    pstmt.setInt(5, Integer.parseInt(model.getValueAt(i, 5).toString().replace(".", "")));
                    pstmt.addBatch();
                }
                int[] rowsInserted = pstmt.executeBatch();
                System.out.println("Data Inserted: " + rowsInserted.length + " rows.");
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
    }//GEN-LAST:event_txtSAVEActionPerformed

    private void txtCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCLEARActionPerformed
        // TODO add your handling code here:
        tblLIST.setModel(new DefaultTableModel(null,new String []{"N0","Kode Obat","Nama Obat","Harga","QTY","Total Harga"}));  
lblJUMLAHHARGA.setText("Rp.");
    }//GEN-LAST:event_txtCLEARActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("STRUK TRANSAKSI");
        MessageFormat footer = new MessageFormat("APOTIK PHARMACY OF UNSIKA");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.PORTRAIT);
            tblLIST.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(null,"\n" + "Print Successfull");
            
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null,"\n" + "failed");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KASIR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblJMLQTY;
    private javax.swing.JLabel lblJUMLAHHARGA;
    private javax.swing.JLabel lblTAMPILSTOCK;
    private javax.swing.JTable tblLIST;
    private javax.swing.JButton txtCLEAR;
    private javax.swing.JTextField txtHARGAOBAT;
    private javax.swing.JTextField txtIDOBAT;
    private javax.swing.JButton txtMENUUTAMA;
    private javax.swing.JTextField txtNAMAOBAT;
    private javax.swing.JTextField txtQTY;
    private javax.swing.JButton txtSAVE;
    private javax.swing.JButton txtTAMBAH;
    private javax.swing.JTextField txtTOTALHARGA;
    // End of variables declaration//GEN-END:variables
    private void jmlTOTALHARGA() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        try {
            int subtotal = 0;
        for (int a = 0; a < tblLIST.getRowCount();a++){
        subtotal += Integer.parseInt((String) 
                tblLIST.getValueAt(a,5).toString().replace(".",""));
        }
    
    int total_bersih = subtotal;
    lblJUMLAHHARGA.setText("Rp. " + nf.format(total_bersih));
    
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,e );
        }

    
    }

    private void bersih() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    txtIDOBAT.setText("");
    txtIDOBAT.grabFocus();
    txtNAMAOBAT.setText("");
    txtHARGAOBAT.setText("");
    txtQTY.setText("");
    txtTOTALHARGA.setText("");
    lblJMLQTY.setText("");
    lblTAMPILSTOCK.setText("");
    }
}
