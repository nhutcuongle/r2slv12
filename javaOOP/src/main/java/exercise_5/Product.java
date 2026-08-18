package exercise_5;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int quantityInStock;

    public Product() {
    }

    public Product(int productID, String name, double price, int quantityInStock) {
        if (price < 0 || quantityInStock < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }
        this.quantityInStock = quantityInStock;
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
    }
}
