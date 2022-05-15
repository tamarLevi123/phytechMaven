

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import persistence.entity.ItemEntity;
import persistence.repository.ItemRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;




@ComponentScan(basePackages = {
        "persistence*",
})
@EnableAutoConfiguration
@ContextConfiguration(classes = {ItemRepository.class })
public class ItemRepositoryTest {//extends RepositoryTest {

    @Autowired private ItemRepository repository;

    @Test
    public void injectedRepositoryNotNull() {

        assertNotNull(repository);
    }

    @Test
    public void getItems_getAllItems_findAll() {
        ItemEntity entity = new ItemEntity();
        entity.setId(1);
        entity.setDescription("banana");
        entity.setPrice(1.5);
        entity = repository.save(entity);

        assertEquals(new Integer(1),repository.findAll().stream().findFirst().get().getId());
    }


}