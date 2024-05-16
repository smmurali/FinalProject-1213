import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Restaurant {
    private Menu menu;
    private List<Order> orders;
    private Scanner scanner;

    public Restaurant(Menu menu) {
        this.menu = menu;
        this.orders = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
    displayWelcomeMessage();
    int choice;
    do {
        displayMainMenu();
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    processOrders();
                    break;
                case 4:
                    displayExitMessage();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Consume invalid input to prevent infinite loop
            choice = 0; // Reset choice to force re-prompting
        }
    } while (choice != 4);
}

    private void displayWelcomeMessage() {
        System.out.println("Welcome to the Restaurant Ordering System!");
    }

    private void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. View Menu");
        System.out.println("2. Place Order");
        System.out.println("3. Process Orders");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void displayMenu() {
        menu.displayMenu();
    }

    private void placeOrder() {
        Order order = new SimpleOrder();
        MenuItem item = selectMenuItem();
        order.addItem(item);
        orders.add(order);
        System.out.println("Order placed successfully!");
    }

    private MenuItem selectMenuItem() {
        System.out.println("Please select an item from the menu:");
        displayMenu();
        System.out.print("Enter the name of the item: ");
        String itemName = scanner.nextLine();
        MenuItem item = menu.searchItem(itemName);
        if (item == null) {
            System.out.println("Sorry, the item you entered is not available.");
        }
        return item;
    }

    private void processOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to process.");
            return;
        }
        System.out.println("Processing orders:");
        for (Order order : orders) {
            order.displayOrder();
        }
        orders.clear();
        System.out.println("Orders processed successfully.");
    }

    private void displayExitMessage() {
        System.out.println("Thank you for using the Restaurant Ordering System. Goodbye!");
    }

    public static void main(String[] args) {
        Menu menu = new MenuImpl();
        Restaurant restaurant = new Restaurant(menu);
        restaurant.run();
    }
}
