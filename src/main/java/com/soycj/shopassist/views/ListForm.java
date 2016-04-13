package com.soycj.shopassist.views;

import com.soycj.shopassist.DAO.ItemDAO;
import com.soycj.shopassist.models.Items;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListForm extends javax.swing.JFrame {
    
    private final ArrayList<Items> itemList;
    private final String [] columnName = {"","","ID"};
    private DefaultTableModel model = new DefaultTableModel(columnName,0)
    {
        @Override
        public Class getColumnClass(int column)
        {
            return column == 1 ? Boolean.class : String.class;
        }
    };
    private final ItemDAO itemDAO = new ItemDAO();
       
    public ListForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        itemList = new ArrayList(itemDAO.findItemsEntities());
        for(Items i : itemList)
            model.addRow(new Object[]{i.getName(), Boolean.FALSE, itemList.indexOf(i)});
        itemTable.removeColumn(itemTable.getColumn("ID"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEnd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de compras");

        btnEnd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEnd.setText("Confirmar lista de compras");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });

        itemTable.setModel(model);
        jScrollPane1.setViewportView(itemTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Selecciones los artículos deseados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnEnd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnEnd)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
    
        ArrayList<Items> selectedItem = new ArrayList();
        String position = "";
        
        for(int i = 0; i < model.getRowCount(); i++)
        {
            if((boolean)model.getValueAt(i, 1))
                selectedItem.add(
                        itemList.get((int)model.getValueAt(i, 2))
                );
        }
        
        for (Items i:selectedItem )          
           position += i.getName() + " - en el pasillo: " + i.getPosition()+"\n";
        
        JOptionPane.showMessageDialog(this, position, "Lista de artículos", JOptionPane.INFORMATION_MESSAGE);
        
        new SalesForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEndActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnd;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
