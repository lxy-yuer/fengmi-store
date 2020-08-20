package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
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

public class OrderDaoImpl implements OrderDao {

    DBUtils<Order> dbUtils = new DBUtils<>();

    @Override
    public int addOrder(Order order) {
        return dbUtils.updateData("insert into t_order(uid, gid, uaid, createtime, money, flag) values( ?, ?, ?, ?, ?, ?)",
                order.getUid(), order.getGid(),
                order.getUaid(), order.getCreateTime(),
                order.getMoney(), order.getFlag());
    }

    @Override
    public int updateOrder(Order order) {
        return dbUtils.updateData("update t_order set uid=?, uaid=?, createtime=?, money=?, flag=?",
                order.getUid(),
                order.getUaid(), order.getCreateTime(),
                order.getMoney(), order.getFlag());
    }

    @Override
    public int deleteOrder(int id) {
        return dbUtils.updateData("delete from t_order where id = ?", id);
    }

    @Override
    public List<Order> getOrderListByUid(int uid) {
        return dbUtils.queryList("select * from t_order where uid = ?", Order.class, uid);
    }

    @Override
    public Order getOrderById(int id) {
        return dbUtils.querySingle("select * from t_order where id = ?", Order.class, id);
    }


    /**
     * 使用RowMapper获取临时对象，将数据存储在Map中并返回一个List
     *
     * @param username
     * @return List<Map < String, Object>>
     */
    @Override
    public List<Map<String, Object>> getOrderList(String username) {
        DataSource ds = dbUtils.getDS();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        String sql = "select t3.name,t3.price,t2.num,t2.money,t1.uid,t2.gid from t_cart t1 inner join t_cartdetail t2 on t1.id=t2.cid inner join t_goods t3 on t2.gid=t3.id inner join t_user t4 on t1.uid=t4.id where t4.username=?;";
        //实例化一个RowMapper接口对象，需要实现他未实现的方法
        RowMapper<Map<String, Object>> rowMapper = new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> map = new TreeMap<>();
                map.put("name", resultSet.getString("name"));
                map.put("price", resultSet.getDouble("price"));
                map.put("num", resultSet.getInt("num"));
                map.put("money", resultSet.getDouble("money"));
                map.put("uid", resultSet.getInt("uid"));
                map.put("gid", resultSet.getInt("gid"));
                return map;
            }
        };
        try {
            return jdbcTemplate.query(sql, rowMapper, username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getOrderByUid(int uid) {
        return dbUtils.querySingle("select * from t_order where uid = ?",Order.class , uid);
    }
}
