package com.github.peacetrue.sql.metadata;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Types;
import java.util.*;

/**
 * 默认的转换器
 *
 * @author xiayx
 * @see <a href="https://www.service-architecture.com/articles/database/mapping_sql_and_java_data_types.html">mapping_sql_and_java_data_types</a>
 */
public class DefaultSqlTypeToJavaType implements SqlTypeToJavaType {

    public static final Map<Integer, Class<?>> SQL_TYPE_TO_JAVA_TYPE = Collections.unmodifiableMap(getSqlTypeToJavaType());

    private static Map<Integer, Class<?>> getSqlTypeToJavaType() {
        Map<Integer, Class<?>> sqlTypeToJavaType = new HashMap<>();
        sqlTypeToJavaType.put(Types.BIT, Boolean.class);
        sqlTypeToJavaType.put(Types.TINYINT, Byte.class);
        sqlTypeToJavaType.put(Types.SMALLINT, Short.class);
        sqlTypeToJavaType.put(Types.INTEGER, Integer.class);
        sqlTypeToJavaType.put(Types.BIGINT, Long.class);
        sqlTypeToJavaType.put(Types.FLOAT, Float.class);
        sqlTypeToJavaType.put(Types.REAL, Float.class);
        sqlTypeToJavaType.put(Types.DOUBLE, Double.class);
        sqlTypeToJavaType.put(Types.NUMERIC, BigDecimal.class);
        sqlTypeToJavaType.put(Types.DECIMAL, BigDecimal.class);
        sqlTypeToJavaType.put(Types.CHAR, String.class);
        sqlTypeToJavaType.put(Types.VARCHAR, String.class);
        sqlTypeToJavaType.put(Types.LONGVARCHAR, String.class);
        sqlTypeToJavaType.put(Types.DATE, Date.class);
        sqlTypeToJavaType.put(Types.TIME, Time.class);
        /*MAP.put(Types.TIMESTAMP, Timestamp.class);*/
        sqlTypeToJavaType.put(Types.TIMESTAMP, Date.class);
        sqlTypeToJavaType.put(Types.BINARY, Byte[].class);
        sqlTypeToJavaType.put(Types.VARBINARY, Byte[].class);
        sqlTypeToJavaType.put(Types.LONGVARBINARY, Byte[].class);
        return sqlTypeToJavaType;
    }

    @Override
    public Class<?> getJavaType(int sqlType) {
        return Optional.ofNullable(SQL_TYPE_TO_JAVA_TYPE.get(sqlType))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Can't found the java type for sql type[%s]", sqlType)));
    }
}
