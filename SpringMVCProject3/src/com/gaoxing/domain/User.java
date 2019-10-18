package com.gaoxing.domain;

import java.util.Arrays;
import java.util.List;

public class User {
    private String user_name;
    private String user_age;
    private String user_hobby[];
    private Dog dog;
    private List<Dog> dogList;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String[] getUser_hobby() {
        return user_hobby;
    }

    public void setUser_hobby(String[] user_hobby) {
        this.user_hobby = user_hobby;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_age='" + user_age + '\'' +
                ", user_hobby=" + Arrays.toString(user_hobby) +
                ", dog=" + dog +
                ", dogList=" + dogList +
                '}';
    }
}
