package com.gupao.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2019/3/18.
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;
    private Connection connection;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> mapper, Object[] objects) throws Exception {
        try {
//        获取连接
            Connection con = this.getConnection();
//创建语句集
            PreparedStatement ps = this.createPreparedStatement(sql, con);
//执行语句集
            ResultSet resultSet = this.executeQuery(ps, objects);
//处理结果
            List<?> result = this.pareResultSet(resultSet, mapper);
//        关闭结果集
            this.closeResultSet(resultSet);
//关闭语句集
            this.closePreparedStatement(ps);
//关闭连接或者归还连接
            this.closeConnection(con);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
//
        return null;
//
    }

    protected PreparedStatement createPreparedStatement(String sql, Connection con) throws SQLException {
        return con.prepareStatement(sql);
    }

    ;

    protected ResultSet executeQuery(PreparedStatement ps, Object[] objects) throws SQLException {
        for (int n = 0; n < objects.length; n++) {
            ps.setObject(n, objects[n]);
        }
        return ps.executeQuery();
    }

    ;

    protected List<?> pareResultSet(ResultSet resultSet, RowMapper<?> mapper) throws Exception {
        List<Object> list = new ArrayList<Object>();
        int n = 1;
        while (resultSet.next()) {
            list.add(mapper.mapRow(resultSet, n++));
        }
        return list;
    }

    ;

    protected void closePreparedStatement(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    ;

    protected void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    ;

    protected void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    ;

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
