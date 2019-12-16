package com.github.peacetrue.sql.metadata;

/**
 * 列名转换为属性名
 *
 * @author xiayx
 */
public interface ColumnNameToPropertyName {

    /**
     * 获取列名对应的属性名
     *
     * @param tableName  表名
     * @param columnName 列名
     * @return 对应的属性名
     */
    String getPropertyName(String tableName, String columnName);

}
