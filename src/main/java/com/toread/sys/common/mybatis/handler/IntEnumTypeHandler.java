package com.toread.sys.common.mybatis.handler;

import com.toread.sys.common.enums.IntEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 黎志兵
 */
public class IntEnumTypeHandler<E extends Enum<E> & IntEnum<E>> extends
        BaseTypeHandler<IntEnum> {
    private Class<IntEnum> type;

    public IntEnumTypeHandler(Class<IntEnum> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
    }

    private IntEnum convert(int status) {
        IntEnum[] objs = type.getEnumConstants();
        for (IntEnum em : objs) {
            if (em.code() == status) {
                return em;
            }
        }
        return null;
    }

    @Override
    public IntEnum getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return convert(rs.getInt(columnName));
    }

    @Override
    public IntEnum getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return convert(rs.getInt(columnIndex));
    }

    @Override
    public IntEnum getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return convert(cs.getInt(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    IntEnum enumObj, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, enumObj.code());
    }
}
