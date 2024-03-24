package com.urise.webapp.model;

import java.util.List;

public class Organization {

    private final String title;
    private final String website;
    private final List<Period> periods;

    public Organization(String title, String website, List<Period> periods) {
        this.title = title;
        this.website = website;
        this.periods = periods;
    }

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", website='" + website + '\'' +
                ", periods=" + periods +
                '}';
    }
}
