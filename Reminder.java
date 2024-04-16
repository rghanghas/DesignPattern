package PTBS;

// Facade and Visitor Design Pattern

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Reminder extends JDialog {

    private static final long serialVersionUID = 1L;
    ClassProductList productListList;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    java.awt.List listUpcoming = new java.awt.List();
    java.awt.List listOverDue = new java.awt.List();
    Button buttonSet = new Button();

    public Reminder() {
        try {
            jbInit();
            setModal(true);
            setSize(400, 386);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Upcoming Trading Window");
        jLabel1.setBounds(new Rectangle(38, 40, 159, 17));
        this.getContentPane().setLayout(null);
        jLabel2.setText("Over Due Trading Window");
        jLabel2.setBounds(new Rectangle(39, 160, 161, 17));
        listUpcoming.setBounds(new Rectangle(29, 65, 340, 79));
        listOverDue.setBounds(new Rectangle(31, 187, 337, 85));
        buttonSet.setLabel("SET");
        buttonSet.setBounds(new Rectangle(149, 308, 67, 37));
        buttonSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSetActionPerformed(e);
            }
        });
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(listUpcoming, null);
        this.getContentPane().add(listOverDue, null);
        this.getContentPane().add(buttonSet, null);
    }

    void showReminder(ClassProductList courseList) {
        ReminderVisitor visitor = new ReminderVisitor(this);
        visitor.visitFacade(Ptbs.facade);
        setVisible(true);
    }

    void buttonSetActionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
