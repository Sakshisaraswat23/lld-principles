package solid.SRP;

import java.util.ArrayList;
import java.util.List;

// classes name should be capital
//should define the variable/method as public
class Product{
    public int price;
    public String name;

    public  Product(int price, String name)
    {
        this.name=name;
        this.price=price;
    }
}

class ShoppingCart{

    // list<obj> name = new list();
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product obj)
    {
        products.add(obj);
    }
    // can write the getProduct as well
    public List<Product> getProducts() {
        return products;
    }

    // calculateTotalPrice
    public int calculateTotalPrice(){
        int total=0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    //printInvoices
    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + calculateTotalPrice());
    }

    // 3. Violating SRP - Saves to DB (Should be in a separate class)
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}


public class  SRPNotFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product(50000,"Laptop" ));
        cart.addProduct(new Product(2000,"Mouse"));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}