/*
https://github.com/adityatandon15/LLD/blob/main/Lecture%2005/Java%20Code/SRP/SRPFollowed.java
 */


package solid.SRP;

import java.util.ArrayList;
import java.util.List;

// classes name should be capital
//should define the variable/method as public
class Productp{
    public int price;
    public String name;

    public  Productp(int price, String name)
    {
        this.name=name;
        this.price=price;
    }
}

class ShoppingCartp{

    // list<obj> name = new list();
    private List<Productp> productsp = new ArrayList<>();

    public void addProductp(Productp obj)
    {
        productsp.add(obj);
    }
    // can write the getProduct as well
    public List<Productp> getProductsp() {
        return productsp;
    }

    // calculateTotalPrice
    public int calculateTotalPricep(){
        int total=0;
        for (Productp p : productsp) {
            total += p.price;
        }
        return total;
    }

}

class CartPrintInvoices{
    private  ShoppingCartp cart;
    private List<Productp> productsp;
    public CartPrintInvoices( ShoppingCartp cart){
        this.cart=cart;
        this.productsp=cart.getProductsp();
    }
    /*
    IMPORTANT:
    Maine ye productp ka variable nhi banaya tha jab ki yaha likh diya tha alag se
    Got this error: Cannot reference 'cart' before constructor has completed

    This is compile time error due to :
    Field initializers run before constructor, cart is NOT initialized yet

    */
//    private List<Productp> productsp = cart.getProductsp();
    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Productp p : productsp) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotalPricep());
    }
}

class CartDBStorage{
    private  ShoppingCartp cart;
    public CartDBStorage( ShoppingCartp cart){
        this.cart=cart;
    }
    public void saveToDatabase(){
        System.out.println("Saving shopping cart to database...");
    }
}


public class  SRPFollowed {
    public static void main(String[] args) {
        ShoppingCartp cart = new ShoppingCartp();

        cart.addProductp(new Productp(50,"Laptop" ));
        cart.addProductp(new Productp(20,"Mouse"));

        CartPrintInvoices invoices = new CartPrintInvoices(cart);
        invoices.printInvoice();

        CartDBStorage db = new CartDBStorage(cart);
        db.saveToDatabase();
    }
}