package exercise_4;

import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProduct;
    private static final byte MAX = 100;

    // Constants for menu choices
    private static final byte ADD = 1;
    private static final byte DISPLAY = 2;
    private static final byte FIND = 3;
    private static final byte EXIT = 0;

    public Program() {
        products = new Product[MAX];
        numOfProduct = 0;
    }

    public void addProduct(Product product) {
        if (numOfProduct < MAX) {
            products[numOfProduct++] = product;
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Product list is full!");
        }
    }

    public void displayProducts() {
        if (numOfProduct == 0) {
            System.out.println("No products available.");
            return;
        }
        for (int i = 0; i < numOfProduct; i++) {
            Product p = products[i];
            if (p instanceof Electronics) {
                Electronics e = (Electronics) p;
                System.out.println("Electronics - ID: " + e.getId() + ", Name: " + e.getName() + ", Price: " + e.getPrice() + ", Brand: " + e.getBrand());
            } else if (p instanceof Clothing) {
                Clothing c = (Clothing) p;
                System.out.println("Clothing - ID: " + c.getId() + ", Name: " + c.getName() + ", Price: " + c.getPrice() + ", Size: " + c.getSize());
            } else {
                System.out.println("Product - ID: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
            }
        }
    }

    public Product findProduct(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        byte choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Find Product");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextByte();
            scanner.nextLine();

            switch (choice) {
                case ADD:
                    System.out.println("Select Product Type:");
                    System.out.println("1. Electronics");
                    System.out.println("2. Clothing");
                    System.out.print("Choice: ");
                    byte typeChoice = scanner.nextByte();
                    scanner.nextLine();

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    float price = scanner.nextFloat();
                    scanner.nextLine();

                    if (typeChoice == 1) {
                        System.out.print("Enter Brand: ");
                        String brand = scanner.nextLine();
                        p.addProduct(new Electronics(id, name, price, brand));
                    } else if (typeChoice == 2) {
                        System.out.print("Enter Size: ");
                        String size = scanner.nextLine();
                        p.addProduct(new Clothing(id, name, price, size));
                    } else {
                        System.out.println("Invalid product type!");
                    }
                    break;
                case DISPLAY:
                    p.displayProducts();
                    break;
                case FIND:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Product found = p.findProduct(searchId);
                    if (found != null) {
                        System.out.print("Found: ");
                        if (found instanceof Electronics) {
                            Electronics e = (Electronics) found;
                            System.out.println("Electronics - ID: " + e.getId() + ", Name: " + e.getName() + ", Price: " + e.getPrice() + ", Brand: " + e.getBrand());
                        } else if (found instanceof Clothing) {
                            Clothing c = (Clothing) found;
                            System.out.println("Clothing - ID: " + c.getId() + ", Name: " + c.getName() + ", Price: " + c.getPrice() + ", Size: " + c.getSize());
                        }
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != EXIT);

        scanner.close();
    }
}
