package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Organization {
    private String title;
    private String website;
    private List<Period> periods;

    public Organization(String title, String website, List<Period> periods) {
        this.title = title;
        this.website = website;
        this.periods = periods;
    }

    public Organization(String title, String website, Period... periods) {
        this.title = title;
        this.website = website;
        this.periods = Arrays.asList(periods);
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
        return title + " " + website + " " + periods;
    }
}
