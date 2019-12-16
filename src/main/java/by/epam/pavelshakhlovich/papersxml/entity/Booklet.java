package by.epam.pavelshakhlovich.papersxml.entity;

public class Booklet extends Paper {
    private String author;

    public Booklet() {
    }

    public Booklet(String title, boolean isGlossy, boolean isColor, int size, String author) {
        super(title, Periodicity.UNCERTAIN, isGlossy, isColor, size);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
