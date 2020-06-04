package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessServiceImpl implements ItemBusinessService {

	@Autowired
	private ItemRepository repostory;
	
	@Override
	public Item returnHarcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@Override
	public List<Item> retrieveAllItems() {
		return repostory.findAll();
	}
	
	

}
