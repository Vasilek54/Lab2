public abstract class Item {
    private String title;
    private String uniqueID;
    protected boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Abstract methods for borrowing and returning the item

    public abstract void borrowItem();
    public abstract void returnItem();
}
