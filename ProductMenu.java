package PTBS;

// Factory Design Pattern

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;

abstract public class ProductMenu extends JDialog {

    private static final long serialVersionUID = 1L;
    Product theProduct;
    boolean bLogout = true;

    JRadioButton tradingRadio = new JRadioButton();
    JComboBox<Object> tradingCombox = new JComboBox<Object>();
    JButton tradingViewButton = new JButton();
    JButton tradingAddButton = new JButton();
    JRadioButton optionRadio = new JRadioButton();
    JLabel tradingContentLable = new JLabel();
    JComboBox<Object> optionCombo = new JComboBox<Object>();
    JButton optionViewButton = new JButton();
    JButton optionAddButton = new JButton();
    JButton buttonChangeProduct = new JButton();
    JButton buttonLogout = new JButton();

    public ProductMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setModal(true);
        setSize(503, 294);
    }

    private void jbInit() throws Exception {
        buttonChangeProduct.setText("ChangeProduct");
        buttonChangeProduct.setBounds(new Rectangle(101, 211, 73, 37));
        buttonChangeProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonChangeProductActionPerformed(e);
            }
        });
        this.getContentPane().setLayout(null);
        this.setTitle("");
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonLogoutActionPerformed(e);
            }
        });
        this.getContentPane().add(buttonChangeProduct, null);
        this.getContentPane().add(buttonLogout, null);
    }

    abstract void showMenu(Product theProduct);

    abstract void showAddButton();

    abstract void showViewButton();

    abstract void showRadioButton();

    abstract void showLabels();

    abstract void showComboxes();

    void tradingAddButtonActionPerformed(ActionEvent e) {
        Ptbs.facade.addTrading(theProduct);
        refresh();
    }

    void tradingViewButtonActionPerformed(ActionEvent e) {
        Trading theTrade = (Trading) tradingCombox.getSelectedItem();
        Ptbs.facade.viewTrading(theTrade);
    }

    void refresh() {
        tradingCombox.removeAllItems();
        Iterator<?> Iter = theProduct.tradingList.iterator();
        while (Iter.hasNext()) {
            tradingCombox.addItem(Iter.next());
        }
    }

    void buttonChangeProductActionPerformed(ActionEvent e) {
        bLogout = false;
        setVisible(false);
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        bLogout = true;
        setVisible(true);
    }

    boolean ifLogout() {
        return bLogout;
    }

}
