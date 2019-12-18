package by.epam.pavelshakhlovich.paperxml.entity;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Newspaper", propOrder = {
        "firstIssueDate",
        "hasWebVersion"
})
public class Newspaper extends Paper {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar firstIssueDate;
    protected boolean hasWebVersion;
    @XmlAttribute(name = "subscriptionIndex")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String subscriptionIndex;

    public Newspaper() {
    }

    public Newspaper(String title, Periodicity periodicity, boolean isColor, int size,
                     boolean hasWebVersion, String subscriptionIndex) {
        super(title, periodicity, false, isColor, size);
        this.hasWebVersion = hasWebVersion;
        this.subscriptionIndex = subscriptionIndex;
    }

    @Override
    public String toString() {
        return "Newspaper {" + super.toString() +
                ", hasWebVersion=" + hasWebVersion +
                ", firstIssueDate=" + firstIssueDate +
                ", subscriptionIndex=" + subscriptionIndex +
                '}';
    }

    public XMLGregorianCalendar getFirstIssueDate() {
        return firstIssueDate;
    }


    public void setFirstIssueDate(String s) {
        XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
        String year = s.substring(0, 4);
        date.setYear(Integer.parseInt(year));
        String month = s.substring(5, 7);
        date.setMonth(Integer.parseInt(month));
        String day = s.substring(8);
        date.setDay(Integer.parseInt(day));
        this.firstIssueDate = date;
    }

    public boolean hasWebVersion() {
        return hasWebVersion;
    }

    public void setHasWebVersion(boolean value) {
        this.hasWebVersion = value;
    }

    public String getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(String value) {
        this.subscriptionIndex = value;
    }

}
