package com.aurionpro.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String>  student = new HashMap<Integer, String>();
		
		student.put(1, "Abc");
		student.put(2, "Def");
		student.put(3, "Ghi");
		
		//System.out.println(student);
		
		Set<Entry <Integer, String>> studentEntries = student.entrySet();
		
		for (Entry<Integer, String> entry : studentEntries) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
	}
}
