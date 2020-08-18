package com.qf.entity;

/**
 * 
 * @author _4444x_
 *
 */

public class Goods {
	private int id;
	private String name;
	private double price;
	private String pubdate;
	private int tid;
	private String intro;
	private String picture;
	private int star;
	private int flag;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goods(String name, double price, String pubdate, int tid, String intro, String picture, int star) {
		super();
		this.name = name;
		this.price = price;
		this.pubdate = pubdate;
		this.tid = tid;
		this.intro = intro;
		this.picture = picture;
		this.star = star;
	}

	public Goods(int id, String name, double price, String pubdate, int tid, String intro, String picture, int star,
			int flag) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pubdate = pubdate;
		this.tid = tid;
		this.intro = intro;
		this.picture = picture;
		this.star = star;
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", pubdate=" + pubdate + ", tid=" + tid
				+ ", intro=" + intro + ", picture=" + picture + ", star=" + star + ", flag=" + flag + "]";
	}
	
	
}
