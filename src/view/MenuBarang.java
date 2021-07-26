/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Faa
 */
public class MenuBarang extends javax.swing.JFrame {
public Connection con;
public Statement sttm;
public ResultSet rs;
public DefaultTableModel model;
public String txt_idbarang, txt_namabarang, txt_harga;

public String getTxt_idbarang (){
    return txt_idbarang;
}
public String getTxt_namabarang (){
    return txt_namabarang;
    
}public String getTxt_harga (){
    return txt_harga;
}
    /**
     * Creates new form MenuBarang
     */
    public MenuBarang() {
        initComponents();
        
        //Meletakkan frame di tengah layar
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
       
        int x = d.width/2 - this.getSize().width/2;
        int y = d.height/2 - this.getSize().height/2;
        
        this.setLocation(x, y); 
        
        //Memberi Nama pada Tabel
        String[] header = {"ID","Nama Barang","Harga/Item","Jumlah Stock"};
        model = new DefaultTableModel(header,0);
        table_barang1.setModel(model);
        tampilData();    
    }
    
    public void tampilData(){
        koneksi koneksi = new koneksi();
        int jumlahrow = table_barang1.getRowCount();
        for (int n=0;n<jumlahrow;n++){
            model.removeRow(0);
        }
        String cari = txt_search.getText();
        try{
            con = koneksi.getKoneksi();
            sttm = con.createStatement();
            rs = sttm.executeQuery("SELECT * FROM data_barang WHERE `id_barang` LIKE '%"+cari+"%' OR `nama_barang` LIKE '%"+cari+"%'");
            while(rs.next()){
                String[] row ={rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)};
                model.addRow(row);
                
            }
            table_barang1.setModel(model);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void cari (){
        int row = table_barang1.getRowCount();
        for(int a = 0 ; a < row ; a++){
            model.removeRow(0);
        }
        
        
        String cari = txt_search.getText();
        
        String query = "SELECT * FROM `data_barang` WHERE `id_barang`  LIKE '%"+cari+"%' OR `nama_barang` LIKE '%"+cari+"%' ";
                
       try{
           Connection con = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = con.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                   
                    String id = rslt.getString("id_barang");
                    String nama = rslt.getString("nama_barang");
                    String stok = rslt.getString("stok");
                    String harga = rslt.getString("harga");
                    
                   
                    
                //masukan semua data kedalam array
                String[] data = {id,nama,stok,harga};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                model.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                table_barang1.setModel(model);
           
        
    }catch(Exception e){
           System.out.println(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_barang1 = new javax.swing.JTable();
        kembali = new javax.swing.JLabel();
        refresh = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_barang1.setModel(new javax.swing.table.DefaultTableModel(
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
        table_barang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barang1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_barang1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 660, 240));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button kembali.png"))); // NOI18N
        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kembaliMouseClicked(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        getContentPane().add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 100, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/SEARCH.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 20, 30));

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        getContentPane().add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MenuBarang_1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 740, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked
        // ke halaman data pemesanan
         DataPemesanan start = new DataPemesanan ();
         start.setVisible(true);
         this.dispose();


    }//GEN-LAST:event_kembaliMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
 
    }//GEN-LAST:event_refreshMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // tombol cari
        tampilData();

    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_searchKeyReleased

    private void table_barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barang1MouseClicked
        // TODO add your handling code here:
        int row = table_barang1.getSelectedRow();
        DataPemesanan pemesanan = new DataPemesanan();
        
        String id = model.getValueAt(row, 0).toString();
        pemesanan.txt_idbarang.setText(id);
       
        String nama = model.getValueAt(row, 1).toString();
        pemesanan.txt_namabarang.setText(nama);
        
        String harga = model.getValueAt(row, 2).toString();

        pemesanan.txt_harga.setText(harga);
                      
        pemesanan.setVisible(true);
        pemesanan.pack();
        pemesanan.setDefaultCloseOperation(DataPemesanan.DISPOSE_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_table_barang1MouseClicked

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
            java.util.logging.Logger.getLogger(MenuBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kembali;
    private javax.swing.JLabel refresh;
    private javax.swing.JTable table_barang1;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
