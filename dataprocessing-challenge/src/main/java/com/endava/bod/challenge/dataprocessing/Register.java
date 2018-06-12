package com.endava.bod.challenge.dataprocessing;

import java.time.Month;
import java.util.Objects;

public class Register {

    private String HrId;
    private String projectCode;
    private int fiscalYear;
    private int period;
    private Month month;

    public Register() {}

    public Register(String hrId, String projectCode, int fiscalYear, int period, String month) {
        HrId = hrId;
        this.projectCode = projectCode;
        this.fiscalYear = fiscalYear;
        this.period = period;

        switch(month) {
            case "Jan":
                this.month = Month.JANUARY;
                break;
            case "Feb":
                this.month = Month.FEBRUARY;
                break;
            case "Mar":
                this.month = Month.MARCH;
                break;
            case "Apr":
                this.month = Month.APRIL;
                break;
            case "May":
                this.month = Month.MAY;
                break;
            case "Jun":
                this.month = Month.JUNE;
                break;
            case "Jul":
                this.month = Month.JULY;
                break;
            case "Aug":
                this.month = Month.AUGUST;
                break;
            case "Sep":
                this.month = Month.SEPTEMBER;
                break;
            case "Oct":
                this.month = Month.OCTOBER;
                break;
            case "Nov":
                this.month = Month.NOVEMBER;
                break;
            case "Dec":
                this.month = Month.DECEMBER;
                break;
        }
    }

    public String getHrId() {
        return HrId;
    }

    public void setHrId(String hrId) {
        HrId = hrId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return Objects.equals(HrId, register.HrId) &&
                Objects.equals(projectCode, register.projectCode) &&
                Objects.equals(fiscalYear, register.fiscalYear) &&
                Objects.equals(period, register.period) &&
                month == register.month;
    }

    @Override
    public int hashCode() {

        return Objects.hash(HrId, projectCode, fiscalYear, period, month);
    }

    @Override
    public String toString() {
        return "Register{" +
                "HrId='" + HrId + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", period='" + period + '\'' +
                ", month=" + month +
                '}';
    }


}
