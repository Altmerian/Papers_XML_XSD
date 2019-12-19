package by.epam.pavelshakhlovich.paperxml.builder;

import by.epam.pavelshakhlovich.paperxml.entity.Paper;

import java.util.List;

public class PapersDirector {
    public static List<Paper> createPaperList(BasePapersBuilder builder) {
        builder.buildPaperList();
        return builder.getPapers();
    }
}
