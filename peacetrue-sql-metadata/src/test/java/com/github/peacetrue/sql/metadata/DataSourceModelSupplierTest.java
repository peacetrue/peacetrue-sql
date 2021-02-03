package com.github.peacetrue.sql.metadata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @author xiayx
 */
@SpringBootTest(classes = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        MetadataSqlAutoConfiguration.class
})
@ActiveProfiles("mysql")
public class DataSourceModelSupplierTest {

    @Autowired
    private ModelSupplier modelSupplier;

    @Test
    public void getModels() {
        List<Model> models = modelSupplier.getModels();
        System.out.println(models);
        Assertions.assertEquals(1, models.size());
    }
}
