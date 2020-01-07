package com.github.peacetrue.sql.metadata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author xiayx
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        MetadataSqlAutoConfiguration.class
})
@ActiveProfiles("model")
public class DataSourceModelSupplierTest {

    @Autowired
    private ModelSupplier modelSupplier;

    @Test
    public void getModels() {
        List<Model> models = modelSupplier.getModels();
        Assert.assertEquals(1, models.size());
    }
}