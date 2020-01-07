package com.github.peacetrue.sql.metadata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * @author xiayx
 */
@Data
@ConfigurationProperties(prefix = "peacetrue.sql")
public class MetadataSqlProperties {

    /** 忽略的表名 */
    private Set<String> ignoredTableNames;

}
