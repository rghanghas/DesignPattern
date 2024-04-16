package PTBS;

// Facade & Visitor Design Pattern

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

public class Trading {

    protected String tradingName;
    protected String stringTradingFileName;
    protected Date dueDate = new Date();
    protected String tradingSpecification;
    protected OfferingList theOfferingList = new OfferingList();
    protected Offering expectedOffering = new Offering();
    boolean accepted = false;

    public boolean isAccepted() {
        return accepted;
    }

    public Trading() {
        System.out.println("Trading Implemented");
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setTradingSpecification(String theSpec) {
        this.tradingSpecification = theSpec;
    }

    public String getTradingSpecification() {
        return tradingSpecification;
    }

    public boolean isOverDue() {
        Date today = new Date();
        if(today.after(this.dueDate)){
            return true;
        }
        else{
            return false;
        }
    }

    public Offering addOffering() {
        Offering myOffering = new Offering();
        return myOffering;
    }

    public void addOffering(Offering theOffering) {
        theOfferingList.add(theOffering);
    }

    public OfferingList getTheOfferingList() {
        return theOfferingList;
    }

    public void submitOffering() {
        System.out.println("Submit Offering Implemented");
    }

    public void getOfferingList() {
        System.out.println("Get Offering Implemented");
    }

    public Offering getOffering(String buyerName) {
        OfferingIterator iterator = getOfferingIterator();
        return (Offering) iterator.next(buyerName);
    }

    public Offering getExpectedOffering() {
        return expectedOffering;
    }

    public OfferingIterator getOfferingIterator() {
        OfferingIterator theOfferingIterator = new OfferingIterator(theOfferingList);
        return theOfferingIterator;
    }

    public String toString() {
        return tradingName;
    }

    public String getDueDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormat.format(dueDate);
    }

    public void accept(NodeVisitor visitor) {
        visitor.visitTrading(this);
        accepted = true;
    }

}
