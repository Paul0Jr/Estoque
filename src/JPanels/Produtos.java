package JPanels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Produtos extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement ps = null;

    public Produtos() {
        initComponents();
        Tabela();
    }

    private void Tabela() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            ps = con.prepareStatement("SELECT * FROM produtos");
            rs = ps.executeQuery();
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) TabelaProd.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector vetor = new Vector();
                for (int i = 1; i < n; i++) {
                    vetor.add(rs.getString(1));
                    vetor.add(rs.getString(2));
                    vetor.add(rs.getString(3));
                    vetor.add(rs.getString(4));
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
        AvisoBuscaNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProd = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        IdProd = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        NomeProd = new javax.swing.JFormattedTextField();
        QtdProd = new javax.swing.JFormattedTextField();
        PrecoProd = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AdicionarBtn = new javax.swing.JButton();
        AttBtn = new javax.swing.JButton();
        DeletarBtn = new javax.swing.JButton();
        AvisoID = new javax.swing.JLabel();
        AvisoNome = new javax.swing.JLabel();
        AvisoQtd = new javax.swing.JLabel();
        AvisoPreco = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTOQUE DE PRODUTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel2.setText("BUSCAR PRODUTO");

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

        AvisoBuscaNome.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AvisoBuscaNome.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(BuscarBtn))
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
                                    .addComponent(AvisoBuscaNome, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(BuscarNome, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(BuscarID))))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AvisoBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(BuscarBtn)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        TabelaProd.setBackground(new java.awt.Color(255, 255, 255));
        TabelaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID PROD", "NOME", "QTD", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jLabel4.setText("ID PROD");

        IdProd.setBackground(new java.awt.Color(255, 255, 255));
        IdProd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        IdProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdProdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("NOME:");

        NomeProd.setBackground(new java.awt.Color(255, 255, 255));
        NomeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeProdActionPerformed(evt);
            }
        });

        QtdProd.setBackground(new java.awt.Color(255, 255, 255));
        QtdProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtdProdActionPerformed(evt);
            }
        });

        PrecoProd.setBackground(new java.awt.Color(255, 255, 255));
        PrecoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoProdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("QUANTIDADE:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("PREÇO:");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(AdicionarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(AttBtn)
                                .addGap(18, 18, 18)
                                .addComponent(DeletarBtn))
                            .addComponent(AvisoNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AvisoID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IdProd, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(NomeProd)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PrecoProd, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(QtdProd)
                            .addComponent(AvisoQtd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AvisoPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addComponent(AvisoID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AvisoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QtdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AvisoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AvisoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdicionarBtn)
                    .addComponent(AttBtn)
                    .addComponent(DeletarBtn))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(27, Short.MAX_VALUE))
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

    String nome, query, id, qtd = null, preco, codigo, buscaBD = null;
    String BDurl = "jdbc:MySQL://127.0.0.1:3306/estoque";
    String BDusuario = "root";
    String BDsenha = "";
    int nao_encontrado = 0;

    private void BuscarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNomeActionPerformed

    private void IdProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdProdActionPerformed

    private void NomeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeProdActionPerformed

    private void QtdProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtdProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtdProdActionPerformed

    private void PrecoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoProdActionPerformed

    private void BuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            st = con.createStatement();
            if ("".equals(BuscarNome.getText()) && "".equals(BuscarID.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Necessário inserir o nome ou ID do produto!", "Erro ao buscar!", JOptionPane.ERROR_MESSAGE);
            } else {
                if ("".equals(BuscarNome.getText())) {
                    codigo = BuscarID.getText();
                    query = "SELECT * FROM produtos WHERE id ='" + codigo + "'";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        buscaBD = rs.getString("id");
                        nao_encontrado = 1;
                        nome = rs.getString("nome");
                        qtd = rs.getString("quantidade");
                        preco = rs.getString("preço");
                        showMessageDialog(null, "ID: " + buscaBD + "\nNome: " + nome + "\nQuantidade: " + qtd + "\nPreço: R$" + preco);
                    }
                    if (!(nao_encontrado == 1 && codigo.equals(buscaBD))) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID não encontrado!", "Erro ao buscar!", JOptionPane.ERROR_MESSAGE);
                    }

                } else if ("".equals(BuscarID.getText())) {
                    codigo = BuscarNome.getText();
                    query = "SELECT * FROM produtos WHERE nome ='" + codigo + "'";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        buscaBD = rs.getString("nome");
                        nao_encontrado = 1;
                        id = rs.getString("id");
                        qtd = rs.getString("quantidade");
                        preco = rs.getString("preço");
                        showMessageDialog(null, "ID: " + id + "\nNome: " + buscaBD + "\nQuantidade: " + qtd + "\nPreço: R$" + preco);

                    }
                    if (!(nao_encontrado == 1 && codigo.equals(buscaBD))) {
                        JOptionPane.showMessageDialog(new JFrame(), "Nome não encontrado!", "Erro ao buscar!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                IdProd.setText("");
                NomeProd.setText("");
                QtdProd.setText("");
                PrecoProd.setText("");
                BuscarID.setText("");
                BuscarNome.setText("");
            }
            Tabela();
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_BuscarBtnActionPerformed

    private void AdicionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            st = con.createStatement();

            //MENSAGENS DE ERRO
            if ("".equals(IdProd.getText()) || (IdProd.getText().length() <= 0)) {
                AvisoID.setText("Insira um id válido!");
                AvisoNome.setText("");
                AvisoQtd.setText("");
                AvisoPreco.setText("");

            } else if ("".equals(NomeProd.getText()) || NomeProd.getText().length() <= 3) {
                AvisoID.setText("");
                AvisoNome.setText("Insira um nome válido!");
                AvisoQtd.setText("");
                AvisoPreco.setText("");

            } else if ("".equals(QtdProd.getText()) || QtdProd.getText().length() <= 0) {
                AvisoID.setText("");
                AvisoNome.setText("");
                AvisoQtd.setText("Insira uma quantidade válida!");
                AvisoPreco.setText("");

            } else if ("".equals(PrecoProd.getText()) || PrecoProd.getText().length() <= 0) {
                AvisoID.setText("");
                AvisoNome.setText("");
                AvisoQtd.setText("");
                AvisoPreco.setText("Insira um preço válido!");
            } else {
                id = IdProd.getText();
                nome = NomeProd.getText();
                qtd = QtdProd.getText();
                preco = PrecoProd.getText();

                //CONSULTA NO BANCO
                query = "SELECT * FROM produtos WHERE id ='" + id + "'";
                rs = st.executeQuery(query);
                while (rs.next()) {
                    buscaBD = rs.getString("id");
                    nao_encontrado = 1;
                }

                //VALIDAÇÃO DE DADOS
                if (nao_encontrado == 1 && id.equals(buscaBD)) {
                    JOptionPane.showMessageDialog(new JFrame(), "O ID DIGITADO JÁ ESTÁ SENDO UTILIZADO!", "Erro ao adicionar!", JOptionPane.ERROR_MESSAGE);
                    AvisoID.setText("Insira um id válido!");
                    IdProd.setText("");
                } else {
                    //INSERIR NO BANCO
                    query = "INSERT INTO produtos (id, nome, quantidade, preço)" + "VALUES('" + id + "', '" + nome + "', '" + qtd + "', '" + preco + "')";
                    st.execute(query);
                    IdProd.setText("");
                    NomeProd.setText("");
                    QtdProd.setText("");
                    PrecoProd.setText("");
                    showMessageDialog(null, "Produto adicionado com sucesso!");
                    AvisoID.setText("");
                    AvisoNome.setText("");
                    AvisoQtd.setText("");
                    AvisoPreco.setText("");
                }
                Tabela();
            }

        } catch (Exception e) {

            //ERRO NO CADASTRO DO PRODUTO E QUAL TIPO DE ERRO(MOSTRADO APENAS NO CONSOLE)
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_AdicionarBtnActionPerformed

    private void DeletarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            st = con.createStatement();

            //ID VAZIO
            if (IdProd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Insira apenas o ID do produto que deseja deletar!", "Erro ao deletar!", JOptionPane.ERROR_MESSAGE);
            } else {

                //CONSULTA NO BANCO
                id = IdProd.getText();
                query = "SELECT * FROM produtos WHERE id ='" + id + "'";
                rs = st.executeQuery(query);
                while (rs.next()) {
                    buscaBD = rs.getString("id");
                    nao_encontrado = 1;
                }
                if (nao_encontrado == 1 && id.equals(buscaBD)) {
                    query = "DELETE FROM estoque.produtos WHERE id =" + id;
                    st.execute(query);
                    showMessageDialog(null, "Produto deletado com sucesso!");
                    IdProd.setText("");
                    NomeProd.setText("");
                    QtdProd.setText("");
                    PrecoProd.setText("");
                    AvisoID.setText("");
                    AvisoNome.setText("");
                    AvisoQtd.setText("");
                    AvisoPreco.setText("");

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Produto não encontrado!", "Erro ao deletar!", JOptionPane.ERROR_MESSAGE);
                }
                Tabela();

            }
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_DeletarBtnActionPerformed

    private void AttBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttBtnActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(BDurl, BDusuario, BDsenha);
            st = con.createStatement();
            if (IdProd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Insira apenaso ID do produto que deseja atualizar as informações!", "Erro ao atualizar!", JOptionPane.ERROR_MESSAGE);
            } else {
                id = IdProd.getText();
                //CONSULTA NO BANCO
                query = "SELECT * FROM produtos WHERE id ='" + id + "'";
                rs = st.executeQuery(query);
                while (rs.next()) {
                    buscaBD = rs.getString("id");
                    nao_encontrado = 1;
                }

                //VALIDAÇÃO DE DADOS
                if (nao_encontrado == 1 && id.equals(buscaBD)) {

                    //ATUALIZAÇÃO DE NOME
                    if (!NomeProd.getText().isEmpty()) {
                        nome = NomeProd.getText();
                        query = "UPDATE produtos SET nome = '" + nome + "' WHERE id = '" + id + "'";
                        st.execute(query);

                        //ATUALIZAÇÃO DE QUANTIDADE
                    } else if (!QtdProd.getText().isEmpty()) {
                        qtd = QtdProd.getText();
                        query = "UPDATE produtos SET quantidade = '" + qtd + "' WHERE id = '" + id + "'";
                        st.execute(query);

                        //ATUALIZAÇÃO DE PREÇO
                    } else if (!PrecoProd.getText().isEmpty()) {
                        preco = PrecoProd.getText();
                        query = "UPDATE produtos SET preço = '" + preco + "' WHERE id = '" + id + "'";
                        st.execute(query);
                    }
                    IdProd.setText("");
                    NomeProd.setText("");
                    QtdProd.setText("");
                    PrecoProd.setText("");
                    AvisoID.setText("");
                    AvisoNome.setText("");
                    AvisoQtd.setText("");
                    AvisoPreco.setText("");
                    Tabela();

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Produto não encontrado na base de dados!", "Erro ao atualizar!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }//GEN-LAST:event_AttBtnActionPerformed

    private void BuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarIDActionPerformed

    }//GEN-LAST:event_BuscarIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarBtn;
    private javax.swing.JButton AttBtn;
    private javax.swing.JLabel AvisoBuscaNome;
    private javax.swing.JLabel AvisoID;
    private javax.swing.JLabel AvisoNome;
    private javax.swing.JLabel AvisoPreco;
    private javax.swing.JLabel AvisoQtd;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JFormattedTextField BuscarID;
    private javax.swing.JFormattedTextField BuscarNome;
    private javax.swing.JButton DeletarBtn;
    private javax.swing.JFormattedTextField IdProd;
    private javax.swing.JFormattedTextField NomeProd;
    private javax.swing.JFormattedTextField PrecoProd;
    private javax.swing.JFormattedTextField QtdProd;
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
