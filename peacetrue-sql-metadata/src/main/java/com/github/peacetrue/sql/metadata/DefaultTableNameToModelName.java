package com.github.peacetrue.sql.metadata;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;

/**
 * 默认的转换器.
 * 将短横线分隔式转换为驼峰式
 *
 * @author xiayx
 */
public class DefaultTableNameToModelName implements TableNameToModelName {

    private static final Converter<String, String> CONVERTER = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);

    @Override
    public String getModelName(String tableName) {
        return CONVERTER.convert(tableName);
    }
}
