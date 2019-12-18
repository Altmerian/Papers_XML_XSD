package by.epam.pavelshakhlovich.paperxml.dataobject;

import by.epam.pavelshakhlovich.paperxml.entity.Booklet;
import by.epam.pavelshakhlovich.paperxml.entity.Magazine;
import by.epam.pavelshakhlovich.paperxml.entity.Newspaper;
import by.epam.pavelshakhlovich.paperxml.entity.Paper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "papers"
})
@XmlRootElement(name = "Papers")
public class DataObject {
    @XmlElementRef(name = "paper", namespace = "http://www.example.com/papers", type = JAXBElement.class)
    protected List<JAXBElement<? extends Paper>> papers;

    /**
     * Gets the value of the paper property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paper property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaper().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Booklet }{@code >}
     * {@link JAXBElement }{@code <}{@link Magazine }{@code >}
     * {@link JAXBElement }{@code <}{@link Newspaper }{@code >}
     * {@link JAXBElement }{@code <}{@link Paper }{@code >}
     */
    public List<JAXBElement<? extends Paper>> getPapers() {
        if (papers == null) {
            papers = new ArrayList<>();
        }
        return this.papers;
    }

    @Override
    public String toString() {
        return "Papers:\n " +
                papers.stream()
                        .map(x -> x.getValue().toString())
                        .collect(Collectors.joining("; "));

    }
}
