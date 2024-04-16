package PTBS;

//Facade Design Pattern

import java.io.BufferedReader;
import java.io.FileReader;

public class Facade {

    public int userType;
    private Product theSelectedProduct = null;
    private int nProductLevel = 0;
    ClassProductList theProductList;
    Person thePerson;

    public Facade() {
        System.out.println("Facade Implemented");
    }

    static public boolean login(InfoItem userinfoItem) {
        Login login = new Login();
        login.setModal(true);
        login.setVisible(true);
        userinfoItem.strUserName = login.getUserName();
        userinfoItem.userType = login.getUserType();
        return login.isExit();
    }

    void addTrading(Product theProduct) {
        TradingMenu theTradingMenu;
        if (thePerson.type == 0)
        {
            theTradingMenu = new BuyerTradingMenu();
        } else {
            theTradingMenu = new SellerTradingMenu();
        }
        Trading theTrading = new Trading();
        theTradingMenu.showMenu(theTrading, thePerson);
        theProduct.addTrading(theTrading);
    }

    void viewTrading(Trading theTrading) {
        TradingMenu theTradingMenu;
        if (thePerson.type == 0)
        {
            theTradingMenu = new BuyerTradingMenu();
        } else {
            theTradingMenu = new SellerTradingMenu();
        }
        theTradingMenu.showMenu(theTrading, thePerson);
    }

    void viewOffering(Offering theOffering) {
        OfferingMenu offeringMenu = new OfferingMenu();
        offeringMenu.showMenu(theOffering);
    }

    void markOfferings(Trading theTrading) {
        Offering theOffering;
        OfferingIterator theOfferingIterator;
        theOfferingIterator = theTrading.getOfferingIterator();
        theOffering = (Offering) theOfferingIterator.next();
        while (theOffering != null) {
            theOffering.setMarked(true);
            theOffering = (Offering) theOfferingIterator.next();
        }
    }

    void submitOffering(Trading theTrading, Offering theOffering) {
        theTrading.addOffering(theOffering);
    }

    void remind() {
        Reminder theReminder = new Reminder();
        theReminder.showReminder(thePerson.getProductList());
    }

    void createUser(InfoItem userinfoitem) {
        if (userinfoitem.userType == InfoItem.USER_TYPE.Buyer)
        {
            thePerson = new Buyer();
        } else
        {
            thePerson = new Seller();
        }
        thePerson.userName = userinfoitem.strUserName;
    }

    void createProductList() {
        theProductList = new ClassProductList();
        theProductList.initializeFromFile("UserProductInfo.txt");
    }

    public ClassProductList getTheProductList() {
        return theProductList;
    }

    void attachProductToUser() {
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(System.getProperty("user.dir")
                    + "//UserProduct.txt"));
            String aline, strUserName, strProductName;
            while ((aline = file.readLine()) != null)
            {
                strUserName = getUserName(aline);
                strProductName = getProductName(aline);
                if (strUserName.compareTo(thePerson.userName) == 0)
                {
                    theSelectedProduct = findProductByProductName(strProductName);
                    if (theSelectedProduct != null)
                    {
                        thePerson.addProduct(theSelectedProduct);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUserName(String aline) {
        int al = aline.lastIndexOf(':');
        return aline.substring(0, al);
    }

    private String getProductName(String aline) {
        int al = aline.lastIndexOf(':');
        return aline.substring(al + 1, aline.length());
    }

    public boolean selectProduct() {
        ProductSelectDlg theDlg = new ProductSelectDlg();
        theSelectedProduct = theDlg.showDlg(thePerson.productList);
        thePerson.currentProduct = theSelectedProduct;
        nProductLevel = theDlg.productCategory;
        return theDlg.isLogout();
    }

    public boolean productOperation() {
        thePerson.createProductMenu(theSelectedProduct, nProductLevel);
        return thePerson.showMenu();
    }

    private Product findProductByProductName(String strProductName) {
        ProductIterator iterator = new ProductIterator(theProductList);
        return (Product) iterator.next(strProductName);
    }

}
