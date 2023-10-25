public class Main {
    public static void main(String[] args) {
        Book book = new Book("Lord of the rings", "0000", "Tolkien");
        System.out.println(book.getUniqueID());
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.isBorrowed());
        book.borrowItem();
        System.out.println(book.isBorrowed());
        book.returnItem();
        System.out.println(book.isBorrowed());

        DVD dvd = new DVD("Lord of the rings", "0001", 120);
        System.out.println(dvd.getUniqueID());
        System.out.println(dvd.getTitle());
        System.out.println(dvd.getDuration());
        System.out.println(dvd.isBorrowed());
        dvd.borrowItem();
        System.out.println(dvd.isBorrowed());
        dvd.returnItem();
        System.out.println(dvd.isBorrowed());

        Patron patron = new Patron("Jake", "0000");
        System.out.println(patron.getID());
        System.out.println(patron.getName());
        System.out.println(patron.getBorrowedItems());
        patron.borrow(book);
        System.out.println(patron.getBorrowedItems());
        patron.borrow(dvd);
        System.out.println(patron.getBorrowedItems());
        patron.returnItem(book);
        System.out.println(patron.getBorrowedItems());
        patron.returnItem(dvd);
        System.out.println(patron.getBorrowedItems());
    }
}