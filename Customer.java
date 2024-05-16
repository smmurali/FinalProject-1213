import java.util.ArrayList;
class Customer {
    private String name;
    private int id;
    private ArrayList<Order> orderHistory;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        orderHistory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void placeOrder(Order order) {
        orderHistory.add(order);
        System.out.println("Order placed successfully!");
    }
    public void cancelOrder(Order order) {
        orderHistory.remove(order);
        System.out.println("Order canceled successfully!");
    }
}
