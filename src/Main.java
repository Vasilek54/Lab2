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
    }
}