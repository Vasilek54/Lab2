import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testBorrowAndReturn() {
        Book book = new Book("Sample Book", "123-ABC", "Sample Author");
        assertFalse(book.isBorrowed());

        book.borrowItem();
        assertTrue(book.isBorrowed());

        book.returnItem();
        assertFalse(book.isBorrowed());
    }
}
