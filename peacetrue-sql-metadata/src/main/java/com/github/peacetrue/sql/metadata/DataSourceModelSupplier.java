package com.github.peacetrue.sql.metadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Nullable;
import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 从数据源中获取模型信息
 *
 * @author xiayx
 */
public class DataSourceModelSupplier implements ModelSupplier {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TableNameToModelName tableNameToModelName;
    @Autowired
    private ColumnNameToPropertyName columnNameToPropertyName;
    @Autowired
    private SqlTypeToJavaType sqlTypeToJavaType;
    /** 表过滤器，返回true表示包含，false表示排除 */
    @Autowired
    @Qualifier("TABLE_FILTER")
    private Predicate<String> tableFilter;

    @Override
    public List<Model> getModels() {
        logger.info("从数据源[{}]中获取模型信息", dataSource);
        try {
            return getModelsThrow();
        } catch (SQLException e) {
            throw new IllegalStateException(String.format("从数据源[%s]中读取模型异常", dataSource), e);
        }
    }

    private List<Model> getModelsThrow() throws SQLException {
        List<Model> models = new ArrayList<>();
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            logger.info("读取表[{}]", tableName);
            if (!tableFilter.test(tableName)) {
                logger.debug("表[{}]已被配置为忽略", tableName);
                continue;
            }
            String modelName = tableNameToModelName.getModelName(tableName);

            Model model = new Model();
            model.setName(modelName);
            model.setComment(tables.getString("REMARKS"));
            model.setProperties(new ArrayList<>());
            ResultSet columns = metaData.getColumns(null, null, tableName, null);
            while (columns.next()) {
                String columnName = columns.getString(ColumnDescriptionUtils.COLUMN_NAME);
                logger.info("读取列[{}.{}]", tableName, columnName);
                model.getProperties().add(new ModelProperty(
                        columnNameToPropertyName.getPropertyName(tableName, columnName),
                        sqlTypeToJavaType.getJavaType(columns.getInt(ColumnDescriptionUtils.DATA_TYPE)),
                        ColumnDescriptionUtils.nullableToBoolean(columns.getInt(ColumnDescriptionUtils.NULLABLE)),
                        columns.getInt(ColumnDescriptionUtils.COLUMN_SIZE),
                        columns.getString(ColumnDescriptionUtils.REMARKS)
                ));
            }
            logger.debug("构造模型[{}]", model);
            models.add(model);
        }
        return models;
    }


}
