package exercise_5;

public class ProductManagement {
    private static final int MAX_CAPACITY = 10;
    private Product[] products = new Product[MAX_CAPACITY];
    private int productCount = 0;

    // 1. Add a new product
    public void addProduct(Product product) throws IllegalArgumentException {
        if (productCount >= MAX_CAPACITY) {
            throw new IllegalArgumentException("Array accepts no more than 10 products.");
        }

        // Check for duplicate product ID
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == product.getProductID()) {
                throw new IllegalArgumentException("Product ID already exists.");
            }
        }

        // Check if price or quantity is negative
        if (product.getPrice() < 0 || product.getQuantityInStock() < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }

        products[productCount++] = product;
        System.out.println("Product added successfully.");
    }

    // 2. Retrieve a product by ID
    public Product getProductByID(int productID) throws ProductNotFoundException {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                return products[i];
            }
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }

    // 3. Update product quantity
    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException, IllegalArgumentException {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }

        Product product = getProductByID(productID);
        product.setQuantityInStock(newQuantity);
        System.out.println("Product quantity updated successfully.");
    }
}
