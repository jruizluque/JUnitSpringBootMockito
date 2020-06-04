package com.in28minutes.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.unittesting.unittesting.model.Item;

//@RunWith(SpringRunner.class) Note: JUnit4
@ExtendWith(SpringExtension.class) // Note: JUnit5 for backwards compatibility, can be removed
@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;
    
    @Test
    void testFindAll() {
        /* Note: in this test we are testing something more than the repository
         * because @DataJpaTest is launching the in memory db and populating it with data.sql
         * You can move the data.sql to src/test/resources so the in memory db
         * is only used for unit testing
         */
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

}
