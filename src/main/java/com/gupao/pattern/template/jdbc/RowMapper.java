package com.gupao.pattern.template.jdbc;

import java.sql.ResultSet;

/**
 * Created by Yan on 2019/3/18.
 */
public interface RowMapper <T>{
    T mapRow(ResultSet rs,int rowNum)throws Exception;
}
