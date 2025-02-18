package com.aurionpro.decorator.test;

import com.aurionpro.decorator.model.CarInspection;
import com.aurionpro.decorator.model.ICarService;
import com.aurionpro.decorator.model.OilChange;
import com.aurionpro.decorator.model.WheelAlgin;

public class DecoratorTest {

	public static void main(String[] args) {
		ICarService car = new CarInspection();
		OilChange oilChange = new OilChange(car);
		WheelAlgin wheelalign = new WheelAlgin(oilChange);
		System.out.println(wheelalign.getCost());
	}
}
