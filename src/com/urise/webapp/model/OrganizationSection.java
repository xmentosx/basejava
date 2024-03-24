package com.urise.webapp.model;

public class OrganizationSection extends AbstractSection{
    private Organization[] organizations;

    public OrganizationSection(Organization... organizations) {
        this.organizations = organizations;
    }

    public void setOrganizations(Organization[] organizations) {
        this.organizations = organizations;
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
