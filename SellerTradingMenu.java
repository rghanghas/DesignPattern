package PTBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

public class SellerTradingMenu extends TradingMenu {

    private static final long serialVersionUID = 1L;
    private Offering theOffering;
    private Trading theTrading;
    JComboBox<Offering> comboBoxOfferingList = new JComboBox<Offering>();

    JTextField tbTradingName = new JTextField();
    JTextField tbDueDate = new JTextField();
    JTextField tbExpectedOffering = new JTextField();

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JButton buttonBid = new JButton();
    JButton buttonMark = new JButton();
    JButton buttonClose = new JButton();

    public SellerTradingMenu() {
        try{
            jbInit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Trading Name");
        jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
        this.getContentPane().setLayout(null);
        tbTradingName.setText("jTextField1");
        tbTradingName.setBounds(new Rectangle(192, 31, 341, 22));
        jLabel2.setText("Due Date");
        jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
        tbDueDate.setText("tbDueDate");
        tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
        jLabel3.setText("Expected Offering");
        jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
        tbExpectedOffering.setText("jTextField2");
        tbExpectedOffering.setBounds(new Rectangle(197, 149, 339, 22));
        buttonBid.setText("Bid");
        buttonBid.setBounds(new Rectangle(458, 199, 79, 29));
        buttonBid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonBidActionPerformed(e);
            }
        });
        buttonMark.setText("Mark");
        buttonMark.setBounds(new Rectangle(365, 249, 79, 29));
        buttonMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonReportActionPerformed(e);
            }
        });
        buttonClose.setText("Close");
        buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCloseActionPerformed(e);
            }
        });
        comboBoxOfferingList.setBounds(new Rectangle(32, 204, 413, 22));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tbTradingName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(tbDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(tbExpectedOffering, null);
        this.getContentPane().add(buttonClose, null);
        this.getContentPane().add(comboBoxOfferingList, null);
        this.getContentPane().add(buttonBid, null);
        this.getContentPane().add(buttonMark, null);
    }

    public void showMenu(Trading trading, Person person) {
        theTrading = trading;
        tbTradingName.setText(theTrading.tradingName);
        DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        tbDueDate.setText(theDateFormat.format(theTrading.dueDate));
        tbExpectedOffering.setText(theTrading.expectedOffering.offeringFileName);
        refreshOfferingList();
        setVisible(true);
    }

    void buttonCloseActionPerformed(ActionEvent e) {
        theTrading.tradingName = tbTradingName.getText();
        DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        try {
            theTrading.dueDate = tempDateFormat.parse(tbDueDate.getText());
        } catch (Exception ee) {
        }
        ;
        theTrading.expectedOffering.offeringFileName = tbExpectedOffering.getText();
        setVisible(false);
    }

    void buttonBidActionPerformed(ActionEvent e) {
        Offering theOffering = (Offering) comboBoxOfferingList.getSelectedItem();
        if (theOffering == null)
            return;
        OfferingBiddingDlg dlg = new OfferingBiddingDlg();
        dlg.show(theOffering);
        refreshOfferingList();
    }

    void buttonReportActionPerformed(ActionEvent e) {
        OfferingIterator iter = new OfferingIterator(theTrading.theOfferingList);
        while (iter.hasNext()) {
            Offering aOffering = (Offering) iter.next();
            aOffering.setMarked(true);
        }
        refreshOfferingList();
    }

    private void refreshOfferingList() {
        comboBoxOfferingList.removeAllItems();
        OfferingIterator solIter = new OfferingIterator(theTrading.theOfferingList);
        while (solIter.hasNext()) {
            theOffering = (Offering) solIter.next();
            comboBoxOfferingList.addItem(theOffering);
        }
    }

}
