package by.epam.pavelshakhlovich.papersxml.entity;

public abstract class Paper {
    private String title;
    private Periodicity periodicity;
    private boolean isGlossy;
    private boolean isColor;
    private int pageCount;

    public Paper() {
    }

    public Paper(String title, Periodicity periodicity, boolean isGlossy, boolean isColor, int size) {
        this.title = title;
        this.periodicity = periodicity;
        this.isGlossy = isGlossy;
        this.isColor = isColor;
        this.pageCount = size;
    }

    public String getTitle() {
        return title;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public boolean isGlossy() {
        return isGlossy;
    }

    public boolean isColor() {
        return isColor;
    }

    public int getPageCount() {
        return pageCount;
    }
}
