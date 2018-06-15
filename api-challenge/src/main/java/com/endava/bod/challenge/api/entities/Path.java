package com.endava.bod.challenge.api.entities;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<String> paths = new ArrayList<>();

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
