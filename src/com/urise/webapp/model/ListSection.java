package com.urise.webapp.model;

public class ListSection extends AbstractSection{
    private String[] items;

    public ListSection(String... items) {
        this.items = items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
