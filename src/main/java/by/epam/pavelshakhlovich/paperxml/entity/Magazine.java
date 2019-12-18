package by.epam.pavelshakhlovich.paperxml.entity;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Magazine", propOrder = {
        "firstIssueDate"
})
public class Magazine extends Paper {
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar firstIssueDate;
    @XmlAttribute(name = "subscriptionIndex")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String subscriptionIndex;

    public Magazine() {
    }

    public Magazine(String title, Periodicity periodicity, boolean isGlossy, boolean isColor,
                    int size, String subscriptionIndex) {
        super(title, periodicity, isGlossy, isColor, size);
        this.subscriptionIndex = subscriptionIndex;
    }

    @Override
    public String toString() {
        return "Magazine {" + super.toString() +
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

    public String getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(String value) {
        this.subscriptionIndex = value;
    }

}
