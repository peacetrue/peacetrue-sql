package com.github.peacetrue.sql.metadata;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 默认的转换器
 *
 * @author xiayx
 * @see <a href="https://www.service-architecture.com/articles/database/mapping_sql_and_java_data_types.html">mapping_sql_and_java_data_types</a>
 */
public class DefaultSqlTypeToJavaType implements SqlTypeToJavaType {

    private static final Map<Integer, Class> MAP = new HashMap<>();

    static {
        MAP.put(Types.BIT, Boolean.class);
        MAP.put(Types.TINYINT, Byte.class);
        MAP.put(Types.SMALLINT, Short.class);
        MAP.put(Types.INTEGER, Integer.class);
        MAP.put(Types.BIGINT, Long.class);
        MAP.put(Types.FLOAT, Float.class);
        MAP.put(Types.REAL, Float.class);
        MAP.put(Types.DOUBLE, Double.class);
        MAP.put(Types.NUMERIC, BigDecimal.class);
        MAP.put(Types.DECIMAL, BigDecimal.class);
        MAP.put(Types.CHAR, String.class);
        MAP.put(Types.VARCHAR, String.class);
        MAP.put(Types.LONGVARCHAR, String.class);
        MAP.put(Types.DATE, Date.class);
        MAP.put(Types.TIME, Time.class);
        /*MAP.put(Types.TIMESTAMP, Timestamp.class);*/
        MAP.put(Types.TIMESTAMP, Date.class);
        MAP.put(Types.BINARY, Byte[].class);
        MAP.put(Types.VARBINARY, Byte[].class);
        MAP.put(Types.LONGVARBINARY, Byte[].class);
    }

    @Override
    public Class getJavaType(int sqlType) {
        return Optional.ofNullable(MAP.get(sqlType))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Can't found the java type for sql type[%s]", sqlType)));
    }
}
