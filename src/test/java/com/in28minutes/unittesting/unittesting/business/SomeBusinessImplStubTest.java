package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class SomeDataServiceOneElementStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
}

class SomeBusinessImplStubTest {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business =  new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingdataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business =  new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingdataService();// new int[] data = {};
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_one() {
		SomeBusinessImpl business =  new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingdataService();// new int[] data = {5};
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
