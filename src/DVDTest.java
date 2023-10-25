import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DVDTest {
    @Test
    void testBorrowAndReturn() {
        DVD dvd = new DVD("Sample DVD", "456-DEF", 120);
        assertFalse(dvd.isBorrowed());

        dvd.borrowItem();
        assertTrue(dvd.isBorrowed());

        dvd.returnItem();
        assertFalse(dvd.isBorrowed());
    }
}
