package by.epam.pavelshakhlovich.paperxml.entity;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Paper", propOrder = {
        "isGlossy",
        "isColor",
        "pageCount"
})
@XmlSeeAlso({
        Newspaper.class,
        Booklet.class,
        Magazine.class
})
public abstract class Paper {
    protected boolean isGlossy;
    protected boolean isColor;
    protected int pageCount;
    @XmlAttribute(name = "title", required = true)
    protected String title;
    @XmlAttribute(name = "periodicity")
    protected Periodicity periodicity;

    public Paper() {
    }

    public Paper(String title, Periodicity periodicity, boolean isGlossy, boolean isColor, int size) {
        this.title = title;
        this.periodicity = periodicity;
        this.isGlossy = isGlossy;
        this.isColor = isColor;
        this.pageCount = size;
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

    public boolean isGlossy() {
        return isGlossy;
    }

    public void setIsGlossy(boolean value) {
        this.isGlossy = value;
    }

    public boolean isColor() {
        return isColor;
    }

    public void setIsColor(boolean value) {
        this.isColor = value;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int value) {
        this.pageCount = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public Periodicity getPeriodicity() {
        if (periodicity == null) {
            return Periodicity.UNCERTAIN;
        } else {
            return periodicity;
        }
    }

    public void setPeriodicity(String value) {
        this.periodicity = Arrays.stream(Periodicity.values())
                .filter(x -> x.name().equalsIgnoreCase(value))
                .findAny().get();
    }

}
