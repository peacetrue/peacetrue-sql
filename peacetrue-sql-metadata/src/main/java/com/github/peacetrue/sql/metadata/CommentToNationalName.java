package com.github.peacetrue.sql.metadata;

/**
 * @author : xiayx
 * @since : 2020-11-22 08:58
 **/
public interface CommentToNationalName {

    /**
     * @see Model#getComment()
     * @see Model#getNationalName()
     */
    String getNationalName(String tableName, String comment);

    /**
     * @see ModelProperty#getComment()
     * @see ModelProperty#getNationalName()
     */
    default String getNationalName(String tableName, String columnName, String comment) {
        return getNationalName(tableName, comment);
    }

}
