package com.qf.util.test;

import com.qf.entity.UserAddress;
import com.qf.util.DBUtils;

import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        DBUtils<UserAddress> dbUtils = new DBUtils<>();
        Connection connection = dbUtils.getConnection();
        System.out.println("数据库连接" + connection);
    }
}
