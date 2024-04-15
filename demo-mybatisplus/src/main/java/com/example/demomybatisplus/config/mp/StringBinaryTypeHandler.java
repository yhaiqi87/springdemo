package com.example.demomybatisplus.config.mp;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * java String 与 mysql binary 互相转换
 */
@MappedTypes(value = String.class)
@MappedJdbcTypes(value = JdbcType.BINARY)
public class StringBinaryTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String o, JdbcType jdbcType) throws SQLException {
        preparedStatement.setBinaryStream(i, StringUtils.isBlank(o) ? null : new ByteArrayInputStream(parseHexString(o)));
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return toHexString(resultSet.getBytes(s));
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return toHexString(resultSet.getBytes(i));
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return toHexString(callableStatement.getBytes(i));
    }

    private byte[] parseHexString(String s) {
        if (s == null) {
            return null;
        }
        if (!isValid(s)) {
            throw new IllegalArgumentException("invalid hexadecimal representation of an ObjectId: [" + s + "]");
        } else {
            byte[] b = new byte[12];

            for (int i = 0; i < b.length; ++i) {
                b[i] = (byte) Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
            }

            return b;
        }
    }

    private boolean isValid(String hexString) {
        if (hexString == null) {
            throw new IllegalArgumentException();
        } else {
            int len = hexString.length();
            if (len != 24) {
                return false;
            } else {
                for (int i = 0; i < len; ++i) {
                    char c = hexString.charAt(i);
                    if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private String toHexString(byte[] var3) {
        if (var3 == null) {
            return null;
        }
        char[] chars = new char[24];
        int i = 0;

        for (byte b : var3) {
            chars[i++] = HEX_CHARS[b >> 4 & 15];
            chars[i++] = HEX_CHARS[b & 15];
        }

        return new String(chars);
    }
}
