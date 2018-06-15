package com.endava.bod.challenge.api.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notification {

    private String book;
    private List<Path> paths = new ArrayList<>();

    public Notification() {}

    public Notification(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }

    public void setBookName(String book) {
        this.book = book;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {

        return Objects.hash(book);
    }
}
