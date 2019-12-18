package by.epam.pavelshakhlovich.paperxml.appdemo;

import by.epam.pavelshakhlovich.paperxml.builder.DOMBuilder;
import by.epam.pavelshakhlovich.paperxml.builder.Director;
import by.epam.pavelshakhlovich.paperxml.builder.SAXBuilder;
import by.epam.pavelshakhlovich.paperxml.builder.StAXBuilder;
import by.epam.pavelshakhlovich.paperxml.dataobject.DataObject;
import by.epam.pavelshakhlovich.paperxml.entity.Paper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDemo {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("parsing results using DOM parser:");
        LOGGER.info(Director.createPaperList(new DOMBuilder()));
        LOGGER.info("parsing results using SAX parser:");
        LOGGER.info(Director.createPaperList(new SAXBuilder()));
        LOGGER.info("parsing results using StAX parser:");
        LOGGER.info(Director.createPaperList(new StAXBuilder()));
    }
}
