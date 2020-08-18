package com.qf.service;

import java.util.List;

import com.qf.dao.GoodsDao;
import com.qf.dao.GoodsDaoImpl;
import com.qf.entity.Goods;

/** 
 * 
 * @author _4444x_
 *
 */

public class GoodsServiceImpl implements GoodsService{
	GoodsDao dao = new GoodsDaoImpl();
	
	@Override
	public int addGoods(Goods good) {
		Goods good1 = dao.getGoodsByName(good.getName());
		if(good1 == null) {
			return dao.addGoods(good);
		}
		return -1;
	}

	@Override
	public int deleteGoods(int id) {
		Goods good = dao.getGoodsById(id);
		if(good.getFlag() == 2) {
			return dao.deleteGoods(id);
		}
		return -1;
	}

	@Override
	public int updateGoods(Goods good) {
		return dao.updateGoods(good);
	}

	@Override
	public Goods getGoodsById(int id) {
		return dao.getGoodsById(id);
	}

	@Override
	public Goods getGoodsByName(String name) {
		return dao.getGoodsByName(name);
	}

	@Override
	public List<Goods> getGoodsList() {
		return dao.getGoodsList();
	}

}
