package com.example.demomybatisplus.config.mp;

import cn.hutool.json.JSONUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mapper里json型字段到类的映射。
 */
@MappedJdbcTypes(value = JdbcType.VARCHAR)
public class StringJsonTypeHandler<T> extends BaseTypeHandler<T> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
