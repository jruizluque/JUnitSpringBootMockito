package com.in28minutes.unittesting.unittesting.business;

import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessServiceImpl implements ItemBusinessService {

	@Override
	public Item returnHarcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

}
