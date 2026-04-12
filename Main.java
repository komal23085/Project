class Product {
    private String productName;
    private int quantity;
    private int threshold;

    public Product(String productName, int quantity, int threshold) {
        this.productName = productName;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    // Method to update quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayDetails() {
        System.out.println("Product: " + productName + 
                          " | Quantity: " + quantity + 
                          " | Threshold: " + threshold);
    }
}

class InventoryManager {
    private Product[] products;
    private int count;

    public InventoryManager(int size) {
        products = new Product[size];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
            System.out.println("✓ Added: " + product.getProductName());
        } else {
            System.out.println("Inventory is full! Cannot add more products.");
        }
    }

    public void checkLowStock() {
        System.out.println("\n=== Checking Inventory ===");
        for (int i = 0; i < count; i++) {
            Product p = products[i];
            if (p.getQuantity() < p.getThreshold()) {
                System.out.println("⚠️  Product: " + p.getProductName() + " - Low Stock Alert!");
            } else {
                System.out.println("✅ Product: " + p.getProductName() + " - Stock OK");
            }
        }
    }

    public void displayAllProducts() {
        System.out.println("\n=== Full Inventory Details ===");
        for (int i = 0; i < count; i++) {
            products[i].displayDetails();
        }
    }
}

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("=====================================");
        System.out.println("   WAREHOUSE INVENTORY TRACKER");
        System.out.println("=====================================\n");

        InventoryManager manager = new InventoryManager(6);

        Product laptop     = new Product("Laptop", 15, 10);
        Product mouse      = new Product("Wireless Mouse", 5, 8);
        Product keyboard   = new Product("Keyboard", 25, 15);
        Product monitor    = new Product("Monitor", 7, 10);
        Product printer    = new Product("Printer", 3, 5);
        Product headphones = new Product("Headphones", 12, 10);

        manager.addProduct(laptop);
        manager.addProduct(mouse);
        manager.addProduct(keyboard);
        manager.addProduct(monitor);
        manager.addProduct(printer);
        manager.addProduct(headphones);

        manager.checkLowStock();

        manager.displayAllProducts();

        System.out.println("\n✅ Inventory check completed successfully!");
    }
}