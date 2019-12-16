package by.epam.pavelshakhlovich.paperxml.entity;

public class Newspaper extends Paper {
    private boolean hasWebVersion;
    private int subscriptionIndex;

    public Newspaper() {
    }

    public Newspaper(String title, Periodicity periodicity, boolean isColor, int size,
                     boolean hasWebVersion, int subscriptionIndex) {
        super(title, periodicity, false, isColor, size);
        this.hasWebVersion = hasWebVersion;
        this.subscriptionIndex = subscriptionIndex;
    }

    public boolean isHasWebVersion() {
        return hasWebVersion;
    }

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }
}
