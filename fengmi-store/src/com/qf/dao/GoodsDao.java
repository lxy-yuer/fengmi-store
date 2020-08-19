package com.qf.dao;

import java.util.List;
import com.qf.entity.Goods;

/**
 * 
 * @author _4444x_
 *
 */

public interface GoodsDao {

	public int addGoods(Goods good);

	public int deleteGoods(int id);

	public int updateGoods(Goods good);

	public Goods getGoodsById(int id);

	public Goods getGoodsByName(String name);

	public List<Goods> getGoodsList();

}
