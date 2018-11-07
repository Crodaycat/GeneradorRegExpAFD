/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import logic.AutomatonCreator;
import logic.SecuenceConstructor;
import model.AFD;
import model.DoubleNode;

/**
 *
 * @author luis_
 */
public class Main extends javax.swing.JFrame {
    
    boolean hasAExpression;
    AFD automaton;
    /**
     * Creates new form Principal
     */
    public Main() {
        hasAExpression = false;
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

        btnCrearAutomata = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHilera = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAnalizarHilera = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtExpresion = new javax.swing.JTextArea();
        btnVisualizarAtómata = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblEstadoHilera = new javax.swing.JLabel();
        btnNachoAutomatea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robertómata");

        btnCrearAutomata.setText("Crear atómata");
        btnCrearAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAutomataActionPerformed(evt);
            }
        });

        txtHilera.setColumns(20);
        txtHilera.setRows(5);
        jScrollPane1.setViewportView(txtHilera);

        jLabel1.setText("Ingrese la expresión regular:");

        jLabel2.setText("Ingrese la hilera a análizar:");

        btnAnalizarHilera.setText("Análizar hilera");
        btnAnalizarHilera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarHileraActionPerformed(evt);
            }
        });

        txtExpresion.setColumns(20);
        txtExpresion.setRows(5);
        jScrollPane2.setViewportView(txtExpresion);

        btnVisualizarAtómata.setText("Visualizar autómata finito generado");
        btnVisualizarAtómata.setToolTipText("");
        btnVisualizarAtómata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarAtómataActionPerformed(evt);
            }
        });

        jLabel3.setText("Estado de la hilera:");

        lblEstadoHilera.setText("En espera.");

        btnNachoAutomatea.setText("Acerca de Robertómata");
        btnNachoAutomatea.setActionCommand("");
        btnNachoAutomatea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNachoAutomateaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVisualizarAtómata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAnalizarHilera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstadoHilera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNachoAutomatea)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearAutomata)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnAnalizarHilera))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVisualizarAtómata, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblEstadoHilera))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNachoAutomatea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAutomataActionPerformed
        String expression = txtExpresion.getText();
        if (!expression.equals(""))
        {
            SecuenceConstructor c = new SecuenceConstructor(expression); // (0|1.0*.1)*.0* = (0+10*1)*0*
            try {
                hasAExpression = false;
                lblEstadoHilera.setText("En espera.");
                DoubleNode start = c.CreateThompson(); // Aplica el primer operador (.+|*)
                automaton = AutomatonCreator.generateAFD(start, c.secSimbols);
                automaton.printAutomaton();
                automaton.simplifyAutomaton();
                hasAExpression = true;
                JOptionPane.showMessageDialog(null, "El autómata ha sido generado con éxito.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Ingrese una expresión válida.");
        }
    }//GEN-LAST:event_btnCrearAutomataActionPerformed

    private void btnAnalizarHileraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarHileraActionPerformed
        if (hasAExpression)
        {
            String string = txtHilera.getText();
            if (!string.equals(""))
            {
                boolean itMatches = automaton.evaluateString(string);
                if (itMatches)
                {
                    lblEstadoHilera.setText("La hilera ha sido aceptada.");
                }
                else
                {
                    lblEstadoHilera.setText("La hilera ha sido rechazada.");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Ingrese una hilera válida.");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Genere primero un autómata para poder analizar la hilera.");
        }
    }//GEN-LAST:event_btnAnalizarHileraActionPerformed

    private void btnVisualizarAtómataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarAtómataActionPerformed
        if (automaton != null)
        {
            AFDView afdv = new AFDView(automaton);
        }
        else
            JOptionPane.showMessageDialog(null, "Debe generar un autómata primero para poder visualizarlo.");
    }//GEN-LAST:event_btnVisualizarAtómataActionPerformed

    private void btnNachoAutomateaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNachoAutomateaActionPerformed
        JOptionPane.showMessageDialog(null, 
            "Instrucciones de uso.\n\n"
            + "1. Símbolos especiales: ┤ es fin de secuencia, se genera con ALT + 180. ± es secuencia vacía, se genera con ALT + 241. ■ es la secuencia nula, se genera con ALT + 254.\n\n"
            + "2. Genere primero el autómata, para ello ingrese la expresión regular en el campo que está debajo del botón crear autómata.\n\n"
            + "3. Para visualizar el autómata haga click en el botón que dice: Visualizar el autómata finito generado. Que se encuentra en la parte inferior izquierda.\n\n"
            + "4. Para validar una secuencia escriba la secuencia en el campo que está debajo del botón Análizar hilera, haga click en el botón y debajo del cuadro de texto\n"
            + "se le informará el resultado. Los símbolos especiales están definidos en el númeral 1.\n\n"
            + "5. Tenga en cuenta que la expresión (GO|GOTO|TOO|ON)*.ON.TOO debe escribirse de la siguiente manera: ((G.O)|(G.O.T.O)|(T.O.O)|(O.N))*.O.N.T.O.O y de manera análoga\n"
            + "usar esta misma convención para otras expresiones.\n\n"
            + "El nombre de la aplicación es en honor al profesor: Roberto Flórez Rueda, que dicta la materia de Teoria de lenguajes en la UdeA.\n"
            + "Robertómata = Roberto + Autómata.\n\n"
            + "Robertómata ha sido programado por los estudiantes: \n"
            + "Andrés Mauricio Álvarez Ortiz.\n"
            + "Luis Alfonso Giraldo Murillo.\n\n"
            + "Ingeniería de sistemas - Universidad de Antioquia. Octubre de 2018.");
    }//GEN-LAST:event_btnNachoAutomateaActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarHilera;
    private javax.swing.JButton btnCrearAutomata;
    private javax.swing.JButton btnNachoAutomatea;
    private javax.swing.JButton btnVisualizarAtómata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEstadoHilera;
    private javax.swing.JTextArea txtExpresion;
    private javax.swing.JTextArea txtHilera;
    // End of variables declaration//GEN-END:variables
}