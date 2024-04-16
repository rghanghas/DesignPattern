package PTBS;

// Visitor Design Pattern

abstract public class NodeVisitor {

    public NodeVisitor() {
        System.out.println("Node Visitor Implemented");
    }

    public NodeVisitor(Object visitee) {
        System.out.println("Node Visitor with object " + visitee + " Implemented");
    }

    abstract public void visitProduct(Product product);

    abstract public void visitTrading(Trading trading);

    abstract public void visitFacade(Facade facade);

}
