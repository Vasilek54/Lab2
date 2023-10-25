import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add an item (Book or DVD) to the library");
            System.out.println("2. Remove an item from the library");
            System.out.println("3. Register a patron");
            System.out.println("4. Lend an item to a patron");
            System.out.println("5. Return an item to the library");
            System.out.println("6. Display available items");
            System.out.println("7. Display borrowed items and their patrons");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    registerPatron();
                    break;
                case 4:
                    lendItem();
                    break;
                case 5:
                    returnItem();
                    break;
                case 6:
                    displayAvailableItems();
                    break;
                case 7:
                    displayBorrowedItems();
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static void addItem() {
        System.out.println("Choose item type (1. Book, 2. DVD):");
        int type = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter the title of the item:");
        String title = scanner.nextLine();

        System.out.println("Enter the unique ID of the item:");
        String uniqueID = scanner.nextLine();

        if (type == 1) {
            System.out.println("Enter the author of the book:");
            String author = scanner.nextLine();
            Book book = new Book(title, uniqueID, author);
            library.add(book);
            System.out.println("Book added successfully!");
        } else if (type == 2) {
            System.out.println("Enter the duration of the DVD (in minutes):");
            int duration = scanner.nextInt();
            DVD dvd = new DVD(title, uniqueID, duration);
            library.add(dvd);
            System.out.println("DVD added successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void removeItem() {
        System.out.println("Enter the unique ID of the item to remove:");
        String uniqueID = scanner.nextLine();
        // We can enhance this by searching for the item by its unique ID and then removing it
        // For simplicity, we're creating a new item and removing it
        Item item = new Book("", uniqueID, "");  // Create a dummy item for removal
        library.remove(item);
        System.out.println("Item removed successfully (if it existed).");
    }

    // ...

    private static void registerPatron() {
        System.out.println("Enter the name of the patron:");
        String name = scanner.nextLine();

        System.out.println("Enter the ID of the patron:");
        String ID = scanner.nextLine();

        Patron patron = new Patron(name, ID);
        library.registerPatron(patron);
        System.out.println("Patron registered successfully!");
    }

    private static void lendItem() {
        System.out.println("Enter the ID of the patron:");
        String patronID = scanner.nextLine();

        Patron patron = findPatronByID(patronID);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.println("Enter the unique ID of the item:");
        String uniqueID = scanner.nextLine();

        Item item = findItemByID(uniqueID);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        if (item.isBorrowed()) {
            System.out.println("Item is already borrowed.");
            return;
        }

        library.lendItem(patron, item);
        System.out.println("Item lent to patron successfully!");
    }

    private static void returnItem() {
        System.out.println("Enter the ID of the patron:");
        String patronID = scanner.nextLine();

        Patron patron = findPatronByID(patronID);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.println("Enter the unique ID of the item:");
        String uniqueID = scanner.nextLine();

        Item item = findItemByID(uniqueID);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        library.returnItem(patron, item);
        System.out.println("Item returned to the library successfully!");
    }

    private static void displayAvailableItems() {
        List<Item> availableItems = library.listAvailable();
        if (availableItems.isEmpty()) {
            System.out.println("No available items.");
        } else {
            availableItems.forEach(System.out::println);
        }
    }

    private static void displayBorrowedItems() {
        List<String> borrowedItemsWithPatrons = library.listBorrowedWithPatrons();
        if (borrowedItemsWithPatrons.isEmpty()) {
            System.out.println("No borrowed items.");
        } else {
            borrowedItemsWithPatrons.forEach(System.out::println);
        }
    }

    // Utility methods to find patron and item by ID

    private static Patron findPatronByID(String ID) {
        // This can be enhanced by storing patrons in a Map for O(1) retrieval
        for (Patron patron : library.patrons) {
            if (patron.getID().equals(ID)) {
                return patron;
            }
        }
        return null;
    }

    private static Item findItemByID(String uniqueID) {
        // This can be enhanced by storing items in a Map for O(1) retrieval
        for (Item item : library.items) {
            if (item.getUniqueID().equals(uniqueID)) {
                return item;
            }
        }
        return null;
    }
}
