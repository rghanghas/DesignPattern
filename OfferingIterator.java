package PTBS;

// Iterator Design Pattern

import java.util.Iterator;

public class OfferingIterator implements Iterator<Object> {

    OfferingList offeringList;
    int currentOfferingNumber = -1;

    public int getCurrentOfferingNumber() {
        return currentOfferingNumber;
    }

    public OfferingIterator() {
        System.out.println("Offering Iterator Implemented");
    }

    public OfferingIterator(OfferingList theOfferingList) {
        offeringList = theOfferingList;
        moveToHead();
    }

    public void moveToHead() {
        currentOfferingNumber = -1;
    }

    public boolean hasNext() {
        if(currentOfferingNumber >= offeringList.size() - 1)
            return false;
        else
            return true;
    }

    public Object next() {
        if(hasNext() == true) {
            currentOfferingNumber++;
            return offeringList.get(currentOfferingNumber);
        }
        else {
            return null;
        }
    }

    public void remove() {
        offeringList.remove(currentOfferingNumber);
    }

    public Object next(String UserName) {
        Offering theOffering;
        theOffering = (Offering) next();
        while(theOffering != null){
            if(UserName.compareTo(theOffering.toString()) == 0){
                return theOffering;
            }
            theOffering = (Offering) next();
        }
        return null;
    }


}
