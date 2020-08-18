package com.qf.dao;

import java.util.List;

import com.qf.dao.GoodsDao;
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
		String sql = "update t_goods set flag=1 where id=?";
		int i = dbUtil.updateData(sql, id);
		return i;
	}

	@Override
	public int updateGoods(Goods good) {
		String sql = "update t_goods set name=?,price=?,pubdate=?,tid=?,intro=?,picture=?,star=? where id=?";
		int i = dbUtil.updateData(sql, good.getName(),good.getPrice(),good.getPubdate(),good.getTid(),good.getIntro(),good.getPicture(),good.getStar(),good.getId());
		return i;
	}

	@Override
	public Goods getGoodsById(int id) {
		String sql = "select * from t_goods where id=?";
		Goods good = dbUtil.querySingle(sql, Goods.class, id);
		return good;
	}

	@Override
	public Goods getGoodsByName(String name) {
		String sql = "select * from t_goods where name=?";
		Goods good = dbUtil.querySingle(sql, Goods.class, name);
		return good;
	}

	@Override
	public List<Goods> getGoodsList() {
		String sql = "select * from t_goods where flag=2";
		List<Goods> goods = dbUtil.queryList(sql, Goods.class);
		return goods;
	}
}
