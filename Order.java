import java.util.List;

interface Order {
    void addItem(MenuItem item);
    void removeItem(MenuItem item);
    List<MenuItem> getItems();
    double calculateTotalCost();
    int getItemCount();
    boolean containsItem(MenuItem item);
    void clearOrder();
    void displayOrder();
}
