package PTBS;

// Iterator Design Pattern

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

    private static final long serialVersionUID = 1L;

    public ClassProductList() {
        System.out.println("Class Product List Implemented");
    }

    void initializeFromFile(String theFileName) {
        try{
            BufferedReader file;
            String strProductName = null;
            file = new BufferedReader(new FileReader(System.getProperty("user.dir")
                    + "\\" + theFileName));
            while((strProductName = file.readLine()) != null) {
                Product theProduct = new Product(strProductName, 0);
                add(theProduct);
            }
            file.close();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    Product findProductByProductName(String productName){
        int productCount = size();
        for(int i=0;i<productCount;i++){
            Product theProduct = (Product) get(i);
            if(theProduct.productName.compareTo(productName) == 0)
                return theProduct;
        }
        return null;
    }

}
