package by.epam.pavelshakhlovich.paperxml.builder;

import by.epam.pavelshakhlovich.paperxml.entity.*;
import org.apache.logging.log4j.Level;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.EnumSet;

public class SAXPapersBuilder extends BasePapersBuilder {

    @Override
    public void buildPaperList() {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            PapersSaxHandler handler = new PapersSaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource("data/papers.xml"));

        } catch (IOException e) {
            LOGGER.error("IO exception", e);
        } catch (SAXException e) {
            LOGGER.error("SAX - SAX exception", e);
        }
    }

    private class PapersSaxHandler extends DefaultHandler {

        private Paper paper = null;
        private PaperTagsEnum currentEnum = null;
        private EnumSet<PaperTagsEnum> withText;

        public PapersSaxHandler() {
            withText = EnumSet.range(PaperTagsEnum.IS_GLOSSY, PaperTagsEnum.AUTHOR);
        }

        public void startElement(String uri, String localName, String qName, Attributes attrs) {
            if ("newspaper".equals(localName)) {
                paper = new Newspaper();
                paper.setTitle(attrs.getValue(0));
                paper.setPeriodicity(attrs.getValue(1));
                ((Newspaper) paper).setSubscriptionIndex(attrs.getValue(2));
            } else if ("magazine".equals(localName)) {
                paper = new Magazine();
                paper.setTitle(attrs.getValue(0));
                paper.setPeriodicity(attrs.getValue(1));
                ((Magazine) paper).setSubscriptionIndex(attrs.getValue(2));
            } else if ("booklet".equals(localName)) {
                paper = new Booklet();
                paper.setTitle(attrs.getValue(0));
                paper.setPeriodicity("uncertain");
            } else {
                PaperTagsEnum temp = PaperTagsEnum.getValue(localName);
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
            }
        }

        public void endElement(String uri, String localName, String qName) {
            if (localName.equals("newspaper") || localName.equals("magazine") || localName.equals("booklet")) {
                papers.add(paper);
            }
        }

        public void characters(char[] ch, int start, int length) {
            String s = new String(ch, start, length).trim();
            if (currentEnum != null) {
                switch (currentEnum) {
                    case IS_GLOSSY:
                        paper.setIsGlossy(Boolean.parseBoolean(s));
                        break;
                    case IS_COLOR:
                        paper.setIsColor(Boolean.parseBoolean(s));
                        break;
                    case PAGE_COUNT:
                        paper.setPageCount(Integer.parseInt(s));
                        break;
                    case FIRST_ISSUE_DATE:
                        if (paper instanceof Newspaper) {
                            ((Newspaper) paper).setFirstIssueDate(s);
                        } else {
                            ((Magazine) paper).setFirstIssueDate(s);
                        }
                        break;
                    case HAS_WEB_VERSION:
                        ((Newspaper) paper).setHasWebVersion(Boolean.parseBoolean(s));
                        break;
                    case AUTHOR:
                        ((Booklet) paper).setAuthor(s);
                        break;
                    default:
                        throw LOGGER.throwing(Level.ERROR, new EnumConstantNotPresentException(
                                currentEnum.getDeclaringClass(), currentEnum.name()));
                }
            }
            currentEnum = null;
        }

        public void startDocument() throws SAXException {
            LOGGER.info("SAX parsing started.");
        }

        public void endDocument() throws SAXException {
            LOGGER.info("SAX parsing ended.");
        }

        public void warning(SAXParseException exception) {
            LOGGER.warn("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
        }

        public void error(SAXParseException exception) {
            LOGGER.error("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
        }

        public void fatalError(SAXParseException exception) throws SAXException {
            LOGGER.fatal("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
            throw (exception);
        }

    }
}

