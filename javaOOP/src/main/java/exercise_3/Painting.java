package exercise_3;

import java.util.Scanner;

public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting() {
        super();
    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        setHeight(height);
        setWidth(width);
        setWaterColor(isWaterColor);
        setFramed(isFramed);
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width >= 0 && width <= 3000) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be >= 0 and <= 3000!");
        }
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public void setWaterColor(boolean isWaterColor) {
        this.isWaterColor = isWaterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        // Input Height
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

        // Input Width
        do {
            System.out.print("Enter Width (0 - 3000): ");
            try {
                width = Integer.parseInt(sc.nextLine().trim());
                if (width < 0 || width > 3000) {
                    System.out.println("Width must be >= 0 and <= 3000!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Width must be a number!");
                width = -1;
            }
        } while (width < 0 || width > 3000);

        // Input isWaterColor
        System.out.print("Is Water Color? (true/false): ");
        if (sc.hasNextBoolean()) {
            isWaterColor = sc.nextBoolean();
            sc.nextLine();
        } else {
            sc.nextLine();
            isWaterColor = false;
        }

        // Input isFramed
        System.out.print("Is Framed? (true/false): ");
        if (sc.hasNextBoolean()) {
            isFramed = sc.nextBoolean();
            sc.nextLine();
        } else {
            sc.nextLine();
            isFramed = false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, Height: %d, Width: %d, Water Color: %b, Framed: %b",
                super.toString(), height, width, isWaterColor, isFramed);
    }
}
