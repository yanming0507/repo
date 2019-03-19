package com.gupao.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Yan on 2019/3/18.
 */
public class MemberDao extends JdbcTemplate {
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }
    public List<?> selectAll() throws Exception {
        String sql="select * from t_user";
        return executeQuery(sql, new RowMapper<Member>() {
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {

                Member member=new Member();
                member.setAddress(rs.getString("address"));
                member.setAge(rs.getInt("age"));
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                return member;
            }
        },null);
    }
}
