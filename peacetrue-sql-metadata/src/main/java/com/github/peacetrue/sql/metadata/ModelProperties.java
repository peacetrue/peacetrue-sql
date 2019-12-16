package com.github.peacetrue.sql.metadata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author xiayx
 */
@Data
@ConfigurationProperties(prefix = "peacetrue.sql")
public class ModelProperties {
    /** 忽略的表名 */
    private List<String> ignoredTableNames;
}
