package com.urise.webapp.model;

public class TextSection extends AbstractSection{
    private final String content;

    public TextSection(SectionType type, String content) {
        super(type);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "type=" + getType() + ", " +
                "content='" + content + '\'' +
                '}';
    }
}
