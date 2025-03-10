package com.aurionpro.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class StringList {
	private ArrayList<String> stringList;

	public StringList() {
		this.stringList = new ArrayList<>();
	}

	public void addString(String string) {
		stringList.add(string);
	}
	
	public ArrayList<String> getList() {
        return stringList;
    }

	public ArrayList<String> removeDuplicates() {
		return new ArrayList<>(new LinkedHashSet<>(stringList));
	}
}
