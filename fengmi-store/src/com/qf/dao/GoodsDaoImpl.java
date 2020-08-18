package com.qf.dao;

import java.util.List;

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
		String sql = "insert into t_goods(name,price,pubdate,tid,intro,pricture,star) values(?,?,?,?,?,?,?)";
		int i = dbUtil.updateData(sql, good.getName(),good.getPrice(),good.getPubdate(),good.getTid(),good.getIntro(),good.getPicture(),good.getStar());
		return i;
	}

	@Override
	public int deleteGoods(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGoods(Goods good) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goods getGoodsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods getGoodsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return null;
	}
}
