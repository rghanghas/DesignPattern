package PTBS;

// Bridge Design Pattern

public class Seller extends Person{

    public Seller() {
        type = 1;
    }

    public ProductMenu createProductMenu(Product theProduct, int theCategory) {
        if(theCategory == 0){
            theProductMenu = new MeatProductMenu();
        }
        else{
            theProductMenu = new ProduceProductMenu();
        }
        return theProductMenu;
    }

    public boolean showMenu() {
        super.showMenu();
        showAddButton();
        showViewButton();
        showRadioButton();
        showLabels();
        show();
        return ifLogout();
    }

}
