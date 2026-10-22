package views;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author CAMPUSRP-LAB\09816655608
 */
public class FrVerComunidadeMural extends javax.swing.JFrame {

    private javax.swing.JFrame telaAnterior;

    public void setTelaAnterior(javax.swing.JFrame tela) {
        this.telaAnterior = tela;
    }
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrVerComunidadeMural.class.getName());

    /**
     * Creates new form FrComunidade
     */
    public FrVerComunidadeMural() {
        initComponents();
        setLocationRelativeTo(null);

        VerMural.setContentType("text/html");
        VerMural.setEditable(false);

        // Ativa o clique no link "[ Responder ]"
        VerMural.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent e) {
                if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                    String idPostagemPai = e.getDescription();
                    responderPostagem(Long.parseLong(idPostagemPai));
                }
            }
        });

        carregarFórum();
    }

    private void responderPostagem(Long idPostagemPai) {
        String resposta = javax.swing.JOptionPane.showInputDialog(this, "Digite a sua resposta:", "Responder", javax.swing.JOptionPane.PLAIN_MESSAGE);

        if (resposta != null && !resposta.trim().isEmpty()) {

            try {

                entidades.Usuario usuarioLogado = controller.SessaoController.getUsuarioLogado();

                if (!(usuarioLogado instanceof entidades.Gestante)) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Apenas gestantes podem responder no fórum!", "Acesso Negado", javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }

                entidades.Gestante autora = (entidades.Gestante) usuarioLogado;

                dao.MuralDAO muralDAO = new dao.MuralDAO();
                entidades.Mural postPai = muralDAO.listarTodos().stream().filter(p -> p.getIdPostMural().equals(idPostagemPai)).findFirst().orElse(null);

                if (postPai != null) {
                    new controller.ComunidadeController().salvarPostMural("", "", resposta, autora, postPai);
                    carregarFórum(); // Recarrega a tela para exibir a nova resposta
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Erro: Tópico original não encontrado.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar resposta: " + e.getMessage());
            }
        }
    }


    private void carregarFórum() {
        try {
            java.util.List<entidades.Mural> lista = new controller.ComunidadeController().listarMural();
            StringBuilder html = new StringBuilder();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy 'às' HH:mm");

            html.append("<html><body style='font-family: Tahoma, sans-serif; background-color: #eaeded; margin: 10px;'>");

            // 1. Loop para os TÓPICOS PRINCIPAIS (postagemPai == null)
            for (entidades.Mural m : lista) {
                if (m.getPostagemPai() == null) {
                    String autora = (m.getGestante() != null) ? m.getGestante().getNome() : "Desconhecida";
                    String dataStr = sdf.format(m.getDataPublicacao());

                    html.append("<div style='background-color: #ffffff; border: 1px solid #cccccc; border-radius: 5px; margin-bottom: 5px; padding: 10px;'>");
                    html.append("<div style='color: #787c7e; font-size: 10px; margin-bottom: 5px;'>")
                            .append("Postado por <b>u/").append(autora.replaceAll(" ", "")).append("</b> em ").append(dataStr)
                            .append("</div>");
                    html.append("<div style='color: #1c1c1c; font-size: 12px;'>")
                            .append(m.getTextoDica().replace("\n", "<br>"))
                            .append("</div>");
                    // Link para responder a este tópico
                    html.append("<div style='margin-top: 8px;'><a href='").append(m.getIdPostMural()).append("' style='color: #0079d3; text-decoration: none; font-size: 10px; font-weight: bold;'>[ Responder ]</a></div>");
                    html.append("</div>");

                    // 2. Loop para as RESPOSTAS deste tópico
                    for (entidades.Mural resp : lista) {
                        if (resp.getPostagemPai() != null && resp.getPostagemPai().getIdPostMural().equals(m.getIdPostMural())) {
                            String autoraResp = (resp.getGestante() != null) ? resp.getGestante().getNome() : "Desconhecida";
                            String dataResp = sdf.format(resp.getDataPublicacao());

                            // A margem esquerda (margin-left: 30px) cria o efeito de "escadinha" do Reddit
                            html.append("<div style='background-color: #f8f9fa; border-left: 3px solid #d7dadc; margin-left: 30px; margin-bottom: 5px; padding: 8px;'>");
                            html.append("<div style='color: #787c7e; font-size: 9px; margin-bottom: 3px;'>")
                                    .append("↳ Resposta de <b>u/").append(autoraResp.replaceAll(" ", "")).append("</b> em ").append(dataResp)
                                    .append("</div>");
                            html.append("<div style='color: #1c1c1c; font-size: 11px;'>")
                                    .append(resp.getTextoDica().replace("\n", "<br>"))
                                    .append("</div>");
                            html.append("</div>");
                        }
                    }
                    html.append("<br>");
                }
            }
            html.append("</body></html>");
            VerMural.setText(html.toString());
            VerMural.setCaretPosition(0);
        } catch (Exception e) {
            VerMural.setText("<html><body>Erro ao carregar o fórum.</body></html>");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        VerMural = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jScrollPane3.setViewportView(VerMural);

        jLabel5.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        jLabel5.setText("VEJA OQUE NOSSAS CLIENTES TEM A DIZER SOBRE SUAS EXPERIANCIAS ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Bitstream Charter", 3, 24)); // NOI18N
        jLabel1.setText("SEJA BEM VINDO A NOSSA COMUNIDADE ");

        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();

        if (this.telaAnterior != null) {
            this.telaAnterior.setVisible(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrVerComunidadeMural().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane VerMural;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
