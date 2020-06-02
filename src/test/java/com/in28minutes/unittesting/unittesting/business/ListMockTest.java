package com.in28minutes.unittesting.unittesting.business;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28minutes");
		assertEquals("in28minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	void returnWithGenereicParameters() {
		when(mock.get(anyInt())).thenReturn("in28minutes");
		assertEquals("in28minutes", mock.get(0));
		assertEquals("in28minutes", mock.get(1));
	}
	
	@Test
	void verificationBasics() {
		//SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);		
	}
	
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("SomeString");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}

	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}
	
	@Test
	public void mocking() {
		//Mocks do not retain behavior, I have to stub it
		//Mocks return default values if I don't stub the methods
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}

	@Test
	public void spying() {
		//Spies by the default retain the original behavior, 
		//but I can also stubbed them		
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		arrayListSpy.add("Test3");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test3");
	}
}

