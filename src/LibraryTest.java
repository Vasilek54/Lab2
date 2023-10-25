import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddAndListAvailableItems() {
        Book book = new Book("Sample Book", "123-ABC", "Sample Author");
        library.add(book);

        List<Item> availableItems = library.listAvailable();
        assertEquals(1, availableItems.size());
        assertEquals(book, availableItems.get(0));
    }

    @Test
    void testLendAndReturnItem() {
        Book book = new Book("Sample Book", "123-ABC", "Sample Author");
        Patron patron = new Patron("John Doe", "JD01");

        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);

        assertTrue(book.isBorrowed());
        assertEquals(1, patron.getBorrowedItems().size());

        library.returnItem(patron, book);

        assertFalse(book.isBorrowed());
        assertTrue(patron.getBorrowedItems().isEmpty());
    }

    // You can add more tests to cover other functionalities like removing items, listing borrowed items, etc.
}
