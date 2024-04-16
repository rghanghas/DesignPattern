package PTBS;

import java.util.ArrayList;

public class Product {

    String productName;
    public ArrayList<Trading> tradingList = new ArrayList<Trading>();
    int numberOfTrading;
    int productCategory;
    boolean accepted = false;

    public boolean isAccepted() {
        return accepted;
    }

    public Product(String strProduct, int theCategory) {
        this.productName = strProduct;
        this.productCategory = theCategory;
        this.numberOfTrading = 0;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void addTrading(Trading newTrading){
        tradingList.add(newTrading);
    }

    public String toString() {
        return productName;
    }

    void accept(NodeVisitor visitor) {
        visitor.visitProduct(this);
        accepted=true;
    }

}
