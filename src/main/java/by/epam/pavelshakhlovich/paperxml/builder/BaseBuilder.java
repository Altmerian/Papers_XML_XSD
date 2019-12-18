package by.epam.pavelshakhlovich.paperxml.builder;

import by.epam.pavelshakhlovich.paperxml.entity.Paper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBuilder {
    protected List<Paper> papersList= new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger();

    public List<Paper> getPapersList() {
        return papersList;
    }

    public abstract void buildPaperList();
}
