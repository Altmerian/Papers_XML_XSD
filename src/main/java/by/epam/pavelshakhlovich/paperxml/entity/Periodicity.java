package by.epam.pavelshakhlovich.paperxml.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Periodicity {
    @XmlEnumValue("daily") DAILY,
    @XmlEnumValue("weekly") WEEKLY,
    @XmlEnumValue("monthly") MONTHLY,
    @XmlEnumValue("uncertain") UNCERTAIN
}
