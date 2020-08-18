package com.qf.dao;

import java.util.List;

import com.qf.entity.Order;
import com.qf.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

	DBUtil<Order> dbutil = new DBUtil<Order>();

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		dbutil.updateData("insert into order(id,uid,uaid,createtime,money,flag)", order.getId(), order.getUid(),
				order.getUaid(), order.getCreateTime(), order.getManey(), order.getFlag());
		return 0;
	}

	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> getOrderListByUid(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
