package com.github.peacetrue.sql.metadata;

/**
 * @author xiayx
 */
public class ColumnDescriptionUtils {

    /** 1.String => table catalog (may be null) */
    public static final String TABLE_CAT = "TABLE_CAT";
    /** 2.String => table schema (may be null) */
    public static final String TABLE_SCHEM = "TABLE_SCHEM";
    /** 3.String => table name */
    public static final String TABLE_NAME = "TABLE_NAME";
    /** 4.String => column name */
    public static final String COLUMN_NAME = "COLUMN_NAME";
    /** 5.int => SQL type from java.sql.Types */
    public static final String DATA_TYPE = "DATA_TYPE";
    /** 6.String => Data source dependent type name, for a UDT the type name is fully qualified */
    public static final String TYPE_NAME = "TYPE_NAME";
    /** 7.int => column size */
    public static final String COLUMN_SIZE = "COLUMN_SIZE";
    /** 8.is not used */
    public static final String BUFFER_LENGTH = "BUFFER_LENGTH";
    /** 9.int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable. */
    public static final String DECIMAL_DIGITS = "DECIMAL_DIGITS";
    /** 10.int => Radix (typically either 10 or 2) */
    public static final String NUM_PREC_RADIX = "NUM_PREC_RADIX";
    /**
     * 11.int => is NULL allowed.
     *
     * @see java.sql.DatabaseMetaData#columnNullable
     * @see java.sql.DatabaseMetaData#columnNoNulls
     * @see java.sql.DatabaseMetaData#columnNullableUnknown
     */
    public static final String NULLABLE = "NULLABLE";
    /** 12.String => comment describing column (may be null) */
    public static final String REMARKS = "REMARKS";
    /** 13.String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null) */
    public static final String COLUMN_DEF = "COLUMN_DEF";
    /** 14.int => unused */
    public static final String SQL_DATA_TYPE = "SQL_DATA_TYPE";
    /** 15.int => unused */
    public static final String SQL_DATETIME_SUB = "SQL_DATETIME_SUB";
    /** 16.int => for char types the maximum number of bytes in the column */
    public static final String CHAR_OCTET_LENGTH = "CHAR_OCTET_LENGTH";
    /** 17.int => index of column in table (starting at 1) */
    public static final String ORDINAL_POSITION = "ORDINAL_POSITION";
    /**
     * 18.String => ISO rules are used to determine the nullability for a column.
     * <pre>
     * YES --- if the column can include NULLs
     * NO --- if the column cannot include NULLs
     * empty string --- if the nullability for the column is unknown
     * </pre>
     */
    public static final String IS_NULLABLE = "IS_NULLABLE";
    /** 19.String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF) */
    public static final String SCOPE_CATALOG = "SCOPE_CATALOG";
    /** 20.String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF) */
    public static final String SCOPE_SCHEMA = "SCOPE_SCHEMA";
    /** 21.String => table name that this the scope of a reference attribute (null if the DATA_TYPE isn't REF) */
    public static final String SCOPE_TABLE = "SCOPE_TABLE";
    /** 22.short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF) */
    public static final String SOURCE_DATA_TYPE = "SOURCE_DATA_TYPE";
    /**
     * 23.String => Indicates whether this column is auto incremented
     * <pre>
     * IS_AUTOINCREMENT String => Indicates whether this column is auto incremented
     * YES --- if the column is auto incremented
     * NO --- if the column is not auto incremented
     * empty string --- if it cannot be determined whether the column is auto incremented
     * </pre>
     */
    public static final String IS_AUTOINCREMENT = "IS_AUTOINCREMENT";
    /**
     * 24.String => Indicates whether this is a generated column
     * <pre>
     * YES --- if this a generated column
     * NO --- if this not a generated column
     * empty string --- if it cannot be determined whether this is a generated column
     * </pre>
     */
    public static final String IS_GENERATEDCOLUMN = "IS_GENERATEDCOLUMN";

    public static Boolean nullableToBoolean(int nullable) {
        if (nullable == 1) return true;
        if (nullable == 0) return false;
        return null;
    }

    public static Boolean isNullableToBoolean(String nullable) {
        if ("YES".equals(nullable)) return true;
        if ("NO".equals(nullable)) return false;
        return null;
    }
}
