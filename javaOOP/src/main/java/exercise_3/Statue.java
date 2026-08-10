package exercise_3;

import java.util.Scanner;

public class Statue extends Item {
    private int weight;
    private String color;

    public Statue() {
        super();
    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        setWeight(weight);
        setColor(color);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= 0 && weight <= 1000) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight must be >= 0 and <= 1000!");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color cannot be empty!");
        }
    }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter Weight (0 - 1000): ");
            try {
                weight = Integer.parseInt(sc.nextLine().trim());
                if (weight < 0 || weight > 1000) {
                    System.out.println("Weight must be >= 0 and <= 1000!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Weight must be a number!");
                weight = -1;
            }
        } while (weight < 0 || weight > 1000);

        do {
            System.out.print("Enter Color: ");
            color = sc.nextLine().trim();
            if (color.isEmpty()) {
                System.out.println("Color cannot be empty!");
            }
        } while (color.isEmpty());
    }

    @Override
    public String toString() {
        return String.format("%s, Weight: %d, Color: %s", super.toString(), weight, color);
    }
}
