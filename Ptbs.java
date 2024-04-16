package PTBS;

public class Ptbs {

    static Facade facade = new Facade();

    public Ptbs() {
        System.out.println("Ptbs Implemented");
    }

    public static void main(String[] args) {
        InfoItem userInfoItem = new InfoItem();
        facade.createProductList();
        while(true) {
            boolean lExit = false;
            lExit = Facade.login(userInfoItem);
            if(lExit)
                break;
            facade.createUser(userInfoItem);
            facade.attachProductToUser();
            if(userInfoItem.userType == InfoItem.USER_TYPE.Buyer)
                facade.remind();
            boolean logOut = false;
            while(!logOut) {
                logOut = facade.selectProduct();
                if(logOut)
                    break;
                logOut = facade.productOperation();
            }
        }
    }
}