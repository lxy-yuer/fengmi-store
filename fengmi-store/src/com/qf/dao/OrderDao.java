package com.qf.dao;

import java.util.List;

import com.qf.entity.Order;

public interface OrderDao {
	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public int addOrder(Order order);

	/**
	 * 更新订单
	 * 
	 * @param order
	 * @return
	 */
	public int updateOrder(Order order);

	/**
	 * 删除订单
	 * 
	 * @param id
	 * @return
	 */
	public int deleteOrder(int id);

	/**
	 * 返回uid用户的订单列表
	 * 
	 * @param uid
	 * @return
	 */
	public List<Order> getOrderListByUid(int uid);

	/**
	 * 通过id查询订单
	 * 
	 * @param id
	 * @return
	 */
	public Order getOrderById(int id);

}
