package com.github.peacetrue.sql.metadata;

import java.util.Objects;

/**
 * @author : xiayx
 * @since : 2020-11-22 09:02
 **/
public class DefaultCommentToNationalName implements CommentToNationalName {

    private final String separator;

    public DefaultCommentToNationalName() {
        this(".");
    }

    public DefaultCommentToNationalName(String separator) {
        this.separator = Objects.requireNonNull(separator);
    }

    @Override
    public String getNationalName(String tableName, String comment) {
        if (comment == null) return null;
        int index = comment.indexOf(separator);
        return index == -1 ? comment : comment.substring(0, index);
    }

}
