package PTBS;

// Facade Design Pattern

import javax.swing.*;

abstract public class TradingMenu extends JDialog {

    private static final long serialVersionUID = 1L;

    abstract void showMenu(Trading trading, Person person);

    public TradingMenu() {
        setModal(true);
        setSize(575, 330);
    }

}
