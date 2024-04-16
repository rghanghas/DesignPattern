package PTBS;

// Bridge & Factory Design Pattern

import java.awt.*;
import java.awt.event.ActionEvent;

public class ProduceProductMenu extends ProductMenu {

    private static final long serialVersionUID = 1L;

    public ProduceProductMenu() {
        System.out.println("Produce Product Menu Implemented");
    }

    void showMenu(Product theProduct){
        showViewButton();
        showRadioButton();
        showComboxes();
        setVisible(true);
    }

    void showAddButton(){
        tradingAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tradingAddButtonActionPerformed(e);
            }
        });
        tradingAddButton.setText("Add");
        tradingAddButton.setBounds(new Rectangle(389, 54, 79, 29));
        optionAddButton.setText("Add");
        optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
        this.getContentPane().add(tradingAddButton, null);
        this.getContentPane().add(optionAddButton, null);
    }

    void showViewButton(){
        tradingViewButton.setText("View");
        tradingViewButton.setBounds(new Rectangle(290, 54, 79, 29));
        tradingViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tradingViewButtonActionPerformed(e);
            }
        });
        optionViewButton.setText("View");
        optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
        this.getContentPane().add(tradingViewButton, null);
        this.getContentPane().add(optionViewButton, null);
    }

    void showRadioButton(){
        tradingRadio.setText("Trading");
        tradingRadio.setBounds(new Rectangle(21, 55, 103, 26));
        this.getContentPane().add(tradingRadio, null);
        optionRadio.setText("Produce Product Presentation");
        optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
        this.getContentPane().add(optionRadio, null);
    }

    void showLabels(){
        tradingContentLable.setText("TradingContent");
        tradingContentLable.setBounds(new Rectangle(23, 186, 432, 99));
        this.getContentPane().add(tradingContentLable, null);
    }

    void showComboxes(){
        tradingCombox.setBounds(new Rectangle(140, 57, 126, 22));
        optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
        this.getContentPane().add(tradingCombox, null);
        this.getContentPane().add(optionCombo, null);
        refresh();
    }

}
