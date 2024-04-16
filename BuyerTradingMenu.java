package PTBS;

// Facade Design Pattern

import java.awt.Rectangle;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class BuyerTradingMenu extends TradingMenu {

    private static final long serialVersionUID = 1L;
    private boolean boolSubmit = false;
    private Offering theOffering;
    private Trading theTrading;

    JLabel lTradingName = new JLabel();
    JLabel lDueDate = new JLabel();
    JTextField tbOffering = new JTextField();
    JLabel lExpectedOffering = new JLabel();
    JLabel lbid = new JLabel();
    JButton bSubmit = new JButton();
    JButton bCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();

    public BuyerTradingMenu() {
        try{
            jbInit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Trading : ");
        jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
        this.getContentPane().setLayout(null);
        lTradingName.setText("jLabel2");
        lTradingName.setBounds(new Rectangle(258, 35, 282, 18));
        jLabel3.setText("Due Date");
        jLabel3.setBounds(new Rectangle(21, 81, 92, 18));
        lDueDate.setText("jLabel4");
        lDueDate.setBounds(new Rectangle(254, 82, 294, 18));
        jLabel5.setText("Offering");
        jLabel5.setBounds(new Rectangle(24, 128, 93, 18));
        tbOffering.setText("jTextField1");
        tbOffering.setBounds(new Rectangle(251, 127, 211, 22));
        jLabel6.setText("Expected Offering");
        jLabel6.setBounds(new Rectangle(24, 174, 117, 18));
        jLabel7.setText("bid");
        jLabel7.setBounds(new Rectangle(23, 224, 41, 18));
        lExpectedOffering.setText("jLabel8");
        lExpectedOffering.setBounds(new Rectangle(259, 169, 201, 18));
        lbid.setText("jLabel9");
        lbid.setBounds(new Rectangle(258, 226, 41, 18));
        bSubmit.setText("Submit");
        bSubmit.setBounds(new Rectangle(476, 124, 79, 29));
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bSubmitActionPerformed(e);
            }
        });
        bCancel.setText("Cancel");
        bCancel.setBounds(new Rectangle(475, 164, 79, 29));
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bCancelActionPerformed(e);
            }
        });
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(lTradingName, null);
        this.getContentPane().add(lDueDate, null);
        this.getContentPane().add(tbOffering, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(lExpectedOffering, null);
        this.getContentPane().add(lbid, null);
        this.getContentPane().add(bSubmit, null);
        this.getContentPane().add(bCancel, null);
    }

    public void showMenu(Trading trading, Person thePerson) {
        theTrading = trading;
        OfferingIterator theIter = theTrading.getOfferingIterator();
        theOffering = (Offering) theIter.next(thePerson.userName);
        if(theOffering == null){
            tbOffering.setText("");
            lbid.setText("-1");
        }
        else{
            tbOffering.setText(theOffering.offeringFileName);
            lbid.setText(theOffering.getBidString());
        }
        lTradingName.setText(theTrading.tradingName);
        lDueDate.setText(theTrading.dueDate.toString());
        lExpectedOffering.setText(theTrading.expectedOffering.offeringFileName);

        setVisible(true);

        if(boolSubmit == true) {
            if(theOffering == null){
                theOffering = new Offering();
                theTrading.addOffering(theOffering);
            }
            theOffering.theBuyer = thePerson.userName;
            theOffering.offeringFileName = tbOffering.getText();
            theOffering.theSubmitDate = new Date();
        }
    }

    void bSubmitActionPerformed(ActionEvent e) {
        boolSubmit = true;
        setVisible(false);
    }

    void bCancelActionPerformed(ActionEvent e) {
        boolSubmit = false;
        setVisible(false);
    }
}
