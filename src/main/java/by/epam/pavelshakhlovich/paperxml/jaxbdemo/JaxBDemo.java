package by.epam.pavelshakhlovich.paperxml.jaxbdemo;

import by.epam.pavelshakhlovich.paperxml.dataobject.DataObject;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class JaxBDemo {
    public static void main(String[] args) {

        String xmlFile = "data/papers.xml";
        String xsdFile = "data/papers.xsd";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("by.epam.pavelshakhlovich.paperxml.dataobject");

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema paperSchema = sf.newSchema(new File(xsdFile));
            jaxbUnmarshaller.setSchema(paperSchema);

            DataObject dataObject = (DataObject) jaxbUnmarshaller.unmarshal(new File(xmlFile));
            System.out.println(dataObject);
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }
}

