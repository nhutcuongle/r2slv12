package exercise_3;

public class ItemList {
    Item[] list;
    int numOfItem;
    final int MAX = 100;

    public static final String VASE = "Vase";
    public static final String STATUE = "Statue";
    public static final String PAINTING = "Painting";

    public ItemList() {
        list = new Item[MAX];
    }

    public boolean addItem(Item item) {
        if (item == null || numOfItem >= MAX) {
            return false;
        }

        list[numOfItem++] = item;
      

        return true;
    }

    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("The list is empty.");
            return;
        }

        for (int i = 0; i < numOfItem; i++) {
            System.out.println(list[i]);
        }
    }

    public Item findItem(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equalsIgnoreCase(creator)) {
                return list[i];
            }
        }
        return null;
    }

    public boolean updateItem(String id) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getId().equalsIgnoreCase(id)) {
                list[i].input();
                return true;
            }
        }
        return false;
    }

    public void displayItemsByType(String type) {
        if (type.equalsIgnoreCase(VASE)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i]);
                }
            }
        } else if (type.equalsIgnoreCase(STATUE)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i]);
                }
            }
        } else {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i]);
                }
            }
        }
    }
}
