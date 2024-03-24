package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends AbstractSection{
    private final List<String> elements = new ArrayList<String>();

    public ListSection(SectionType type) {
        super(type);
    }

    public List<String> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "type=" + getType() + ", " +
                "elements=" + elements +
                '}';
    }

    public void addElement(String element) {
        elements.add(element);
    }

    public void removeElement(int index) {
        elements.remove(index);
    }

    public void setElement(int index, String element) {
        elements.set(index, element);
    }

}
