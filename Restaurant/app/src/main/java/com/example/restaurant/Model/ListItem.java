package com.example.restaurant.Model;

public class ListItem {

    private String name;
    private String description;
    private String age;
    private int image;
    public ListItem(String name, String description, String age, int image) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAge() {
        return age;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
