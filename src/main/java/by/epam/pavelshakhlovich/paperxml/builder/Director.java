package by.epam.pavelshakhlovich.paperxml.builder;

import by.epam.pavelshakhlovich.paperxml.entity.Paper;

import java.util.List;

public class Director {
    public static List<Paper> createPaperList(BaseBuilder builder) {
        builder.buildPaperList();
        return builder.getPapersList();
    }
}
