package com.in28minutes.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

// Launch a Spring context
//@RunWith(SpringRunner.class) Note: JUnit4
@ExtendWith(SpringExtension.class) // Note: JUnit5 for backwards compatibility, can be removed
/*
 * Note: it launches de complte Spring Boot Application, thus Integration Test (IT)
 * It searches the @SpringBootApplication to start the complete Spring Boot Application context
 * and an in memory database
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @MockBean
    ItemRepository repository;
    
    @Test
    public void contextLoads() throws JSONException {
        /*
         * With this and @MockBean we are mocking the repository instead of using the in memory database
         */
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(10001, "Item2", 10, 20),
                new Item(10002, "Item2", 10, 20),
                new Item(10003, "Item2", 10, 20)
                ));
        
        String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001,value:200},{id:10002},{id:10003}]", response, false);
    }

}
