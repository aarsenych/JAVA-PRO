package com.gmail.arsenycholexandra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;

public class TestClass {
    @Save
    private String name;

    @Save
    private String country;

    public TestClass(String name, String country) {
        this.name = name;

        this.country = country;
    }

    public TestClass() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }


}
