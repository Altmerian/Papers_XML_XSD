package by.epam.pavelshakhlovich.paperxml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Booklet", propOrder = {
        "author"
})
public class Booklet extends Paper {
    @XmlElement(required = true)
    protected String author;

    public Booklet() {
    }

    public Booklet(String title, boolean isGlossy, boolean isColor, int size, String author) {
        super(title, Periodicity.UNCERTAIN, isGlossy, isColor, size);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Booklet{" + super.toString() +
                "author='" + author + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
