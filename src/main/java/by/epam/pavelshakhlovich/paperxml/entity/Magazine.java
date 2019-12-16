package by.epam.pavelshakhlovich.paperxml.entity;

public class Magazine extends Paper {
    private int subscriptionIndex;

    public Magazine() {
    }

    public Magazine(String title, Periodicity periodicity, boolean isGlossy, boolean isColor,
                    int size, int subscriptionIndex) {
        super(title, periodicity, isGlossy, isColor, size);
        this.subscriptionIndex = subscriptionIndex;
    }

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }
}
