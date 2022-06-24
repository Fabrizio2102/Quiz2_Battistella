package quiz2_battistella;
import javax.swing.JOptionPane;

public class Panel extends javax.swing.JFrame {
    ArbolBin arbolito = new ArbolBin();

    public Panel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        print = new javax.swing.JButton();
        pantalla = new javax.swing.JLabel();
        borrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregar.setText("Agg. número");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        print.setText("Imprimir preorden");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));
        jPanel1.add(pantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 320, 110));

        borrar.setText("Borrar nivel");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jPanel1.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        NodoBin aux;
        NodoBin aux2;
        int selec = 0;
        int ans = 0;
        int ansP = 0;
        while(true){
            try{
                ans = Integer.parseInt(JOptionPane.showInputDialog("Inserte el número (mayor a 0) que desea agregar: "));
                if(ans < 1){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                }else{
                    aux = new NodoBin(ans);
                    break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
            }
        }
        if(arbolito.isEmpty()){
            arbolito.setRoot(aux);
            this.pantalla.setText("Valor agregado con éxito.");
        }else{
            while(true){
                try{
                    ansP = Integer.parseInt(JOptionPane.showInputDialog("Inserte el valor que tiene el padre que desea: "));
                    break;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                }
            }
            aux2 = arbolito.search(arbolito.getRoot(), ansP);
            if(aux2 != null){
                if(aux2.getHijoD() == null && aux2.getHijoI() == null){
                    while(true){
                        try{
                            selec = Integer.parseInt(JOptionPane.showInputDialog("¿Qué hijo será?\n1. Derecho\n2. Izquierdo "));
                            if(selec != 1 && selec  != 2){
                                JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                            }else{
                                break;
                            }
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                        }
                    }
                    if(selec == 1){
                        arbolito.insertarDer(aux2, ans);
                    }else{
                        arbolito.insertarIzq(aux2, ans);
                    }
                    this.pantalla.setText("Valor agregado con éxito.");
                }else if(aux2.getHijoD() != null && aux2.getHijoI() != null){
                    this.pantalla.setText("Ambos hijos existen, no se puede agregar.");
                }else if(aux2.getHijoD() != null && aux2.getHijoI() == null){
                    arbolito.insertarIzq(aux2, ans);
                    this.pantalla.setText("Valor agregado con éxito.");
                }else if (aux2.getHijoD() == null && aux2.getHijoI() != null){
                    arbolito.insertarDer(aux2, ans);
                    this.pantalla.setText("Valor agregado con éxito.");
                }
            }else{
                this.pantalla.setText("No se encontró ningún padre.");
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        String valores = "";
        valores = arbolito.preorden1(arbolito.getRoot(), valores);
        this.pantalla.setText(valores);
    }//GEN-LAST:event_printActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        int ans = 0;
        while(true){
            try{
                ans = Integer.parseInt(JOptionPane.showInputDialog("Inserte nivel que desea eliminar: "));
                if(ans < 1){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                }else{
                    break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
            }
        }
        arbolito.eliminar_nivel(arbolito.getRoot(), ans);
        this.pantalla.setText("Nivel eliminado con éxito.");
    }//GEN-LAST:event_borrarActionPerformed

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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton borrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pantalla;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
