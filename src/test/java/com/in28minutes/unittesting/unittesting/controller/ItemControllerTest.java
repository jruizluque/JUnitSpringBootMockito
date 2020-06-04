package com.in28minutes.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

//@RunWith(SpringRunner.class) Note: JUnit4
@ExtendWith(SpringExtension.class) // Note: JUnit5 for backwards compatibility, can be removed
@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	void dummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
		        .andExpect(status().isOk())
		        .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
		        .andReturn();
	}
	
	@Test
	void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.returnHarcodedItem()).thenReturn(
				new Item(2, "Item2", 10, 10));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,price:10}"))
				.andReturn();
	}
	
	@Test
	void retrieveAllItems_basic() throws Exception {
		
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(
						new Item(2, "Item2", 10, 10), 
						new Item(3, "Item3", 20, 20),
						new Item(4, "Item4", 30, 30)
				));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("["
						+ "{id:2,name:Item2,price:10},"
						+ "{id:3,name:Item3,price:20},"
						+ "{}"
						+ "]"))
				.andReturn();
	}

}
