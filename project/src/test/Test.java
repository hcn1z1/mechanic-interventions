/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package test;

/**
 *
 * @author LENOVO IP330
 */
public class Test extends javax.swing.JPanel {

    /**
     * Creates new form divEmp
     */
    public Test() {
        initComponents();
    }                     
    private void initComponents() {

        eName = new java.awt.Label();
        eLName = new java.awt.Label();
        eID = new java.awt.Label();
        eINV = new java.awt.Label();
        eSal = new java.awt.Label();
        eCAT = new java.awt.Label();

        setBackground(new java.awt.Color(34, 36, 42));
        setForeground(new java.awt.Color(255, 255, 255));
        setToolTipText("");

        eName.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        eName.setForeground(new java.awt.Color(255, 255, 255));
        eName.setText("eName");

        eLName.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        eLName.setForeground(new java.awt.Color(255, 255, 255));
        eLName.setText("eName");

        eID.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        eID.setForeground(new java.awt.Color(255, 255, 255));
        eID.setText("eName");

        eINV.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        eINV.setForeground(new java.awt.Color(255, 255, 255));
        eINV.setText("eName");

        eSal.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        eSal.setForeground(new java.awt.Color(255, 255, 255));
        eSal.setText("eName");

        eCAT.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        eCAT.setForeground(new java.awt.Color(255, 255, 255));
        eCAT.setText("eName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(eLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(eName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(eID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(eINV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(eCAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(eSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eINV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private java.awt.Label eCAT;
    private java.awt.Label eID;
    private java.awt.Label eINV;
    private java.awt.Label eLName;
    private java.awt.Label eName;
    private java.awt.Label eSal;
    // End of variables declaration                   
}
