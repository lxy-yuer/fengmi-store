package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
import com.qf.util.DBUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    DBUtils<Order> dbUtils = new DBUtils<>();

    @Override
    public int addOrder(Order order) {
        return dbUtils.updateData("insert into t_order(id, uid, uaid, createtime, money, flag) values(?, ?, ?, ?, ?, ?)",
                order.getId(), order.getUid(),
                order.getUaid(), order.getCreateTime(),
                order.getManey(), order.getFlag());
    }

    @Override
    public int updateOrder(Order order) {
        return dbUtils.updateData("update t_order set id=?, uid=?, uaid=?, createtime=?, money=?, flag=?",
                order.getId(), order.getUid(),
                order.getUaid(), order.getCreateTime(),
                order.getManey(), order.getFlag());
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


    public List<Map<String, Object>> selectCoursesBySno(long uid) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "select t2.name,t2.price, t1.num, t1.num*t1.money, t3.address_detail from t_order t1" +
                " inner join t_goods t2 on t1.gid=t2.id" + " inner join t_useraddress t3 on t1.uid = t3.uid" +
                " where t1.uid = ? ";
        //实例化一个RowMapper接口对象，需要实现他未实现的方法
        RowMapper<Map<String, Object>> rowMapper = new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> map = new HashMap<>();
                map.put("goodsName", resultSet.getLong("cno"));
                map.put("cname", resultSet.getString("cname"));
                map.put("credit", resultSet.getString("credit"));
                map.put("startDate", resultSet.getDate("startDate"));
                map.put("endDate", resultSet.getDate("endDate"));
                map.put("tname", resultSet.getString("tname"));
                map.put("phone", resultSet.getString("phone"));
                return map;
            }
        };
        return jdbcTemplate.query(sql, rowMapper, uid);
    }

}
