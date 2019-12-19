package by.epam.pavelshakhlovich.paperxml.dataobject;

import by.epam.pavelshakhlovich.paperxml.entity.Booklet;
import by.epam.pavelshakhlovich.paperxml.entity.Magazine;
import by.epam.pavelshakhlovich.paperxml.entity.Newspaper;
import by.epam.pavelshakhlovich.paperxml.entity.Paper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.example.papers package.
 * <p>An ObjectFactory allows you to programmatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Magazine_QNAME = new QName("http://www.example.com/papers", "magazine");
    private final static QName _Booklet_QNAME = new QName("http://www.example.com/papers", "booklet");
    private final static QName _Paper_QNAME = new QName("http://www.example.com/papers", "paper");
    private final static QName _Newspaper_QNAME = new QName("http://www.example.com/papers", "newspaper");


    public ObjectFactory() {
    }

    public PapersDataObject createPapers() {
        return new PapersDataObject();
    }

    public Newspaper createNewspaper() {
        return new Newspaper();
    }


    public Magazine createMagazine() {
        return new Magazine();
    }

    public Booklet createBooklet() {
        return new Booklet();
    }


    @XmlElementDecl(namespace = "http://www.example.com/papers", name = "magazine",
            substitutionHeadNamespace = "http://www.example.com/papers", substitutionHeadName = "paper")
    public JAXBElement<Magazine> createMagazine(Magazine value) {
        return new JAXBElement<Magazine>(_Magazine_QNAME, Magazine.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.example.com/papers", name = "booklet",
            substitutionHeadNamespace = "http://www.example.com/papers", substitutionHeadName = "paper")
    public JAXBElement<Booklet> createBooklet(Booklet value) {
        return new JAXBElement<Booklet>(_Booklet_QNAME, Booklet.class, null, value);
    }


    @XmlElementDecl(namespace = "http://www.example.com/papers", name = "paper")
    public JAXBElement<Paper> createPaper(Paper value) {
        return new JAXBElement<Paper>(_Paper_QNAME, Paper.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/papers", name = "newspaper",
            substitutionHeadNamespace = "http://www.example.com/papers", substitutionHeadName = "paper")
    public JAXBElement<Newspaper> createNewspaper(Newspaper value) {
        return new JAXBElement<Newspaper>(_Newspaper_QNAME, Newspaper.class, null, value);
    }

}
