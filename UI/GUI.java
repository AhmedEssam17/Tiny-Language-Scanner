package User_Interface;
import TINY_Lang_Scanner.Junior_Scanner;
import javax.swing.table.DefaultTableModel;
public class GUI extends javax.swing.JFrame {
    public GUI() {
        initComponents();
        scannerComp = new Junior_Scanner();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        srcArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableofTokens = new javax.swing.JTable();
        StartScanningBTN = new javax.swing.JButton();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        srcArea.setBackground(new java.awt.Color(0, 0, 0));
        srcArea.setColumns(20);
        srcArea.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        srcArea.setForeground(new java.awt.Color(255, 255, 255));
        srcArea.setRows(5);
        srcArea.setText("Enter The Code to be Scanned....");
        srcArea.setSelectionColor(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(srcArea);

        TableofTokens.setBackground(new java.awt.Color(0, 0, 0));
        TableofTokens.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        TableofTokens.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        TableofTokens.setForeground(new java.awt.Color(255, 255, 255));
        TableofTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token Type", "Token"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableofTokens.setToolTipText("");
        TableofTokens.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane2.setViewportView(TableofTokens);

        StartScanningBTN.setBackground(new java.awt.Color(0, 0, 0));
        StartScanningBTN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        StartScanningBTN.setForeground(new java.awt.Color(255, 255, 255));
        StartScanningBTN.setText("Start Scanning");
        StartScanningBTN.setToolTipText("Scan Tiny Language Source Code");
        StartScanningBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StartScanningBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartScanningBTNActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setName(""); // NOI18N
        label1.setText("ASU - Scanner 2021 - CESS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartScanningBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(377, 377, 377))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StartScanningBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(882, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartScanningBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartScanningBTNActionPerformed
        DefaultTableModel Scanner = (DefaultTableModel) TableofTokens.getModel();
        for (String Input_String : srcArea.getText().split("\\n"))
        {Junior_Scanner.Scanning(Input_String);}
        for(int i=0; i<Junior_Scanner.Tokens_List.size(); i++)
        {
            String Type_Token = Junior_Scanner.Tokens_List.get(i).Token_Type;
            String Value_Token = Junior_Scanner.Tokens_List.get(i).Token_Val;
            Scanner.addRow(new String[] {Type_Token, Value_Token}); }
    }//GEN-LAST:event_StartScanningBTNActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            scannerComp = new Junior_Scanner();
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StartScanningBTN;
    private javax.swing.JTable TableofTokens;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JTextArea srcArea;
    // End of variables declaration//GEN-END:variables
    public static Junior_Scanner scannerComp; 
}
