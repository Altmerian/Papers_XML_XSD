package by.epam.pavelshakhlovich.paperxml.entity;

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
        return "Magazine{" + super.toString() +
                "subscriptionIndex=" + subscriptionIndex +
                '}';
    }

    public XMLGregorianCalendar getFirstIssueDate() {
        return firstIssueDate;
    }

    public void setFirstIssueDate(XMLGregorianCalendar value) {
        this.firstIssueDate = value;
    }

    public String getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(String value) {
        this.subscriptionIndex = value;
    }

}
