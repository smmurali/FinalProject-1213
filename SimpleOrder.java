import java.util.ArrayList;
import java.util.List;

class SimpleOrder implements Order {
    private List<MenuItem> items;

    public SimpleOrder() {
        this.items = new ArrayList<>();
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
    public double calculateTotalCost() {
        double totalCost = 0;
        for (MenuItem item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public boolean containsItem(MenuItem item) {
        return items.contains(item);
    }

    @Override
    public void clearOrder() {
        items.clear();
    }

    @Override
    public void displayOrder() {
        System.out.println("Order:");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
}
