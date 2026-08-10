package exercise_3;

import java.util.Scanner;

public class Item {
    protected String id;
    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(String id, int value, String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 0) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Value must be >= 0!");
        }
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if (creator != null && !creator.trim().isEmpty()) {
            this.creator = creator;
        } else {
            throw new IllegalArgumentException("Creator cannot be empty!");
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter ID: ");
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("ID cannot be empty!");
            }
        } while (id.isEmpty());

        do {
            System.out.print("Enter Value (>=0): ");
            try {
                value = Integer.parseInt(sc.nextLine().trim());
                if (value < 0) {
                    System.out.println("Value must be >= 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Value must be a number!");
                value = -1;
            }
        } while (value < 0);

        do {
            System.out.print("Enter Creator: ");
            creator = sc.nextLine().trim();
            if (creator.isEmpty()) {
                System.out.println("Creator cannot be empty!");
            }
        } while (creator.isEmpty());
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
    }
}
