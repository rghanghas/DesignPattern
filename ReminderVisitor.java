package PTBS;

// Visitor Design Pattern

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class ReminderVisitor extends NodeVisitor {

    Reminder theReminder;

    public ReminderVisitor() {
        System.out.println("Reminder Visitor Implemented");
    }

    public ReminderVisitor(Reminder reminder) {
        theReminder = reminder;
    }

    public Reminder getTheReminder() {
        return theReminder;
    }

    public void visitFacade(Facade facade) {
        ProductIterator productList = new ProductIterator(facade.theProductList);
        while (productList.hasNext()) {
            Product product = (Product) productList.next();
            product.accept(this);
        }
    }

    public void visitProduct(Product product) {
        Iterator<Trading> tradingList = product.tradingList.listIterator();
        while (tradingList.hasNext()) {
            Trading trading = (Trading) tradingList.next();
            trading.accept(this);
        }
    }

    public void visitTrading(Trading trading) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(trading.dueDate);
        int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
        if (theReminder != null) {
            if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday)
            {
                theReminder.listUpcoming.add("today is " + today.toString() + " " + trading.tradingName
                        + " Due Date is " + trading.getDueDateString());
            }
            if (nDueDate < ntoday) {
                theReminder.listOverDue.add(trading.tradingName + " Due Date is "
                        + trading.getDueDateString());
            }
        }
    }

}
