package OCP;
// copying the SRP and just changing the save DB section

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
    private ShoppingCartp cart;
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
/*
“An interface without an access modifier is package-private.
All interface methods are implicitly public and abstract, so save() is public by default

Default access level = package-private for interface
Meaning: Accessible only inside the same package and NOT accessible from other packages

If you want it public:
public interface Persistence {
    void save(ShoppingCart cart);
}

BUTTTTTT this is only for interface, the methods are by default public
Is the save() method public?
✅ YES — implicitly public

In Java: All interface methods are public by default
So this:
void save(ShoppingCart cart);

Is treated by compiler as:
public abstract void save(ShoppingCart cart);

 */
interface DBPersistance{
     void save();
}
class SaveToSql implements DBPersistance{
    private ShoppingCartp cart;
    public SaveToSql(ShoppingCartp cart){
        this.cart=cart;
    }
    public  void save(){
        System.out.println("Saving into SQL database");

    }
}
class SaveToFile implements DBPersistance{
    public  void save(){
        System.out.println("Saving into File, valid OCP");

    }
}
//class CartDBStoragep{
//    private ShoppingCartp cart;
//    public CartDBStoragep( ShoppingCartp cart){
//        this.cart=cart;
//    }
//    public void saveToDatabase(){
//        System.out.println("Saving shopping cart to database...");
//    }
//}


public class  OCPValid {
    public static void main(String[] args) {
        ShoppingCartp cart = new ShoppingCartp();

        cart.addProductp(new Productp(50,"Laptop" ));
        cart.addProductp(new Productp(20,"Mouse"));

       CartPrintInvoices invoices = new CartPrintInvoices(cart);
        invoices.printInvoice();

        DBPersistance db1 = new SaveToSql(cart);
        db1.save();

        DBPersistance dbFile = new SaveToFile();
        dbFile.save();
    }
}