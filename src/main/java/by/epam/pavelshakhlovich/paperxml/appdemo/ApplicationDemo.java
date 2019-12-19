package by.epam.pavelshakhlovich.paperxml.appdemo;

import by.epam.pavelshakhlovich.paperxml.builder.DOMPapersBuilder;
import by.epam.pavelshakhlovich.paperxml.builder.PapersDirector;
import by.epam.pavelshakhlovich.paperxml.builder.SAXPapersBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationDemo {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.trace("Entry");
        LOGGER.info("parsing results using SAX parser:");
        LOGGER.info(PapersDirector.createPaperList(new SAXPapersBuilder()));
        LOGGER.info("parsing results using DOM parser:");
        LOGGER.info(PapersDirector.createPaperList(new DOMPapersBuilder()));
//        LOGGER.info("parsing results using StAX parser:");
//        LOGGER.info(Director.createPaperList(new StAXBuilder()));
        LOGGER.trace("Exit");
    }
}
