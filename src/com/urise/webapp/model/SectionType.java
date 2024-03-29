package com.urise.webapp.model;

import java.util.Objects;

public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private final String title;

    SectionType(String title) {
        Objects.requireNonNull(title, "title must not be null");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}