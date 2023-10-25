public class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    // Getter and setter for the author

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Implementation of the abstract methods

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            super.isBorrowed = true;
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            super.isBorrowed = false;
        }
    }
}
