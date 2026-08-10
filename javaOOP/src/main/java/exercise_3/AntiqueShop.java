package exercise_3;

import java.util.Scanner;

public class AntiqueShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        byte choice = 0;

        do {
            System.out.println("\n1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator ");
            System.out.println("6. Display the list of vase items ");
            System.out.println("7. Quit");
            System.out.print("Input your choice: ");

            if (sc.hasNextByte()) {
                choice = sc.nextByte();
                sc.nextLine();
            } else {
                sc.nextLine();
                choice = 0;
            }

            switch (choice) {
                case 1:
                    Vase vase = new Vase();
                    vase.input();
                    if (itemList.addItem(vase)) {
                        System.out.println("added");
                    }
                    break;

                case 2:
                    Statue statue = new Statue();
                    statue.input();
                    if (itemList.addItem(statue)) {
                        System.out.println("added");
                    }
                    break;

                case 3:
                    Painting painting = new Painting();
                    painting.input();
                    if (itemList.addItem(painting)) {
                        System.out.println("added");
                    }
                    break;

                case 4:
                    itemList.displayAll();
                    break;

                case 5:
                    System.out.print("Input creator name to find: ");
                    String creator = sc.nextLine().trim();
                    Item foundItem = itemList.findItem(creator);
                    if (foundItem != null) {
                        System.out.println(foundItem);
                    } else {
                        System.out.println("Not found");
                    }
                    break;

                case 6:
                    itemList.displayItemsByType(ItemList.VASE);
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice <= 6);
    }
}
