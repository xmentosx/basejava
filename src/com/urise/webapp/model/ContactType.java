package com.urise.webapp.model;

import java.util.Objects;

public enum ContactType {
    PHONE("Телефон"),
    MOBILE("Мобильный телефон"),
    HOME_PHONE("Домашний телефон"),
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        Objects.requireNonNull(title, "title must not be null");
        this.title = title;
    }

    public String getTitle() { return title; }

}