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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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


    /**
     * 使用RowMapper获取临时对象，将数据存储在Map中并返回一个List
     *
     * @param uid
     * @param num
     * @return List<Map < String, Object>>
     */
    /*public List<Map<String, Object>> getOrderListDetail(long uid, int num) {
        DataSource ds = dbUtils.getDS();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        String sql = "select" +
                " t2.name as gooodsName," +
                " t2.price," +
                " ( @i :=" + num + ")num," +
                " ( " + num + " * t2.price ) as goodsPrice," +
                " t3.address_detail as addressDetail " +
                " from" +
                " t_order t1" +
                " inner join t_goods t2 on t1.gid = t2.id" +
                " inner join t_useraddress t3 on t1.uid = t3.uid where t1.uid = ?";
        //实例化一个RowMapper接口对象，需要实现他未实现的方法
        RowMapper<Map<String, Object>> rowMapper = new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> map = new TreeMap<>();
                map.put("goodsName", resultSet.getString("gooodsName"));
                map.put("price", resultSet.getDouble("price"));
                map.put("num", resultSet.getInt("num"));
                map.put("goodsPrice", resultSet.getDouble("goodsPrice"));
                map.put("addressDetail", resultSet.getString("addressDetail"));
                return map;
            }
        };
        try {
            return jdbcTemplate.query(sql, rowMapper, uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
