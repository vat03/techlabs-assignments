package com.aurionpro.model;

public class Cell {
    private char value;

    public Cell() {
        this.value = '-';
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == '-';
    }
}
