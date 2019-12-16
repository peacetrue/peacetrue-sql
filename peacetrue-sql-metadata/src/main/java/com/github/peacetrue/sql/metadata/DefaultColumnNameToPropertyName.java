package com.github.peacetrue.sql.metadata;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;

/**
 * 默认的转换器.
 * 将短横线分隔式转换为驼峰式
 *
 * @author xiayx
 */
public class DefaultColumnNameToPropertyName implements ColumnNameToPropertyName {

    private static final Converter<String, String> CONVERTER = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.LOWER_CAMEL);

    @Override
    public String getPropertyName(String tableName, String columnName) {
        return CONVERTER.convert(columnName.toLowerCase().replace("`", ""));
    }
}
