package by.epam.pavelshakhlovich.paperxml.appdemo;

import by.epam.pavelshakhlovich.paperxml.builder.Director;
import by.epam.pavelshakhlovich.paperxml.builder.SAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationDemo {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("parsing results using SAX parser:");
        LOGGER.info(Director.createPaperList(new SAXBuilder()));
//        LOGGER.info("parsing results using DOM parser:");
//        LOGGER.info(Director.createPaperList(new DOMBuilder()));
//        LOGGER.info("parsing results using StAX parser:");
//        LOGGER.info(Director.createPaperList(new StAXBuilder()));
    }
}
