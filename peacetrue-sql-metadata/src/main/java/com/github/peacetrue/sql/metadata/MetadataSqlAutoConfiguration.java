package com.github.peacetrue.sql.metadata;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author xiayx
 */
@Configuration
@EnableConfigurationProperties(MetadataSqlProperties.class)
public class MetadataSqlAutoConfiguration {

    public static final String DATA_SOURCE_MODEL_SUPPLIER = "dataSourceModelSupplier";
    public static final String TABLE_FILTER = "TABLE_FILTER";

    private MetadataSqlProperties properties;

    public MetadataSqlAutoConfiguration(MetadataSqlProperties properties) {
        this.properties = Objects.requireNonNull(properties);
    }

    @Bean
    @ConditionalOnMissingBean(name = DATA_SOURCE_MODEL_SUPPLIER)
    public DataSourceModelSupplier dataSourceModelSupplier() {
        DataSourceModelSupplier supplier = new DataSourceModelSupplier();
        supplier.setSchemaPattern(properties.getSchemaPattern());
        supplier.setTableNamePattern(properties.getTableNamePattern());
        return supplier;
    }

    @Bean(TABLE_FILTER)
    @ConditionalOnMissingBean(name = TABLE_FILTER)
    public Predicate<String> tableFilter() {
        return tableName -> {
            if (properties.getIncludeTableNames() != null) {
                return properties.getIncludeTableNames().contains(tableName);
            }
            if (properties.getIgnoredTableNames() != null) {
                return !properties.getIgnoredTableNames().contains(tableName);
            }
            return true;
        };
    }

    @Bean
    @ConditionalOnMissingBean(TableNameToModelName.class)
    public TableNameToModelName tableNameToModelName() {
        return new DefaultTableNameToModelName();
    }

    @Bean
    @ConditionalOnMissingBean(ColumnNameToPropertyName.class)
    public ColumnNameToPropertyName columnNameToPropertyName() {
        return new DefaultColumnNameToPropertyName();
    }

    @Bean
    @ConditionalOnMissingBean(SqlTypeToJavaType.class)
    public SqlTypeToJavaType sqlTypeToJavaType() {
        return new DefaultSqlTypeToJavaType();
    }

    @Bean
    @ConditionalOnMissingBean(CommentToNationalName.class)
    public CommentToNationalName commentToNationalName() {
        return new DefaultCommentToNationalName(properties.getCommentSeparator());
    }
}
