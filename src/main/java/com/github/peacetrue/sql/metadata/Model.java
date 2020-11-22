package com.github.peacetrue.sql.metadata;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 模型
 *
 * @author xiayx
 */
@Data
public class Model {

    /** 名称，UpperCamel格式，例如：UpperCamel */
    private String name;
    /** 本国 name */
    private String nationalName;
    /** 属性 */
    private List<ModelProperty> properties;
    /** 主键属性名 */
    private List<String> primaryKeys;
    /** 注释 */
    private String comment;

    public List<ModelProperty> getPrimaryKeyProperties() {
        return properties.stream().filter(property -> primaryKeys.contains(property.getName())).collect(Collectors.toList());
    }

    public String getPrimaryKey() {
        return primaryKeys.get(0);
    }

    public ModelProperty getPrimaryKeyProperty() {
        return properties.stream().filter(property -> property.getName().equals(getPrimaryKey())).findAny().orElse(null);
    }

}
