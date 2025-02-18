package com.aurionpro.adapter.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.adapter.model.Biscuit;
import com.aurionpro.adapter.model.Chocolate;
import com.aurionpro.adapter.model.HatAdapter;
import com.aurionpro.adapter.model.IItem;

public class AdapterTest {

	public static void main(String[] args) {
		List<IItem> shoppingCart = new ArrayList<IItem>();

		shoppingCart.add(new Biscuit("GoodDay", 50));
		shoppingCart.add(new Chocolate("DairyMilk", 40));
		shoppingCart.add(new HatAdapter("HHat", "HunterHat", 500, 10));

		System.out.println("Your Shopping Cart: ");

		System.out.println();

		for (IItem iItem : shoppingCart) {
			System.out.println(iItem.displayName() + " ---> " + iItem.displayFinalPrice());
		}
		System.out.println();
		
		double totalPrice = shoppingCart.stream()
				.mapToDouble((item) -> item.displayFinalPrice())
				.sum();
		
		System.out.println("Total Price: " + totalPrice);
	}

}
