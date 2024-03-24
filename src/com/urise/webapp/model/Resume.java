package com.urise.webapp.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;

    private final String fullName;

    private final Map<ContactType, String> contacts = new EnumMap<ContactType, String>(ContactType.class);

    private final Map<SectionType, AbstractSection> sections = new EnumMap<SectionType, AbstractSection>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid) && fullName.equals(resume.fullName);
    }

    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(uuid).append("(").append(fullName).append(")");
        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            sb.append("\n").append(entry.getKey()).append(": ").append(entry.getValue());
        }
        for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
            sb.append("\n").append(entry.getKey()).append(": ").append(entry.getValue());
        }
        return sb.toString();
    }

    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public Map<SectionType, AbstractSection> getSections() {
        return sections;
    }

    public void setContact(ContactType type, String value) {
        contacts.put(type, value);
    }

    public void setSection(SectionType type, AbstractSection section) {
        sections.put(type, section);
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public AbstractSection getSection(SectionType type) {
        return sections.get(type);
    }

    public void removeContact(ContactType type) {
        contacts.remove(type);
    }

    public void removeSection(SectionType type) {
        sections.remove(type);
    }

    public void updateContact(ContactType type, String value) {
        contacts.replace(type, value);
    }

    public void updateSection(SectionType type, AbstractSection section) {
        sections.replace(type, section);
    }

    public void clearContacts() {
        contacts.clear();
    }

    public void clearSections() {
        sections.clear();
    }

    public void clear() {
        contacts.clear();
        sections.clear();
    }

    public boolean hasContact(ContactType type) {
        return contacts.containsKey(type);
    }

    public boolean hasSection(SectionType type) {
        return sections.containsKey(type);
    }

    public boolean hasContacts() {
        return !contacts.isEmpty();
    }

    public boolean hasSections() {
        return !sections.isEmpty();
    }

}
