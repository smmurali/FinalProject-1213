import java.util.ArrayList;
import java.util.List;


class MenuImpl implements Menu {
    private List<MenuItem> items;

    public MenuImpl() {
        this.items = new ArrayList<>();
        items.add(new Appetizer("Nachos", 8.99));
        items.add(new Appetizer("Caesar Salad", 7.99));
        items.add(new MainCourse("Spaghetti Bolognese", 12.99));
        items.add(new MainCourse("Grilled Salmon", 16.99));
        items.add(new Dessert("Chocolate Cake", 6.99));
        items.add(new Dessert("Vanilla Ice Cream", 4.99));
    }

    @Override
    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    @Override
    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public MenuItem findItemByName(String name) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public MenuItem getMostExpensiveItem() {
        if (items.isEmpty()) {
            return null;
        }
        MenuItem mostExpensive = items.get(0);
        for (MenuItem item : items) {
            if (item.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = item;
            }
        }
        return mostExpensive;
    }

    @Override
    public MenuItem getCheapestItem() {
        if (items.isEmpty()) {
            return null;
        }
        MenuItem cheapest = items.get(0);
        for (MenuItem item : items) {
            if (item.getPrice() < cheapest.getPrice()) {
                cheapest = item;
            }
        }
        return cheapest;
    }

    @Override
    public int getTotalItemsCount() {
        return items.size();
    }

    @Override
    public void clearMenu() {
        items.clear();
    }

    @Override
    public void displayMenu() {
        System.out.println("Menu: ");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    @Override
    public MenuItem searchItem(String itemName) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}
