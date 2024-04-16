package PTBS;

// Iterator Design Pattern

import java.util.*;

public class ListIterator implements Iterator<Object> {

    ArrayList<Object> theList;
    int currentNumber = -1;

    public ListIterator() {
        System.out.println("List Iterator Implemented");
    }

    public ListIterator(ArrayList<Object> list) {
        theList = list;
        moveToHead();
    }

    public void moveToHead() {
        currentNumber = -1;
    }

    public ArrayList<Object> getTheList() {
        return theList;
    }

    public boolean hasNext() {
        if(currentNumber >= theList.size() - 1)
            return false;
        else
            return true;
    }

    public Object next() {
        if(hasNext() == true) {
            currentNumber++;
            return theList.get(currentNumber);
        }
        else {
            return null;
        }
    }

    public void remove() {
        theList.remove(currentNumber);
    }

}
