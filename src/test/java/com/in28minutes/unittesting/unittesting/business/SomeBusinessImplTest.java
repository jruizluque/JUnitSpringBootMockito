package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {
	
	@Test
	void calculateSum_basic() {
		SomeBusinessImpl business =  new SomeBusinessImpl();
		int[] data = {1, 2, 3};
		int actualResult = business.calculateSum(data);
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSum_empty() {
		SomeBusinessImpl business =  new SomeBusinessImpl();
		int[] data = {};
		int actualResult = business.calculateSum(data);
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSum_one() {
		SomeBusinessImpl business =  new SomeBusinessImpl();
		int[] data = {5};
		int actualResult = business.calculateSum(data);
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
