package com.github.peacetrue.sql.metadata;

/**
 * sql类型转换为java类型
 *
 * @author xiayx
 * @see java.sql.Types
 * @see java.sql.SQLType
 * @see java.sql.JDBCType
 */
public interface SqlTypeToJavaType {

    /**
     * 获取java类型
     *
     * @param sqlType sql类型
     * @return java类型
     */
    Class<?> getJavaType(int sqlType);

}
