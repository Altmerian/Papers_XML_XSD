package by.epam.pavelshakhlovich.paperxml.builder;

import by.epam.pavelshakhlovich.paperxml.entity.Paper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBuilder {
    protected static final Logger LOGGER = LogManager.getLogger();
    protected List<Paper> papersList = new ArrayList<>();

    public abstract void buildPaperList();

    public List<Paper> getPapersList() {
        return papersList;
    }
}
