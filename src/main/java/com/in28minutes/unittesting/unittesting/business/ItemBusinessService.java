package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import com.in28minutes.unittesting.unittesting.model.Item;

public interface ItemBusinessService {

	public Item returnHarcodedItem();

	public List<Item> retrieveAllItems();
	
}
