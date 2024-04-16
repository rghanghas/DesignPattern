package PTBS;

// Facade Design Pattern

import javax.swing.*;

public class OfferingMenu extends JDialog {

    private static final long serialVersionUID = 1L;

    public OfferingMenu() {
        System.out.println("Offering Menu Implemented");
    }

    void showMenu(Offering theOffering) {
        setVisible(true);
    }

}
