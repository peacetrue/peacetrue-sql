package com.github.peacetrue.sql.metadata;

/**
 * 表名转换为模型名称
 *
 * @author xiayx
 */
public interface TableNameToModelName {

    /**
     * 获取表名对应的模型名称
     *
     * @param tableName 表名
     * @return 表名对应的模型名称
     */
    String getModelName(String tableName);

}
