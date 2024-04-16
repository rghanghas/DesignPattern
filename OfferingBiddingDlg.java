package PTBS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OfferingBiddingDlg extends JDialog {

    private static final long serialVersionUID = 1L;
    Offering theOffering;
    JLabel jLabel1 = new JLabel();
    JTextField tfBid = new JTextField();
    JButton buttonSet = new JButton();
    JLabel labelOfferingFileName = new JLabel();

    public OfferingBiddingDlg() {
        try{
            jbInit();
            setSize(316, 186);
            setModal(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Offering File Name");
        jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
        this.getContentPane().setLayout(null);
        tfBid.setBounds(new Rectangle(25, 66, 100, 22));
        buttonSet.setText("SET");
        buttonSet.setBounds(new Rectangle(217, 67, 79, 29));
        buttonSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                buttonSetActionPerformed(e);
            }
        });
        labelOfferingFileName.setBounds(new Rectangle(212, 34, 163, 18));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tfBid, null);
        this.getContentPane().add(labelOfferingFileName, null);
        this.getContentPane().add(buttonSet, null);
    }

    void show(Offering offering){
        theOffering = offering;
        tfBid.setText("" + theOffering.getBidInt());
        labelOfferingFileName.setText(theOffering.offeringFileName);
        setVisible(true);
    }

    void buttonSetActionPerformed(ActionEvent e){
        theOffering.theBid = Integer.parseInt(tfBid.getText());
        setVisible(false);
    }

}
