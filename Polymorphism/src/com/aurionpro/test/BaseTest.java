package com.aurionpro.test;

import com.aurionpro.model.Base;
import com.aurionpro.model.Sub;

public class BaseTest {
	public static void main(String[] args) {
		Base base = new Base();
		Sub sub = new Sub();
		
		base.show();
		sub.show();
		
		base = sub;
		
		base.show();
		
		sub.display();
		
		((Sub) base).display();
	}
}
