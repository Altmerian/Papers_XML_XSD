package by.epam.pavelshakhlovich.paperxml.jaxb;

import by.epam.pavelshakhlovich.paperxml.dataobject.PapersDataObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class JaxBTest {
    private static final String XML_FILE = "data/papers.xml";
    private static final String XSD_FILE = "data/papers.xsd";
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testUnmarshalPapers() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("by.epam.pavelshakhlovich.paperxml.dataobject");

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema paperSchema = sf.newSchema(new File(XSD_FILE));
            jaxbUnmarshaller.setSchema(paperSchema);

            PapersDataObject papersDataObject = (PapersDataObject) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            LOGGER.info(papersDataObject);
            Assert.assertNotNull(papersDataObject);

        } catch (JAXBException e) {
            LOGGER.error("JAXBException " + e);
        } catch (SAXException e) {
            LOGGER.error("SAXException " + e);
        }
    }
}
