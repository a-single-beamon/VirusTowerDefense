/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.immunity_defense.immunity_defense;

/**
 *
 * @author joseh
 */
public class TelaMenu extends javax.swing.JFrame {

    /**
     * Creates new form TelaMenu
     */
    public TelaMenu() {
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

        ConfiguracoesButton = new javax.swing.JButton();
        RankingButton = new javax.swing.JButton();
        SairButton = new javax.swing.JButton();
        JogarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("menu");
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(350, 200, 100, 100));
        setMinimumSize(new java.awt.Dimension(572, 306));
        setPreferredSize(new java.awt.Dimension(572, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        ConfiguracoesButton.setText("CONFIGURAÇÕES");
        ConfiguracoesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracoesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ConfiguracoesButton);
        ConfiguracoesButton.setBounds(32, 259, 146, 33);

        RankingButton.setText("RANKING");
        RankingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RankingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RankingButton);
        RankingButton.setBounds(230, 259, 130, 33);

        SairButton.setText("SAIR");
        SairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SairButton);
        SairButton.setBounds(414, 259, 130, 33);

        JogarButton.setText("JOGAR");
        JogarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JogarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(JogarButton);
        JogarButton.setBounds(184, 182, 211, 47);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem_tela_menu.jpeg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-190, 0, 840, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JogarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JogarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JogarButtonActionPerformed

    private void SairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairButtonActionPerformed
        dispose();
    }//GEN-LAST:event_SairButtonActionPerformed

    private void ConfiguracoesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracoesButtonActionPerformed
        var dt = new TelaConfiguracoes();
        dt.setVisible(true);
        dispose();
    }//GEN-LAST:event_ConfiguracoesButtonActionPerformed

    private void RankingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RankingButtonActionPerformed
        var dt = new TelaRanking();
        dt.setVisible(true);
        dispose();
    }//GEN-LAST:event_RankingButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfiguracoesButton;
    private javax.swing.JButton JogarButton;
    private javax.swing.JButton RankingButton;
    private javax.swing.JButton SairButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
