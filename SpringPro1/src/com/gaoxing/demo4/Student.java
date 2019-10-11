package com.gaoxing.demo4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private Integer age;
    private Dog dog;
    private String dogName;
    /* 集合类型 */
    // 字符串数组
    private String[] attr;
    // list集合
    private List list;
    // set集合
    private Set mySet;
    // map集合
    private Map myMap;

    public void setMyMap(Map myMap) {
        this.myMap = myMap;
    }

    public void setMySet(Set mySet) {
        this.mySet = mySet;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setAttr(String[] attr) {
        this.attr = attr;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

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
                ", dogName='" + dogName + '\'' +
                ", attr=" + Arrays.toString(attr) +
                ", list=" + list +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                '}';
    }
}
