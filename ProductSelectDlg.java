package PTBS;

// Facade Design Pattern

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductSelectDlg extends JDialog {

    private static final long serialVersionUID = 1L;

    ClassProductList theProductList;
    Product selectedProduct;
    int productCategory = 0;
    boolean mBLogout = false;
    JComboBox<Product> ProductNameComboBox = new JComboBox<Product>();
    JRadioButton meatProductRadio = new JRadioButton();
    JRadioButton produceProductRadio = new JRadioButton();
    JLabel jLabel1 = new JLabel();
    JButton okButton = new JButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JButton buttonLogout = new JButton();

    public ProductSelectDlg() {
        try {
            jbInit();
            setSize(420, 238);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        ProductNameComboBox.setBounds(new Rectangle(155, 41, 203, 22));
        meatProductRadio.setText("Meat Product");
        meatProductRadio.setBounds(new Rectangle(50, 87, 103, 26));
        produceProductRadio.setToolTipText("");
        produceProductRadio.setSelected(true);
        produceProductRadio.setText("Produce Product");
        produceProductRadio.setBounds(new Rectangle(236, 88, 103, 26));
        jLabel1.setText("ProductName");
        jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
        okButton.setText("OK");
        okButton.setBounds(new Rectangle(78, 139, 79, 29));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButtonActionPerformed(e);
            }
        });
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonLogoutActionPerformed(e);
            }
        });
        this.getContentPane().add(ProductNameComboBox, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(meatProductRadio, null);
        this.getContentPane().add(produceProductRadio, null);
        this.getContentPane().add(okButton, null);
        this.getContentPane().add(buttonLogout, null);
        buttonGroup1.add(meatProductRadio);
        buttonGroup1.add(produceProductRadio);
    }

    /*
     * show the theProductList in a combox Show the Product type selection button
     * return the pointer pointing to the Product object return the Product Type
     */

    public Product showDlg(ClassProductList ProductList) {
        theProductList = ProductList;
        ProductIterator theIterator = new ProductIterator(theProductList);
        Product theProduct;
        while ((theProduct = (Product) theIterator.next()) != null)
        {
            ProductNameComboBox.addItem(theProduct);
        }
        setVisible(true);
        return selectedProduct;
    }

    void okButtonActionPerformed(ActionEvent e) {
        selectedProduct = (Product) ProductNameComboBox.getSelectedItem();
        if (meatProductRadio.isSelected())
            productCategory = 0;
        else
            productCategory = 1;
        setVisible(false);
    }

    public boolean isLogout() {
        return mBLogout;
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        mBLogout = true;
        setVisible(false);
    }

}
