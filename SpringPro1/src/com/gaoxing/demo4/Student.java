package com.gaoxing.demo4;

public class Student {
    private String name;
    private Integer age;
    private Dog dog;

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }
}
