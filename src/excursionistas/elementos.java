
package excursionistas;

import com.sun.glass.events.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class elementos extends javax.swing.JDialog {
    public static DefaultTableModel dtm;
    public static Object v[] = {"Descripción","Cantidad","Peso","Calorias"};
    int sp=0,sc=0,f,i, smc=0, smp=0, peso=10,cal=15;
    public elementos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(415, 370);
        this.setLocationRelativeTo(this);
        this.setTitle("ELEMENTOS");
        dtm = new DefaultTableModel(null, v);
        jtelementos.setModel(dtm);
        //setIconImage(new ImageIcon(getClass().getResource("../iconos/ventas.png")).getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtelementos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtaltura = new javax.swing.JTextField();
        lblcalorias = new javax.swing.JLabel();
        txtpeso = new javax.swing.JTextField();
        txtcalorias = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        lblpeso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 60, 20));

        jtelementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtelementos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 360, 100));

        jLabel2.setText("Peso:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, 20));

        jLabel3.setText("Calorias:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, 20));

        jLabel4.setText("Altura:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, 20));

        txtaltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtalturaKeyTyped(evt);
            }
        });
        getContentPane().add(txtaltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 100, -1));

        lblcalorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblcalorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 340, 30));

        txtpeso.setEnabled(false);
        getContentPane().add(txtpeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 70, -1));

        txtcalorias.setEnabled(false);
        getContentPane().add(txtcalorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 70, -1));

        btnadd.setText("Agregar");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        lblpeso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblpeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 340, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        buscar bu = new buscar(null,true);
        bu.setVisible(true);
        bu.setLocationRelativeTo(this);
        calcular();
        valide();
    }//GEN-LAST:event_btnaddActionPerformed

    private void valide(){
        if (txtaltura.getText().equals("")){
            mensaje("Ingrese la altura del risco y los elementos");
        }
        else{
            if (smp<=peso && smc>=cal){
                mensaje("Los elementos seleccionados son los mas aptos para llevar");
            }
            else{
                mensaje("Se recomienda que seleccione otro tipo de elementos");
            }
        }
    }
    
    private void txtalturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalturaKeyTyped
        char tp = evt.getKeyChar();
        
        if (tp==KeyEvent.VK_ENTER){
            sp = Integer.parseInt(txtaltura.getText()) / 15;
            sc = Integer.parseInt(txtaltura.getText()) / 10;
            lblpeso.setText("Se recomienda llevar un maximo de peso de " + sp);
            lblcalorias.setText("Se recomienda llevar un minimo de calorias de " + sc);
        }
    }//GEN-LAST:event_txtalturaKeyTyped

    public static void enviar(String d1,String d2,String d3){
        int nf;
        nf = jtelementos.getRowCount();
        if (nf==0){
            v[0]=d1;
            v[1]="1";
            v[2]=d2;
            v[3]=d3;
            dtm.addRow(v);
        }
        else{
            jtelementos.setValueAt(d1,nf,0);
            jtelementos.setValueAt("1",nf,1);
            jtelementos.setValueAt(d2,nf,2);
            jtelementos.setValueAt(d3,nf,3);
        }
    }    
    
    private void calcular(){
        
        f = jtelementos.getRowCount();
        if (f==-1){
            mensaje("No ha seleccionado nada para llevar");
            txtpeso.setText("0");
            txtcalorias.setText("0");
        }
        else{
             for (i=0;i<f;i++){
                  smp = smp + ((Integer.parseInt(jtelementos.getValueAt(i, 2).toString())) * (Integer.parseInt(jtelementos.getValueAt(i, 1).toString())));
                  smc = smc + ((Integer.parseInt(jtelementos.getValueAt(i, 3).toString())) * (Integer.parseInt(jtelementos.getValueAt(i, 1).toString())));
            }
             txtpeso.setText(String.valueOf(smp));
             txtcalorias.setText(String.valueOf(smc));
         }
         
    }
    
    static public void mensaje(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
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
            java.util.logging.Logger.getLogger(elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(elementos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                elementos dialog = new elementos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnadd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtelementos;
    private javax.swing.JLabel lblcalorias;
    private javax.swing.JLabel lblpeso;
    private javax.swing.JTextField txtaltura;
    private javax.swing.JTextField txtcalorias;
    private javax.swing.JTextField txtpeso;
    // End of variables declaration//GEN-END:variables
}
