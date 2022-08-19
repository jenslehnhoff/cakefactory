package cloud.knut.cakefactory.service;

import cloud.knut.cakefactory.domain.Cake;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CatalogServiceIT {

    @Autowired
    CatalogService catalogService;

    @BeforeEach
    @Sql("/truncateAllTables.sql")
    void setup() {

    }

    @Test
    @Sql("/CakeServiceTest.sql")
    void  getCakes(){

        // when
        final List<Cake> cakes = catalogService.getCakes();

        // then
        assertEquals(1, cakes.size());

    }

}