package PTBS;


import java.util.Date;

public class Offering {

    String theBuyer = "";
    String offeringFileName = "";
    Date theSubmitDate = new Date();
    int theBid;
    boolean marked = false;

    public Offering() {
        System.out.println("Offering Implemented");
    }

    public String getTheBuyer() {
        return theBuyer;
    }

    @Override
    public String toString() {
        String string = theBuyer + " " + offeringFileName + " Bid : " + getBidInt();
        if(isMarked())
            string += " marked.";
        else
            string += " not marked.";
        return (string);
    }

    public void setOfferingFileName(String offeringFileName) {
        this.offeringFileName = offeringFileName;
    }

    public void setTheBuyer(String theBuyer) {
        this.theBuyer = theBuyer;
    }

    String getBidString() {
        if (isMarked())
            return "" + theBid;
        else
            return "-1";
    }

    int getBidInt() {
        return theBid;
    }

    public void setMarked(boolean marked){
        this.marked = marked;
    }

    public boolean isMarked() {
        return marked;
    }

}
