package com.github.peacetrue.sql.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模型属性
 *
 * @author xiayx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelProperty {

    /** 名称，lowerCamel格式，例如：lowerCamel */
    private String name;
    /** 类型 */
    private Class<?> type;
    /** 可否为空 */
    private Boolean nullable;
    /** 可否为空 */
    private Integer size;
    /** 注释 */
    private String comment;
}
