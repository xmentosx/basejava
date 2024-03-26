package com.urise.webapp.model;

import java.util.Arrays;

public class OrganizationSection extends AbstractSection{
    private Organization[] organizations;

    public OrganizationSection(Organization... organizations) {
        this.organizations = organizations;
    }

    public void setOrganizations(Organization[] organizations) {
        this.organizations = organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Arrays.equals(organizations, that.organizations);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(organizations);
    }

    public Organization[] getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Organization organization : organizations) {
            sb.append(organization).append("\n");
        }
        return sb.toString();
    }
}
