package com.qf.dao;

import com.qf.entity.Goods;
import com.qf.util.DBUtils;

/** 
 * 
 * @author _4444x_
 *
 */

public class GoodsDaoImpl implements GoodsDao{
	DBUtils<Goods> dbUtil = new DBUtils<>();
	
	@Override
	public int addGoods(Goods good) {
		String sql = "insert into t_goods(username,password,img) values(?,?,?)";
		int i = dbUtil.updateData(sql, user.getUsername(),user.getPassword(),user.getImg());
		return i;
	}
}
