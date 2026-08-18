package exercise_5;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("=== Product Management Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Retrieve Product by ID");
        System.out.println("3. Update Product Quantity");
            System.out.println("4. Exit");
        System.out.print("Select an option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option! Please enter a number.");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter product details:");
                    try {
                        System.out.print("Product ID: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Product Name: ");
                        String name = scanner.nextLine().trim();

                        System.out.print("Product Price: ");
                        double price = Double.parseDouble(scanner.nextLine().trim());

                        System.out.print("Quantity in Stock: ");
                        int quantity = Integer.parseInt(scanner.nextLine().trim());

                        pm.addProduct(new Product(id, name, price, quantity));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;

                case 2:
                    try {
                        System.out.print("Enter Product ID to retrieve: ");
                        int retrieveID = Integer.parseInt(scanner.nextLine().trim());
                        Product product = pm.getProductByID(retrieveID);
                        product.displayProductInfo();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format!");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;

                case 3:
                    try {
                        System.out.print("Enter Product ID to update: ");
                        int updateID = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Enter new quantity: ");
                        int newQuantity = Integer.parseInt(scanner.nextLine().trim());

                        pm.updateProductQuantity(updateID, newQuantity);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format!");
                    } catch (ProductNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option! Please select from 1 to 4.");
                    System.out.println();
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
