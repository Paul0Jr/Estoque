package JPanels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Fornecedores extends javax.swing.JPanel {

    Connection Con = null;
    ResultSet Rs = null;
    Statement St = null;
    PreparedStatement Ps = null;
    String nome, query, id, numero = null, codigo, buscaBD = null;
    String BDurl = "jdbc:MySQL://127.0.0.1:3306/estoque";
    String BDusuario = "root";
    String BDsenha = "";
    int nao_encontrado = 0;

    public Fornecedores() {
        initComponents();
        tabela();
    }

    private void tabela() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            Ps = Con.prepareStatement("SELECT * FROM fornecedores");
            Rs = Ps.executeQuery();
            java.sql.ResultSetMetaData rsmd = Rs.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) TabelaProd.getModel();
            dtm.setRowCount(0);

            while (Rs.next()) {
                Vector vetor = new Vector();
                for (int i = 1; i < n; i++) {
                    vetor.add(Rs.getString(1));
                    vetor.add(Rs.getString(2));
                    vetor.add(Rs.getString(3));
                }
                //System.out.println(vetor);
                dtm.addRow(vetor);

            }
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BuscarNome = new javax.swing.JFormattedTextField();
        BuscarBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        BuscarID = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProd = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        IdForn = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        NomeForn = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        AdicionarBtn = new javax.swing.JButton();
        AttBtn = new javax.swing.JButton();
        DeletarBtn = new javax.swing.JButton();
        AvisoID = new javax.swing.JLabel();
        AvisoNome = new javax.swing.JLabel();
        AvisoQtd = new javax.swing.JLabel();
        AvisoPreco = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NomeForn1 = new javax.swing.JFormattedTextField();
        AttTabela = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GERENCIADOR DE FORNECEDORES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel1)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("BUSCAR FORNECEDOR");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("BUSCAR NOME:");

        BuscarNome.setBackground(new java.awt.Color(255, 255, 255));
        BuscarNome.setForeground(new java.awt.Color(0, 0, 0));
        BuscarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNomeActionPerformed(evt);
            }
        });

        BuscarBtn.setBackground(new java.awt.Color(0, 153, 0));
        BuscarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BuscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        BuscarBtn.setText("BUSCAR");
        BuscarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("BUSCAR ID:");

        BuscarID.setBackground(new java.awt.Color(255, 255, 255));
        BuscarID.setForeground(new java.awt.Color(0, 0, 0));
        BuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BuscarNome, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(BuscarID)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(BuscarBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(BuscarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(BuscarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(BuscarBtn)
                .addGap(22, 22, 22))
        );

        TabelaProd.setBackground(new java.awt.Color(255, 255, 255));
        TabelaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID FORNE", "NOME", "NÚMERO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaProd);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID FORNE:");

        IdForn.setBackground(new java.awt.Color(255, 255, 255));
        IdForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdFornActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("NOME:");

        NomeForn.setBackground(new java.awt.Color(255, 255, 255));
        NomeForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeFornActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("NÚMERO:");

        AdicionarBtn.setBackground(new java.awt.Color(0, 153, 0));
        AdicionarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AdicionarBtn.setForeground(new java.awt.Color(255, 255, 255));
        AdicionarBtn.setText("ADICIONAR");
        AdicionarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AdicionarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarBtnActionPerformed(evt);
            }
        });

        AttBtn.setBackground(new java.awt.Color(0, 153, 0));
        AttBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AttBtn.setForeground(new java.awt.Color(255, 255, 255));
        AttBtn.setText("ATUALIZAR");
        AttBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AttBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttBtnActionPerformed(evt);
            }
        });

        DeletarBtn.setBackground(new java.awt.Color(0, 153, 0));
        DeletarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeletarBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeletarBtn.setText("DELETAR");
        DeletarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeletarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarBtnActionPerformed(evt);
            }
        });

        AvisoID.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AvisoID.setForeground(new java.awt.Color(255, 0, 0));

        AvisoNome.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AvisoNome.setForeground(new java.awt.Color(255, 0, 0));

        AvisoQtd.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AvisoQtd.setForeground(new java.awt.Color(255, 0, 0));

        AvisoPreco.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AvisoPreco.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("GERENCIAR FORNECEDOR");

        NomeForn1.setBackground(new java.awt.Color(255, 255, 255));
        NomeForn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeForn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(AdicionarBtn)
                .addGap(18, 18, 18)
                .addComponent(AttBtn)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(AvisoPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(DeletarBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AvisoQtd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AvisoNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NomeForn, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(AvisoID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IdForn)
                            .addComponent(NomeForn1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AvisoID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AvisoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeForn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(AvisoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AvisoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdicionarBtn)
                            .addComponent(AttBtn)
                            .addComponent(DeletarBtn))))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        AttTabela.setBackground(new java.awt.Color(0, 153, 0));
        AttTabela.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AttTabela.setForeground(new java.awt.Color(255, 255, 255));
        AttTabela.setText("ATUALIZAR TABELA");
        AttTabela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AttTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AttTabela)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(AttTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void BuscarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNomeActionPerformed

    private void IdFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdFornActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdFornActionPerformed

    private void NomeFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeFornActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeFornActionPerformed

    private void BuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            St = Con.createStatement();
            if ("".equals(BuscarNome.getText()) && "".equals(BuscarID.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Necessário inserir o nome ou ID do fornecedor!", "Erro ao buscar!", JOptionPane.ERROR_MESSAGE);
            } else {
                if ("".equals(BuscarNome.getText())) {
                    codigo = BuscarID.getText();
                    query = "SELECT * FROM fornecedores WHERE id ='" + codigo + "'";
                    Rs = St.executeQuery(query);
                    while (Rs.next()) {
                        buscaBD = Rs.getString("id");
                        nao_encontrado = 1;
                        id = Rs.getString("id");
                        nome = Rs.getString("nome");
                        numero = Rs.getString("numero");
                        showMessageDialog(null, "ID: " + id + "\nNome: " + nome + "\nNúmero: " + numero);
                    }
                    if (!(nao_encontrado == 1 && codigo.equals(buscaBD))) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID não encontrado!", "Erro ao buscar!", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }

                } else if ("".equals(BuscarID.getText())) {
                    codigo = BuscarNome.getText();
                    query = "SELECT * FROM fornecedores WHERE nome ='" + codigo + "'";
                    Rs = St.executeQuery(query);
                    while (Rs.next()) {
                        buscaBD = Rs.getString("nome");
                        nao_encontrado = 1;
                        id = Rs.getString("id");
                        nome = Rs.getString("nome");
                        numero = Rs.getString("numero");
                        showMessageDialog(null, "ID: " + id + "\nNome: " + buscaBD + "\nNúmero: " + numero);

                    }
                    if (!(nao_encontrado == 1 && codigo.equals(buscaBD))) {
                        JOptionPane.showMessageDialog(new JFrame(), "Nome não encontrado!", "Erro ao buscar!", JOptionPane.ERROR_MESSAGE);
                    } else {
                    }
                }
                IdForn.setText("");
                NomeForn.setText("");
                NomeForn1.setText("");
                BuscarID.setText("");
                BuscarNome.setText("");
                tabela();
            }
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_BuscarBtnActionPerformed

    private void AdicionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            St = Con.createStatement();

            //MENSAGENS DE ERRO
            if ("".equals(IdForn.getText()) || (IdForn.getText().length() <= 0)) {
                AvisoID.setText("Insira um id válido!");
                AvisoNome.setText("");
                AvisoQtd.setText("");

            } else if ("".equals(NomeForn.getText()) || NomeForn.getText().length() <= 3) {
                AvisoID.setText("");
                AvisoNome.setText("Insira um nome válido!");
                AvisoQtd.setText("");

            } else if ("".equals(NomeForn1.getText()) || NomeForn1.getText().length() <= 3) {
                AvisoID.setText("");
                AvisoNome.setText("");
                AvisoQtd.setText("Insira um número válido!");

            } else {
                id = IdForn.getText();
                nome = NomeForn.getText();
                numero = NomeForn1.getText();

                //CONSULTA NO BANCO
                query = "SELECT * FROM fornecedores WHERE id ='" + id + "'";
                Rs = St.executeQuery(query);
                while (Rs.next()) {
                    buscaBD = Rs.getString("id");
                    nao_encontrado = 1;
                }

                //VALIDAÇÃO DE DADOS
                if (nao_encontrado == 1 && id.equals(buscaBD)) {
                    JOptionPane.showMessageDialog(new JFrame(), "O ID DIGITADO JÁ ESTÁ SENDO UTILIZADO!", "Erro ao adicionar!", JOptionPane.ERROR_MESSAGE);
                    AvisoID.setText("Insira um id válido!");
                    IdForn.setText("");
                } else {
                    //INSERIR NO BANCO
                    query = "INSERT INTO fornecedores (id, nome, numero)" + "VALUES('" + id + "', '" + nome + "', '" + numero + "')";
                    St.execute(query);
                    IdForn.setText("");
                    NomeForn.setText("");
                    NomeForn1.setText("");
                    showMessageDialog(null, "Fornecedor adicionado com sucesso!");
                    AvisoID.setText("");
                    AvisoNome.setText("");
                    AvisoQtd.setText("");
                    AvisoPreco.setText("");
                }
                tabela();
            }

        } catch (Exception e) {

            //ERRO NO CADASTRO DO PRODUTO E QUAL TIPO DE ERRO(MOSTRADO APENAS NO CONSOLE)
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_AdicionarBtnActionPerformed

    private void DeletarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            St = Con.createStatement();

            //ID VAZIO
            if (IdForn.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Insira apenas o ID do fornecedor que deseja deletar!", "Erro ao deletar!", JOptionPane.ERROR_MESSAGE);
            } else {

                //CONSULTA NO BANCO
                id = IdForn.getText();
                query = "SELECT * FROM fornecedores WHERE id ='" + id + "'";
                Rs = St.executeQuery(query);
                while (Rs.next()) {
                    buscaBD = Rs.getString("id");
                    nao_encontrado = 1;
                }
                if (nao_encontrado == 1 && id.equals(buscaBD)) {
                    query = "DELETE FROM estoque.fornecedores WHERE id =" + id;
                    St.execute(query);
                    showMessageDialog(null, "Fornecedor deletado com sucesso!");
                    AvisoID.setText("");
                    AvisoNome.setText("");
                    AvisoQtd.setText("");
                    AvisoPreco.setText("");
                    IdForn.setText("");
                    NomeForn.setText("");
                    NomeForn1.setText("");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Fornecedor não encontrado!", "Erro ao deletar!", JOptionPane.ERROR_MESSAGE);
                }
                tabela();
            }
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_DeletarBtnActionPerformed

    private void AttBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            St = Con.createStatement();
            if (IdForn.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Insira o ID do fornecedor que deseja atualizar as informações!", "Erro ao atualizar!", JOptionPane.ERROR_MESSAGE);
            } else {
                id = IdForn.getText();
                //CONSULTA NO BANCO
                query = "SELECT * FROM fornecedores WHERE id ='" + id + "'";
                Rs = St.executeQuery(query);
                while (Rs.next()) {
                    buscaBD = Rs.getString("id");
                    nao_encontrado = 1;
                }

                //VALIDAÇÃO DE DADOS
                if (nao_encontrado == 1 && id.equals(buscaBD)) {

                    //ATUALIZAÇÃO DE NOME
                    if (!NomeForn.getText().isEmpty()) {
                        nome = NomeForn.getText();
                        query = "UPDATE fornecedores SET nome = '" + nome + "' WHERE id = '" + id + "'";
                        St.execute(query);

                        //ATUALIZAÇÃO DE NÚMERO
                    } else if (!NomeForn1.getText().isEmpty()) {
                        numero = NomeForn1.getText();
                        query = "UPDATE fornecedores SET numero = '" + numero + "' WHERE id = '" + id + "'";
                        St.execute(query);
                        AvisoID.setText("");

                    }
                    showMessageDialog(null, "Fornecedor atualizado com sucesso!");

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Fornecedor não encontrado na base de dados!", "Erro ao atualizar!", JOptionPane.ERROR_MESSAGE);
                }
                AvisoID.setText("");
                AvisoNome.setText("");
                AvisoQtd.setText("");
                AvisoPreco.setText("");
                IdForn.setText("");
                NomeForn.setText("");
                NomeForn1.setText("");
                tabela();
            }
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_AttBtnActionPerformed

    private void BuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarIDActionPerformed

    private void AttTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttTabelaActionPerformed
        tabela();
    }//GEN-LAST:event_AttTabelaActionPerformed

    private void NomeForn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeForn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeForn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarBtn;
    private javax.swing.JButton AttBtn;
    private javax.swing.JButton AttTabela;
    private javax.swing.JLabel AvisoID;
    private javax.swing.JLabel AvisoNome;
    private javax.swing.JLabel AvisoPreco;
    private javax.swing.JLabel AvisoQtd;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JFormattedTextField BuscarID;
    private javax.swing.JFormattedTextField BuscarNome;
    private javax.swing.JButton DeletarBtn;
    private javax.swing.JFormattedTextField IdForn;
    private javax.swing.JFormattedTextField NomeForn;
    private javax.swing.JFormattedTextField NomeForn1;
    private javax.swing.JTable TabelaProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
