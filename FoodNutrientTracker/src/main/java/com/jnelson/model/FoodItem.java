package com.jnelson.model;

public class FoodItem {
    String description;
    String brandName;
    int fdcId;
    public FoodItem() {
    }

    public FoodItem(String description, String brandName) {
        this.description = description;
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "description='" + description + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
