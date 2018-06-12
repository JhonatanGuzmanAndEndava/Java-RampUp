package com.endava.bod.challenge.dataprocessing;

import java.util.List;
import java.util.Objects;

public class Staffs {
    private List<Employee> Staffs;

    public Staffs(List<Employee> Staffs) {
        this.Staffs = Staffs;
    }

    public List<Employee> getStaffs() {
        return Staffs;
    }

    public void setStaffs(List<Employee> staffs) {
        Staffs = staffs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staffs staffs = (Staffs) o;
        return Objects.equals(Staffs, staffs.Staffs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Staffs);
    }

    @Override
    public String toString() {
        return "Staffs{" +
                "Staffs=" + Staffs +
                '}';
    }
}
