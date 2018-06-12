package com.endava.bod.challenge.dataprocessing;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private String referenceNumber;
    private String projectCode;
    private LocalDate startDate;
    private LocalDate endDate;

    public Employee() {}

    public Employee(String referenceNumber, String projectCode) {
        this.referenceNumber = referenceNumber;
        this.projectCode = projectCode;
    }

    public Employee(String referenceNumber, String projectCode, LocalDate startDate, LocalDate endDate) {
        this.referenceNumber = referenceNumber;
        this.projectCode = projectCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(referenceNumber, employee.referenceNumber) &&
                Objects.equals(projectCode, employee.projectCode) &&
                Objects.equals(startDate, employee.startDate) &&
                Objects.equals(endDate, employee.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(referenceNumber, projectCode, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "referenceNumber='" + referenceNumber + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
