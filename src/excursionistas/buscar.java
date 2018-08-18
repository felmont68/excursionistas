package excursionistas;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class buscar extends javax.swing.JDialog {
    static final String url="jdbc:sqlserver://localhost:1433;databaseName=excursionistas;user=sa;password=123;";
    DefaultTableModel dtmd;
    Object v[] = {"Descripción","Peso","Calorias"};
    
    public buscar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(300, 245);
        this.setLocationRelativeTo(this);
        this.setTitle("PRODUCTOS");
        dtmd = new DefaultTableModel(null, v);
        jtproducto.setModel(dtmd);
        cargarproductos();
    }

    private void cargarproductos(){
        Connection con;
        try{
            con = DriverManager.getConnection(url);
            PreparedStatement ps;
            ps = con.prepareStatement("{call buscarpro}");
            ResultSet rs;
            rs=ps.executeQuery();
            int row=0;            
            while (rs.next()){
                    v[0]=rs.getString(2);
                    v[1]=rs.getString(3);
                    v[2]=rs.getInt(4);
                    dtmd.addRow(v);
            }
            con.close();
        }catch(Exception e){
               mensaje("Error en la conexion con el servidor. Comuniquese con el administrador de red");
        }
    }
    
    static public void mensaje(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtproducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtproductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtproducto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**/
    private void jtproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtproductoMouseClicked
        int row;
        row = jtproducto.getSelectedRow();
        if (row==-1){
            mensaje("No se encontro ningun registro");
        }
        else{
                 String d1,d2,d3;
                 d1 = jtproducto.getValueAt(row, 0).toString();
                 d2 = jtproducto.getValueAt(row, 1).toString();
                 d3 = jtproducto.getValueAt(row, 2).toString();
                 elementos.enviar(d1,d2,d3);
                 
                 this.dispose();
             }
        
    }//GEN-LAST:event_jtproductoMouseClicked

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
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                buscar dialog = new buscar(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtproducto;
    // End of variables declaration//GEN-END:variables
}
