package com.qf.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DBUtils<T> {
    private static DataSource ds;

    static {
        Properties prop = new Properties();
        try {
            prop.load(DBUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

    /**
     * 更新数据
     *
     * @return
     * @throws SQLException
     */
    public int updateData(String sql, Object... params) {
        QueryRunner qr = new QueryRunner(ds);
        int i = 0;
        try {
            i = qr.update(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询单条数据
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public T querySingle(String sql, Class<T> clazz, Object... params) {
        QueryRunner qr = new QueryRunner(ds);
        try {
            return qr.query(sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询集合
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public List<T> queryList(String sql, Class<T> clazz, Object... params) {
        QueryRunner qr = new QueryRunner(ds);
        try {
            return qr.query(sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询统计单值
     *
     * @param sql
     * @param params
     * @return
     */
    public int queryCount(String sql, Object... params) {
        QueryRunner qr = new QueryRunner(ds);
        try {
            Long count = qr.query(sql, new ScalarHandler<Long>(), params);
            return Integer.parseInt(count.toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }

    public Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
