package com.endava.bod.challenge.api.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private String code;
    private String title;
    private String superCategoryCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuperCategoryCode() {
        return superCategoryCode;
    }

    public void setSuperCategoryCode(String superCategoryCode) {
        this.superCategoryCode = superCategoryCode;
    }
}
