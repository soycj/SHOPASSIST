package com.soycj.shopassist.views;

import com.soycj.shopassist.DAO.ItemDAO;
import com.soycj.shopassist.models.Items;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class SalesForm extends javax.swing.JFrame {

    private double subtotal = 0.0;
    private final HashMap<Items, Integer> itemList;
    private final String [] columnName = {"Código", "Producto", "Precio","Pasillo", "Cantidad"};
    private final DefaultTableModel model = new DefaultTableModel(columnName,0);
    private final ItemDAO itemDAO = new ItemDAO();
       
    private void clearProductInfo()
    {
        this.lblName.setText("");
        this.lblDescription.setText("");
        this.lblPrice.setText("");
        this.spQuantity.setValue(1);
    }
    
    private void refreshList()
    {
        this.model.setRowCount(0);
        this.spQuantity.setValue(1);
    }
    
    private void refreshSubtotal()
    {
        this.model.setRowCount(0);
        this.subtotal = 0.0;
        for(Map.Entry<Items, Integer> iterator : itemList.entrySet())
        {
            //el iterator es el que va a recorrer la lista de los productos
            
            this.model.addRow(
                    new Object[]
                    {
                        iterator.getKey().getCode(),
                        iterator.getKey().getName(), 
                        iterator.getKey().getUnitPrice().toPlainString(),
                        iterator.getKey().getPosition(),
                        iterator.getValue()
                    });
            
            this.subtotal+= (
                    iterator.getKey().getUnitPrice().doubleValue() //precio
                    +(iterator.getKey().getUnitPrice().doubleValue() //precio por impuesto
                    *(iterator.getKey().getTaxRate().doubleValue())
                ))*iterator.getValue();
        }
        this.lblSubtotal.setText(String.format("$%.02f", subtotal));
    }
    
    private void removeProduct(Items item)
    {
        if(itemList.containsKey(item))
        {
            Integer quantity = itemList.get(item);
            if(quantity - Integer.valueOf(spQuantity.getValue().toString()) < 1)
                itemList.remove(item);
            else
                itemList.put(item, quantity - Integer.valueOf(spQuantity.getValue().toString()));
        }
        else
        {
            itemList.remove(item);
        }
        refreshList();
        this.lblName.setText(item.getName());
        this.lblDescription.setText(item.getDescription());
        this.lblPrice.setText(String.format("-$%.02f", item.getUnitPrice().doubleValue()));
        refreshSubtotal();
    }
    
    private void addProduct(Items item)
    {
        if(itemList.containsKey(item))
        {
            Integer quantity = itemList.get(item);
            itemList.put(item, quantity + Integer.valueOf(spQuantity.getValue().toString()));
        }
        else
        {
            itemList.put(item,Integer.valueOf(spQuantity.getValue().toString()));
        }
        refreshList();
        this.lblName.setText(item.getName());
        this.lblDescription.setText(item.getDescription());
        this.lblPrice.setText(String.format("$%.02f", item.getUnitPrice().doubleValue()));
        refreshSubtotal();
    }
    
    private void clearTable()
    {
        this.model.setRowCount(0);
        this.subtotal = 0.0;
        this.itemList.clear();
        this.chRemover.doClick();
        clearProductInfo();
        refreshSubtotal();
    }
    
    public SalesForm() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        txtCode.requestFocusInWindow();
        itemList = new HashMap();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        spQuantity = new javax.swing.JSpinner();
        chRemover = new javax.swing.JCheckBox();
        btnCompare = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shop Assist");

        btnClear.setText("Limpiar");
        btnClear.setName(""); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        itemTable.setModel(model);
        jScrollPane1.setViewportView(itemTable);

        jLabel1.setText("Nombre del Producto:");

        jLabel2.setText("Descripción:");

        jLabel3.setText("Cantidad:");

        jLabel4.setText("Precio unidad:");

        jLabel5.setText("Subtotal:");

        lblSubtotal.setText("0");

        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
        });

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        spQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spQuantity.setToolTipText("");
        spQuantity.setDoubleBuffered(true);
        spQuantity.setNextFocusableComponent(txtCode);
        spQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQuantityStateChanged(evt);
            }
        });

        chRemover.setText("Remover Artículo");
        chRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chRemoverActionPerformed(evt);
            }
        });

        btnCompare.setText("Comparar Artículos");
        btnCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubtotal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPrice))
                                    .addComponent(txtCode)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDescription))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chRemover)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(79, 79, 79))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnCompare)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblName))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblDescription))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblPrice))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(chRemover))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblSubtotal))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnCompare))
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearTable();
        txtCode.requestFocusInWindow();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Items i = itemDAO.findByCode(txtCode.getText().trim());
            if(!chRemover.isSelected())
                this.addProduct(i);
            else 
                this.removeProduct(i);
        }catch(Exception e){
            clearProductInfo();
            this.lblName.setText("Producto no encontrado!");
        }
        finally
        {
            txtCode.setText("");
            txtCode.requestFocusInWindow();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar() == KeyEvent.VK_ENTER)
        {
            try
            {
                Items i = itemDAO.findByCode(txtCode.getText().trim());
                if(!chRemover.isSelected())
                    this.addProduct(i);
                else 
                    this.removeProduct(i);
            }
            catch(Exception e)
            {
                clearProductInfo();
                this.lblName.setText("Producto no encontrado!");
            }
            finally
            {
                txtCode.setText("");
                txtCode.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtCodeKeyPressed

    private void spQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQuantityStateChanged
        txtCode.requestFocusInWindow();
    }//GEN-LAST:event_spQuantityStateChanged

    private void chRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chRemoverActionPerformed
        // TODO add your handling code here:
        txtCode.requestFocusInWindow();
    }//GEN-LAST:event_chRemoverActionPerformed

    private void btnCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompareActionPerformed
        new ItemsCompareForm().setVisible(true);
    }//GEN-LAST:event_btnCompareActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCompare;
    private javax.swing.JCheckBox chRemover;
    private javax.swing.JTable itemTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
