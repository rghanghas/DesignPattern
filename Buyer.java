package PTBS;

// Bridge Design Pattern

public class Buyer extends Person {

    public Buyer() {
        type = 0;
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

    @Override
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
