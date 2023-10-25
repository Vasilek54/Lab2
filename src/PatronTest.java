import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatronTest {
    @Test
    void testBorrowAndReturnItem() {
        Patron patron = new Patron("John Doe", "JD01");
        Book book = new Book("Sample Book", "123-ABC", "Sample Author");

        assertTrue(patron.getBorrowedItems().isEmpty());

        patron.borrow(book);
        assertEquals(1, patron.getBorrowedItems().size());
        assertTrue(book.isBorrowed());

        patron.returnItem(book);
        assertTrue(patron.getBorrowedItems().isEmpty());
        assertFalse(book.isBorrowed());
    }
}
