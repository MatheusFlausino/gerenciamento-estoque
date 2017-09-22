/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Classes.Fornecedor;
import DAOPapel.DAOFornecedor;
import java.io.IOException;

/**
 *
 * @author mathe_56ugtvf
 */
public final class formFornecedor extends javax.swing.JFrame {
    /**
     * Creates new form formFornecedor
     * @throws java.lang.Exception
     */
    public formFornecedor() throws Exception {
        initComponents();
        resetText();
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
        nomeFornecedor = new javax.swing.JTextField();
        logradouroFornecedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numeroFornecedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        complementoFornecedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bairroFornecedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cidadeFornecedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        estadoFornecedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cepFornecedor = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        telefoneFornecedor = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        cpfFornecedor = new javax.swing.JFormattedTextField();
        tituloCliente = new javax.swing.JLabel();
        salvarCliente = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        atualizarCliente = new javax.swing.JButton();
        excluirCliente = new javax.swing.JButton();
        buscarCliente = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        codigoFornecedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DO FORNECEDOR");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setLabelFor(nomeFornecedor);
        jLabel1.setText("Nome");

        jLabel2.setLabelFor(logradouroFornecedor);
        jLabel2.setText("Logradouro");

        numeroFornecedor.setText(" ");

        jLabel3.setLabelFor(numeroFornecedor);
        jLabel3.setText("Numero");

        complementoFornecedor.setText(" ");

        jLabel4.setLabelFor(complementoFornecedor);
        jLabel4.setText("Complemento");

        bairroFornecedor.setText(" ");

        jLabel5.setLabelFor(bairroFornecedor);
        jLabel5.setText("Bairro");

        cidadeFornecedor.setText(" ");

        jLabel6.setLabelFor(cidadeFornecedor);
        jLabel6.setText("Cidade");

        estadoFornecedor.setText(" ");

        jLabel7.setLabelFor(estadoFornecedor);
        jLabel7.setText("Estado");

        jLabel10.setLabelFor(cepFornecedor);
        jLabel10.setText("CEP");

        try {
            cepFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setLabelFor(telefoneFornecedor);
        jLabel11.setText("Telefone");

        try {
            telefoneFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setLabelFor(cpfFornecedor);
        jLabel12.setText("CNPJ");

        try {
            cpfFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tituloCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloCliente.setText("CADASTRO DO FORNECEDOR");

        salvarCliente.setText("Salvar");
        salvarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarClienteActionPerformed(evt);
            }
        });

        reset.setText("Limpar");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        atualizarCliente.setText("Atualizar");
        atualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarClienteActionPerformed(evt);
            }
        });

        excluirCliente.setText("Excluir");
        excluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirClienteActionPerformed(evt);
            }
        });

        buscarCliente.setText("Buscar");
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        exit.setText("Voltar");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel8.setText("Código");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salvarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atualizarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluirCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset)
                        .addGap(18, 18, 18)
                        .addComponent(exit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloCliente)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cepFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logradouroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complementoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bairroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cidadeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estadoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telefoneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numeroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buscarCliente))
                                        .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cpfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {atualizarCliente, buscarCliente, excluirCliente, exit, reset, salvarCliente});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tituloCliente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(codigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cpfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cepFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logradouroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numeroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(complementoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bairroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cidadeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(estadoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(telefoneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarCliente)
                    .addComponent(atualizarCliente)
                    .addComponent(excluirCliente)
                    .addComponent(exit)
                    .addComponent(reset))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        resetText();
    }//GEN-LAST:event_formWindowOpened

    private void atualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarClienteActionPerformed
        // TODO add your handling code here:
        
        try {
            Fornecedor novoFornecedor = getFornecedor();
            dbFornecedor.atualizar(novoFornecedor);
            imprimeMsg("Fornecedor Atualizado com Sucesso");
        } catch (Exception ex) {
            System.out.print("Erro ao Atualizar: "+ ex.getMessage());
        }
    }//GEN-LAST:event_atualizarClienteActionPerformed

    private void excluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirClienteActionPerformed
        // TODO add your handling code here:

        try {
            Fornecedor novoFornecedor = getFornecedor();
            dbFornecedor.remover(novoFornecedor);
            imprimeMsg("Fornecedor Excluido com Sucesso");
        } catch (Exception ex) {
            System.out.print("Erro ao Atualizar: "+ ex.getMessage());
        }
    }//GEN-LAST:event_excluirClienteActionPerformed

    private void salvarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarClienteActionPerformed
        // TODO add your handling code here:
        Fornecedor novoFornecedor = null;
        try {
            novoFornecedor = getFornecedor();
            dbFornecedor.inserir(novoFornecedor);
            imprimeMsg("Fornecedor Salvo com Sucesso");
        } catch (Exception ex) {
            System.out.print("Erro ao Salvar: "+ ex.getMessage());
        }
        
    }//GEN-LAST:event_salvarClienteActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        resetText();
    }//GEN-LAST:event_resetActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_exitActionPerformed

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        // TODO add your handling code here:
        Fornecedor buscaFornecedor = buscarFornecedor();
        
        nomeFornecedor.setText(buscaFornecedor.getNomeFornecedor() );
        cpfFornecedor.setText(buscaFornecedor.getCnpjFornecedor() );
        cepFornecedor.setText(buscaFornecedor.getCepFornecedor() );
        logradouroFornecedor.setText(buscaFornecedor.getLogradouroFornecedor() );
        numeroFornecedor.setText(String.valueOf(buscaFornecedor.getNumeroFornecedor()));
        bairroFornecedor.setText(buscaFornecedor.getBairroFornecedor() );
        cidadeFornecedor.setText(buscaFornecedor.getCidadeFornecedor() );
        complementoFornecedor.setText(buscaFornecedor.getComplementoFornecedor() );
        estadoFornecedor.setText(buscaFornecedor.getEstadoFornecedor() );
        telefoneFornecedor.setText(buscaFornecedor.getTelefoneFornecedor() );
    }//GEN-LAST:event_buscarClienteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            dbFornecedor.gravaResultado();
        } catch (IOException ex) {
            Logger.getLogger(formFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(formFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new formFornecedor().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(formFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    /*
     * Metodos criados 
     */
    private void resetText(){
        nomeFornecedor.setText("");
        cpfFornecedor.setText("");
        cepFornecedor.setText("");
        logradouroFornecedor.setText("");
        numeroFornecedor.setText("");
        bairroFornecedor.setText("");
        cidadeFornecedor.setText("");
        complementoFornecedor.setText("");
        estadoFornecedor.setText("");
        telefoneFornecedor.setText("");
    }
    
    private Fornecedor getFornecedor() throws ParseException, Exception{
        Fornecedor novoFornecedor = new Fornecedor();
        
        novoFornecedor.setIdFornecedor(Integer.parseInt(codigoFornecedor.getText()));
        novoFornecedor.setNomeFornecedor(nomeFornecedor.getText());
        novoFornecedor.setCnpjFornecedor(cpfFornecedor.getText());
        novoFornecedor.setCepFornecedor(cepFornecedor.getText());
        novoFornecedor.setBairroFornecedor(bairroFornecedor.getText());
        novoFornecedor.setCidadeFornecedor(cidadeFornecedor.getText());
        novoFornecedor.setComplementoFornecedor(complementoFornecedor.getText());
        novoFornecedor.setLogradouroFornecedor(logradouroFornecedor.getText());
        novoFornecedor.setEstadoFornecedor(estadoFornecedor.getText());
        novoFornecedor.setNumeroFornecedor(Integer.parseInt(numeroFornecedor.getText()));
        novoFornecedor.setTelefoneFornecedor(telefoneFornecedor.getText());
        
        return novoFornecedor;
    }
    public void setCodigo(boolean id) throws Exception{
        int codigo = 0;
        if(id){
            codigo = dbFornecedor.ultimoCodigo();
            this.codigoFornecedor.setEditable(false);
            this.nomeFornecedor.requestFocus();
        }
        codigoFornecedor.setText(String.valueOf(codigo));
    }
    
    private Fornecedor buscarFornecedor(){
        DAOFornecedor daoFornecedor = new DAOFornecedor();
        
        try {
            return daoFornecedor.buscar(Integer.parseInt(codigoFornecedor.getText()));
        } catch (Exception ex) {
            System.out.print("Erro ao Buscar Fornecedor: "+ ex.getMessage());
        }
        return null;
    }
    
    private void imprimeMsg(String msg) {  
        JOptionPane.showMessageDialog(null, msg, "Notificação", 0);  
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarCliente;
    private javax.swing.JTextField bairroFornecedor;
    private javax.swing.JButton buscarCliente;
    private javax.swing.JFormattedTextField cepFornecedor;
    private javax.swing.JTextField cidadeFornecedor;
    private javax.swing.JTextField codigoFornecedor;
    private javax.swing.JTextField complementoFornecedor;
    private javax.swing.JFormattedTextField cpfFornecedor;
    private javax.swing.JTextField estadoFornecedor;
    private javax.swing.JButton excluirCliente;
    private javax.swing.JButton exit;
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
    private javax.swing.JTextField logradouroFornecedor;
    private javax.swing.JTextField nomeFornecedor;
    private javax.swing.JTextField numeroFornecedor;
    private javax.swing.JButton reset;
    private javax.swing.JButton salvarCliente;
    private javax.swing.JFormattedTextField telefoneFornecedor;
    private javax.swing.JLabel tituloCliente;
    // End of variables declaration//GEN-END:variables
    DAOFornecedor dbFornecedor = new DAOFornecedor();
}
