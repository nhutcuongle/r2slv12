package exercise_3;

import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
        super();
    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        setHeight(height);
        setMaterial(material);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 0 && height <= 2000) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be >= 0 and <= 2000!");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material != null && !material.trim().isEmpty()) {
            this.material = material;
        } else {
            throw new IllegalArgumentException("Material cannot be empty!");
        }
    }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter Height (0 - 2000): ");
            try {
                height = Integer.parseInt(sc.nextLine().trim());
                if (height < 0 || height > 2000) {
                    System.out.println("Height must be >= 0 and <= 2000!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Height must be a number!");
                height = -1;
            }
        } while (height < 0 || height > 2000);

        do {
            System.out.print("Enter Material: ");
            material = sc.nextLine().trim();
            if (material.isEmpty()) {
                System.out.println("Material cannot be empty!");
            }
        } while (material.isEmpty());
    }

    @Override
    public String toString() {
        return String.format("%s, Height: %d, Material: %s", super.toString(), height, material);
    }
}
