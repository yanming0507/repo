package com.gupao.pattern.template.jdbc;

import java.util.List;

/**
 * Created by Yan on 2019/3/18.
 */
public class MemberDaoTest {
    public static void main(String[] args) throws Exception {
        MemberDao dao=new MemberDao(null);
        List<?>list=dao.selectAll();
        System.out.println(list);
    }
}
