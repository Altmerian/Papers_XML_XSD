package by.epam.pavelshakhlovich.paperxml.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
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

    @Override
    public String toString() {
        return "Paper{" +
                "title='" + title + '\'' +
                ", periodicity=" + periodicity +
                ", isGlossy=" + isGlossy +
                ", isColor=" + isColor +
                ", pageCount=" + pageCount +
                '}';
    }
}
