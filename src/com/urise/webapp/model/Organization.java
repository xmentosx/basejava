package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private String title;
    private String website;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(title, that.title) && Objects.equals(website, that.website) && Objects.equals(periods, that.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, website, periods);
    }

    private List<Period> periods;

    public Organization(String title, String website, List<Period> periods) {
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(periods, "periods must not be null");
        this.title = title;
        this.website = website;
        this.periods = periods;
    }

    public Organization(String title, String website, Period... periods) {
        this(title, website, Arrays.asList(periods));
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
