package com.aurionpro.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Computer {
	
	@Value("Apple")
	public String name;
	@Autowired
	public Harddisk harddisk;

	public Computer() {
	}

	public Computer(String name, Harddisk harddisk) {
		this.name = name;
		this.harddisk = harddisk;
	}

	public String getName() {
		return name;
	}

	public Harddisk getHarddisk() {
		return harddisk;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHarddisk(Harddisk harddisk) {
		this.harddisk = harddisk;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", harddisk=" + harddisk.toString() + "]";
	}
}
