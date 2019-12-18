package by.epam.pavelshakhlovich.paperxml.entity;

import java.util.Arrays;

public enum PaperTagsEnum {
    PAPERS("Papers"),
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine"),
    BOOKLET("booklet"),
    IS_GLOSSY("isGlossy"),
    IS_COLOR("isColor"),
    PAGE_COUNT("pageCount"),
    FIRST_ISSUE_DATE("firstIssueDate"),
    HAS_WEB_VERSION("hasWebVersion"),
    AUTHOR("author");

    private String title;

    PaperTagsEnum(String title) {
        this.title = title;
    }

    public static PaperTagsEnum getValue(String string) {
        return Arrays.stream(PaperTagsEnum.values())
                .filter(x -> x.title.equals(string))
                .findAny().get();
    }

    public String getTitle() {
        return title;
    }
}

