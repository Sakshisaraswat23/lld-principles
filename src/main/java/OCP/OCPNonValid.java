package OCP;
// copying the SRP and just changing the save DB class to show it is not valid.


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
}

class CartDBStorage{
    private ShoppingCart cart;
    public CartDBStorage( ShoppingCart cart){
        this.cart=cart;
    }
    public void saveToDatabase(){
        System.out.println("Saving shopping cart to database...");
    }

    // now in file
    /*
    BREAKING OCP, as we are modifying exisitng function.
     */
    public  void saveTOFIle(){
        System.out.println("Saving in file");
    }
}

public class  OCPNonValid {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product(50000,"Laptop" ));
        cart.addProduct(new Product(2000,"Mouse"));

        CartDBStorage obj = new CartDBStorage(cart);
        obj.saveToDatabase();
        obj.saveTOFIle();
    }
}