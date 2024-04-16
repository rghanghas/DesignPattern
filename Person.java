package PTBS;

// Bridge Design Pattern

import java.util.Iterator;

abstract public class Person {
    int type=0;
    String userName;
    ClassProductList productList;
    ProductMenu theProductMenu;
    Product currentProduct;
    Trading currentTrading;

    public Person() {
        productList = new ClassProductList();
    }

    abstract public ProductMenu createProductMenu(Product theProduct, int theCategory);

    public void showAddButton() {
        theProductMenu.showAddButton();
    }

    public void showViewButton() {
        theProductMenu.showViewButton();
    }

    public void showRadioButton() {
        theProductMenu.showRadioButton();
    }

    public void showLabels() {
        theProductMenu.showLabels();
    }

    public void show() {
        theProductMenu.setVisible(true);
    }

    public boolean ifLogout() {
        return theProductMenu.ifLogout();
    }

    public ClassProductList getProductList() {
        return productList;
    }

    public void addProduct(Product theProduct) {
        productList.add(theProduct);
    }

    public boolean showMenu() {
        Iterator<?> theIter = currentProduct.tradingList.iterator();
        theProductMenu.theProduct = currentProduct;
        Trading theTrading;
        while(theIter.hasNext()) {
            theTrading = (Trading) theIter.next();
            theProductMenu.tradingCombox.addItem(theTrading);
        }
        return false;
    }

}