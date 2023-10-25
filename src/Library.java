import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements IManageable {
    private List<Item> items; // зберігати всі предмети
    private List<Patron> patrons; // зберігати всіх зареєстрованих читачів

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Реєстрація нового читача
    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    // Видання предмета читачеві
    public void lendItem(Patron patron, Item item) {
        if (!item.isBorrowed()) {
            patron.borrow(item);
        }
    }

    // Повернення взятого предмета
    public void returnItem(Patron patron, Item item) {
        patron.returnItem(item);
    }

    // Реалізація методів інтерфейсу IManageable

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public List<Item> listAvailable() {
        return items.stream().filter(item -> !item.isBorrowed()).collect(Collectors.toList());
    }

    @Override
    public List<Item> listBorrowed() {
        return items.stream().filter(Item::isBorrowed).collect(Collectors.toList());
    }

    // Додатковий метод для отримання списку взятих предметів та їхніх читачів
    public List<String> listBorrowedWithPatrons() {
        List<String> borrowedWithPatrons = new ArrayList<>();
        for (Patron patron : patrons) {
            for (Item item : patron.getBorrowedItems()) {
                borrowedWithPatrons.add(item.getTitle() + " borrowed by " + patron.getName());
            }
        }
        return borrowedWithPatrons;
    }
}
