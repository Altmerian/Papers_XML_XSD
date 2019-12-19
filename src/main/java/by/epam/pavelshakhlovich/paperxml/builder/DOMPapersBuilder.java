package by.epam.pavelshakhlovich.paperxml.builder;

import by.epam.pavelshakhlovich.paperxml.entity.Booklet;
import by.epam.pavelshakhlovich.paperxml.entity.Magazine;
import by.epam.pavelshakhlovich.paperxml.entity.Newspaper;
import by.epam.pavelshakhlovich.paperxml.entity.Paper;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DOMPapersBuilder extends BasePapersBuilder {

    @Override
    public void buildPaperList() {
        LOGGER.info("DOM parsing started.");
        DOMParser parser = new DOMParser();
        try {
            parser.parse("data/papers.xml");
        } catch (SAXException e) {
            LOGGER.error("DOM - SAX exception", e);
        } catch (IOException e) {
            LOGGER.error("DOM - IO exception", e);
        }
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        NodeList papersList = root.getChildNodes();
        for (int i = 0; i < papersList.getLength(); i++) {
            if (papersList.item(i).hasChildNodes()) {
                Element paperElement = (Element) papersList.item(i);
                Paper paper = buildPaper(paperElement);
                papers.add(paper);
            }
        }
        LOGGER.info("DOM parsing ended.");
    }

    private Paper buildPaper(Element paperElement) {
        String paperType = paperElement.getNodeName().trim();
        Paper paper = null;
        switch (paperType) {
            case "newspaper" :
                paper = new Newspaper();
                paper.setPeriodicity(paperElement.getAttribute("periodicity"));
                ((Newspaper) paper).setSubscriptionIndex(paperElement.getAttribute("subscriptionIndex"));
                ((Newspaper) paper).setFirstIssueDate(
                        getElementTextContent(paperElement, "firstIssueDate"));
                boolean hasWebVersion = Boolean.parseBoolean(getElementTextContent(
                        paperElement, "hasWebVersion"));
                ((Newspaper) paper).setHasWebVersion(hasWebVersion);
                break;
            case "magazine" :
                paper = new Magazine();
                paper.setPeriodicity(paperElement.getAttribute("periodicity"));
                ((Magazine) paper).setSubscriptionIndex(paperElement.getAttribute("subscriptionIndex"));
                ((Magazine) paper).setFirstIssueDate(
                        getElementTextContent(paperElement, "firstIssueDate"));
                break;
            case "booklet" :
                paper = new Booklet();
                paper.setPeriodicity("uncertain");
                ((Booklet) paper).setAuthor(getElementTextContent(paperElement,"author"));
                break;
            default:
                LOGGER.error("Paper type {} doesn't exists!", paperType);
                }
        if (paper != null) {
            paper.setTitle(paperElement.getAttribute("title"));
            boolean isGlossy = Boolean.parseBoolean(getElementTextContent(paperElement, "isGlossy"));
            paper.setIsGlossy(isGlossy);
            boolean isColor = Boolean.parseBoolean(getElementTextContent(paperElement, "isColor"));
            paper.setIsGlossy(isColor);
            int pageCount = Integer.parseInt(getElementTextContent(paperElement, "pageCount"));
            paper.setPageCount(pageCount);
        }
        return paper;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
