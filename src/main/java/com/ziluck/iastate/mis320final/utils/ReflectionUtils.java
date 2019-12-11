package com.ziluck.iastate.mis320final.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;

public class ReflectionUtils {
    private static final Class<?> ORACLE_PREPARED_STATEMENT_WRAPPER_CLASS;
    private static final Method GET_ORIGINAL_SQL;

    static {
        try {
            ORACLE_PREPARED_STATEMENT_WRAPPER_CLASS = Class.forName("oracle.jdbc.driver.OraclePreparedStatementWrapper");
            GET_ORIGINAL_SQL = ORACLE_PREPARED_STATEMENT_WRAPPER_CLASS.getDeclaredMethod("getOriginalSql");

            GET_ORIGINAL_SQL.setAccessible(true);
        } catch (ReflectiveOperationException ex) {
            throw new IllegalStateException("Could not find necessary class, method, or field", ex);
        }
    }

    public static String getOriginalSql(PreparedStatement ps) {
        try {
            return (String) GET_ORIGINAL_SQL.invoke(ps);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new IllegalArgumentException("Could not invote getOriginalSql() on PreparedStatement.", ex);
        }
    }
}
