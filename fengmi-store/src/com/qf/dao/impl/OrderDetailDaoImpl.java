package com.qf.dao.impl;

import com.qf.dao.OrderDetailDao;
import com.qf.entity.OrderDetail;
import com.qf.util.DBUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrderDetailDaoImpl implements OrderDetailDao {
    DBUtils<OrderDetail> dbUtils = new DBUtils<>();

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return dbUtils.updateData("insert into t_orderdetail(oid, gid, num, money) values(?, ?, ?, ?)",
                orderDetail.getOid(),
                orderDetail.getGid(),
                orderDetail.getNum(),
                orderDetail.getMoney());
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return dbUtils.updateData("update t_orderdetail set oid = ?, gid = ?, num = ?, money = ?",
                orderDetail.getOid(),
                orderDetail.getGid(),
                orderDetail.getNum(),
                orderDetail.getMoney());
    }

    @Override
    public int deleteOrderDetail(int id) {
        return dbUtils.updateData("delete from t_orderdetail where id = ?", id);
    }

    @Override
    public List<OrderDetail> selectOrderDetail(int oid) {
        return dbUtils.queryList("select * from t_orderdetail where oid = ?", OrderDetail.class, oid);
    }

    @Override
    public OrderDetail selectOrderDetailById(int id) {
        return dbUtils.querySingle("select * from t_orderdetail where id = ?", OrderDetail.class, id);
    }

    @Override
    public List<Map<String, Object>> getOrderDetailList(String username) {
        DataSource ds = dbUtils.getDS();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        String sql = "select t1.picture, t3.gid, t1.name,t1.star,t1.pubdate,t1.price,t2.num,t3.money " +
                "from t_goods t1 " +
                "inner join t_cartdetail t2 on t1.id=t2.gid " +
                "inner join t_order t3 on t3.gid=t1.id " +
                "inner join t_user t4 on t4.id=t3.uid" +
                " where t4.username = ?  and t3.flag = ?";
        //实例化一个RowMapper接口对象，需要实现他未实现的方法
        RowMapper<Map<String, Object>> rowMapper = new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> map = new TreeMap<>();
                map.put("picture", resultSet.getString("picture"));
                map.put("gid", resultSet.getString("gid"));
                map.put("name", resultSet.getString("name"));
                map.put("star", resultSet.getInt("star"));
                map.put("pubdate", resultSet.getString("pubdate"));
                map.put("price", resultSet.getString("price"));
                map.put("num", resultSet.getInt("num"));
                map.put("money", resultSet.getDouble("money"));
                return map;
            }
        };
        try {
            return jdbcTemplate.query(sql, rowMapper, username, 2);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> getOrderDetailList(String username, int limit) {
        DataSource ds = dbUtils.getDS();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        String sql = "select t1.picture, t3.gid, t1.name,t1.star,t1.pubdate,t1.price,t2.num,t3.money " +
                "from t_goods t1 " +
                "inner join t_cartdetail t2 on t1.id=t2.gid " +
                "inner join t_order t3 on t3.gid=t1.id " +
                "inner join t_user t4 on t4.id=t3.uid" +
                " where t4.username = ?  and t3.flag = ? order by t3.id desc limit ?";
        //实例化一个RowMapper接口对象，需要实现他未实现的方法
        RowMapper<Map<String, Object>> rowMapper = new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> map = new TreeMap<>();
                map.put("picture", resultSet.getString("picture"));
                map.put("gid", resultSet.getString("gid"));
                map.put("name", resultSet.getString("name"));
                map.put("star", resultSet.getInt("star"));
                map.put("pubdate", resultSet.getString("pubdate"));
                map.put("price", resultSet.getString("price"));
                map.put("num", resultSet.getInt("num"));
                map.put("money", resultSet.getDouble("money"));
                return map;
            }
        };
        try {
            return jdbcTemplate.query(sql, rowMapper, username, 2, limit);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
