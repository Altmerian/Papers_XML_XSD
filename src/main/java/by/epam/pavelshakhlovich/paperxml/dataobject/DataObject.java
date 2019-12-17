package by.epam.pavelshakhlovich.paperxml.dataobject;

import by.epam.pavelshakhlovich.paperxml.entity.Paper;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "papers", namespace = "http://www.example.com/papers")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataObject {
    @XmlElement(name="paper")
    List<Paper> papers = new ArrayList<>();

    @Override
    public String toString() {
        return papers.toString();
    }
}
