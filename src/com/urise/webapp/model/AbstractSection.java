package com.urise.webapp.model;

public class AbstractSection {
    private final SectionType type;

    public AbstractSection(SectionType type) {
        this.type = type;
    }

    public SectionType getType() {
        return type;
    }
}
