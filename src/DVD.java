public class DVD extends Item {
    private int duration;  // duration in minutes

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    // Getter and setter for the duration

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
