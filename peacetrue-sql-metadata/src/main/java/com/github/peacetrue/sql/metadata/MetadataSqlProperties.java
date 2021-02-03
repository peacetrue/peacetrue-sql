package com.github.peacetrue.sql.metadata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.sql.DatabaseMetaData;
import java.util.Set;

/**
 * @author xiayx
 */
@Data
@ConfigurationProperties(prefix = "peacetrue.sql")
public class MetadataSqlProperties {

    /** 包含的表名 */
    private Set<String> includeTableNames;
    /** 忽略的表名 */
    private Set<String> ignoredTableNames;
    /** 注释分隔符 */
    private String commentSeparator = ".";
    /** see {@link DatabaseMetaData#getTables(String, String, String, String[])} */
    private String schemaPattern;
    /** see {@link DatabaseMetaData#getTables(String, String, String, String[])} */
    private String tableNamePattern;

}
