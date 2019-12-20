package by.epam.pavelshakhlovich.paperxml.builder;

import by.epam.pavelshakhlovich.paperxml.entity.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXPapersBuilder extends BasePapersBuilder {

    @Override
    public void buildPaperList() {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (InputStream input = new FileInputStream("data/papers.xml")) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            papers = process(reader);
        } catch (XMLStreamException e) {
            LOGGER.error("XML stream exception", e);
        } catch (FileNotFoundException fe) {
            LOGGER.error("XML file not found", fe);
        } catch (IOException ioe) {
            LOGGER.error("StAX - IO exception", ioe);
        }
    }

    private List<Paper> process(XMLStreamReader reader) throws XMLStreamException {
        List<Paper> papers = new ArrayList<>();
        Paper paper = null;
        PaperTagsEnum elementName = null;
        LOGGER.info("StAX parsing started");
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = PaperTagsEnum.getValue(reader.getLocalName());
                    switch (elementName) {
                        case NEWSPAPER:
                            paper = new Newspaper();
                            paper.setTitle(reader.getAttributeValue(0));
                            paper.setPeriodicity(reader.getAttributeValue(1));
                            ((Newspaper) paper).setSubscriptionIndex(reader.getAttributeValue(2));
                            break;
                        case MAGAZINE:
                            paper = new Magazine();
                            paper.setTitle(reader.getAttributeValue(0));
                            paper.setPeriodicity(reader.getAttributeValue(1));
                            ((Magazine) paper).setSubscriptionIndex(reader.getAttributeValue(2));
                            break;
                        case BOOKLET:
                            paper = new Booklet();
                            paper.setTitle(reader.getAttributeValue(0));
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    if (paper != null) {
                        switch (elementName) {
                            case IS_GLOSSY:
                                paper.setIsGlossy(Boolean.parseBoolean(text));
                                break;
                            case IS_COLOR:
                                paper.setIsColor(Boolean.parseBoolean(text));
                                break;
                            case PAGE_COUNT:
                                paper.setPageCount(Integer.parseInt(text));
                                break;
                            case FIRST_ISSUE_DATE:
                                if (paper instanceof Newspaper) {
                                    ((Newspaper) paper).setFirstIssueDate(text);
                                } else if (paper instanceof Magazine) {
                                    ((Magazine) paper).setFirstIssueDate(text);
                                }
                                break;
                            case HAS_WEB_VERSION:
                                if (paper instanceof Newspaper) {
                                    ((Newspaper) paper).setHasWebVersion(Boolean.parseBoolean(text));
                                }
                                break;
                            case AUTHOR:
                                if (paper instanceof Booklet) {
                                    ((Booklet) paper).setAuthor(text);
                                }
                                break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    String element = reader.getLocalName();
                    if (element.equals("newspaper") || element.equals("magazine") || element.equals("booklet")) {
                        papers.add(paper);
                    }
                    break;
            }
        }
        LOGGER.info("StAX parsing ended");
        return papers;
    }
}
