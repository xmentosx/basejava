package com.urise.webapp.model;

import java.util.List;

public class OrganizationSection extends AbstractSection{
    private final List<Organization> organizations;

    public OrganizationSection(SectionType type, List<Organization> organizations) {
        super(type);
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "type=" + getType() + ", " +
                "organizations=" + organizations +
                '}';
    }
}
