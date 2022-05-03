package com.budailad.entity.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class JsonData {

    private String name;
    private AtomicInteger value;

    public JsonData() {
    }

    public JsonData(String name, AtomicInteger value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AtomicInteger getValue() {
        return value;
    }

    public void setValue(AtomicInteger value) {
        this.value = value;
    }
}
