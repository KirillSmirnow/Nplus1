package np1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Demo {

    @Autowired
    private DataInitializer dataInitializer;

    @Autowired
    private Methods methods;

    @BeforeEach
    public void setUp() {
        dataInitializer.initialize();
        log.info("Data initialized");
    }

    @Test
    public void findAll() {
        methods.findAll();
    }

    @Test
    public void jpql() {
        methods.jpql();
    }

    @Test
    public void entityGraph() {
        methods.entityGraph();
    }

    @Test
    public void criteriaApi() {
        methods.criteriaApi();
    }
}
