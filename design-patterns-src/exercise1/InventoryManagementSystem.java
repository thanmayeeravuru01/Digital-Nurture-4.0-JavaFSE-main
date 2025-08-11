package exercise1;
import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: $" + price;
    }
}

class Inventory {
    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.productId, product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(int productId, String name, int quantity, double price) {
        if (products.containsKey(productId)) {
            Product p = products.get(productId);
            p.productName = name;
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated: " + p);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(101, "Laptop", 10, 75000));
        inventory.addProduct(new Product(102, "Smartphone", 20, 25000));
        inventory.displayProducts();
        inventory.updateProduct(102, "Smartphone Pro", 25, 30000);
        inventory.deleteProduct(101);
        inventory.displayProducts();
    }
}
