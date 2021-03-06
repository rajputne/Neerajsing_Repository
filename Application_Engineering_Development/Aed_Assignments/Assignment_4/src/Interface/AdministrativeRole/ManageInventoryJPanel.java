/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.AdministrativeRole;

import Business.Drug;
import Business.DrugCatalog;
import Business.DrugItem;
import Business.Pharma;
import Business.PharmaDirectory;
import Business.Store;
import Business.Stores;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Neerajsing Rajput
 */
public class ManageInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageInventoryJPanel
     */
    JPanel userProcessContainer;
    Stores stores;
    Store store;
    DrugCatalog drugCatalog;
    PharmaDirectory pharmaDirectory;
    private static final int SUBTRACT = -1;
    private static final int ADD = 1;

    public ManageInventoryJPanel(JPanel upc, Store s, PharmaDirectory pd) {
        initComponents();
        userProcessContainer = upc;
        store = s;
        pharmaDirectory = pd;
        populatePharmaComboBox();

    }

    public void populatePharmaComboBox() {
        storeBoxPharma.removeAllItems();
        for (Pharma pharma : pharmaDirectory.getPharmaList()) {
            storeBoxPharma.addItem(pharma);
        }
    }

    public void populateDrugCatalogAsPharma() {
        DefaultTableModel dtm = (DefaultTableModel) tblDrugCatalog.getModel();
        dtm.setRowCount(0);

        Pharma pharma = (Pharma) storeBoxPharma.getSelectedItem();

        if (pharma != null) {
            for (Drug drug : pharma.getDrugCatalog().getDrugList()) {
                Object[] row = createRow(drug);
                dtm.addRow(row);
            }
        }
    }

    private Object[] createRow(Drug drug) {
        Object[] row = new Object[5];
        row[0] = drug;
        row[1] = drug.getAvailNum();
        row[2] = drug.getPrice();
        row[3] = drug.getMfgDate();
        row[4] = drug.getExpiryDate();
        return row;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblStoreLocation = new javax.swing.JLabel();
        storeBoxPharma = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDrugCatalog = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();
        jScrollPane5 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStoreLocation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(lblStoreLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 23, -1, -1));

        storeBoxPharma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(storeBoxPharma, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 69, 181, -1));

        jLabel1.setText("Pharma");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 72, -1, -1));

        tblDrugCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Drug Name", "Avail Number", "Price", "MFG Date", "Expiry Date"
            }
        ));
        jScrollPane4.setViewportView(tblDrugCatalog);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 141, 410, 90));

        jButton1.setText("Select Pharmacy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jButton6.setText("Add to Inventory");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 262, -1, -1));
        add(quantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 263, 141, -1));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Drug", "Quantity"
            }
        ));
        jScrollPane5.setViewportView(orderTable);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 326, -1, 90));

        jButton2.setText("<<back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Manage Inventory for Store");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 29, -1, -1));

        jButton3.setText("<<back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        populateDrugCatalogAsPharma();
    }//GEN-LAST:event_jButton1ActionPerformed
    private Object selectedItemInTable(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Object object = table.getValueAt(selectedRow, 0);
            return object;
        } else {
            JOptionPane.showMessageDialog(null, "No item selected");
            return null;
        }
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        Drug drug = (Drug) selectedItemInTable(tblDrugCatalog);
        int quantity = (Integer) quantitySpinner.getValue();
        if (drug != null && isAvailable(drug, quantity)) {
            addToOrder(drug, quantity);
            updateQuantity(drug, quantity, SUBTRACT);
            populateOrderTable();
            populateDrugCatalogAsPharma();
        } else {
            JOptionPane.showMessageDialog(null, "Wrong quantity or price");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed
    private boolean isAvailable(Drug drug, int quantity) {
        return (quantity > 0) && (quantity <= drug.getAvailNum());
    }

    private void addToOrder(Drug drug, int quantity) {
        DrugItem orderitem = store.getInventory().searchOrderItemByProduct(drug);
        if (orderitem != null) {
            orderitem.setQuantity(orderitem.getQuantity() + quantity);
        } else {
            //int sellPrice = parseInput(txtSalesPrice.getText());
            store.getInventory().addOrderItem(drug, quantity);
        }
    }

    private void updateQuantity(Drug drug, int quantity, int flag) {
        if (flag == SUBTRACT) {
            int newAmount = drug.getAvailNum() - quantity;
            drug.setAvailNum(newAmount);
        } else {
            int newAmount = drug.getAvailNum() + quantity;
            drug.setAvailNum(newAmount);
        }
    }

    private void populateOrderTable() {
        DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
        dtm.setRowCount(0);

        for (DrugItem orderitem : store.getInventory().getDrugItemList()) {
            Object[] row = new Object[2];
            row[0] = orderitem;
            row[1] = orderitem.getQuantity();
            dtm.addRow(row);
        }
    }

    private int parseInput(String inputNum) {
        try {
            int num = Integer.parseInt(inputNum);
            return num;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Format");
            return -1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblStoreLocation;
    private javax.swing.JTable orderTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JComboBox storeBoxPharma;
    private javax.swing.JTable tblDrugCatalog;
    // End of variables declaration//GEN-END:variables
}
