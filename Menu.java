import java.util.List;

interface Menu {
    void addItem(MenuItem item);
    void removeItem(MenuItem item);
    List<MenuItem> getItems();
    MenuItem findItemByName(String name);
    MenuItem getMostExpensiveItem();
    MenuItem getCheapestItem();
    int getTotalItemsCount();
    void clearMenu();
    void displayMenu();
    MenuItem searchItem(String itemName);
}
