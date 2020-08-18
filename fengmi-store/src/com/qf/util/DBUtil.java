package com.qf.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static ComboPooledDataSource ds = new ComboPooledDataSource("mysql-config");
	
	/**
	 * 建立连接对象
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 执行更新单条sql操作
	 * @return
	 */
	public static int executeUpdate(String sql , Object... params){
		Connection conn = getConnection();
		int i = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < params.length; j++) {
				pstmt.setObject(j+1,params[j]);
			}
			i = pstmt.executeUpdate();
			close(conn,pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 执行单条sql语句的查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public static ResultSet executeQuery(String sql , Object... params){
		Connection conn = getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < params.length; j++) {
				pstmt.setObject(j+1,params[j]);
			}
			rs = pstmt.executeQuery();
			//close(conn,pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 查询多条数据
	 * @param <T>
	 * @param sql
	 * @param params
	 * @return
	 */
	public static <T> List<T> executeQueryList(String sql ,Class<T> clazz, Object... params){
		Connection conn = getConnection();
		List<T> list = new ArrayList<T>();
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < params.length; j++) {
				pstmt.setObject(j+1,params[j]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				T obj = clazz.newInstance();
				Field[] fs = clazz.getDeclaredFields();
				for(Field f:fs){
					f.setAccessible(true);
					f.set(obj, rs.getObject(f.getName()));
				}
				list.add(obj);
			}
			closeResultSet(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询单条数据
	 * @param <T>
	 * @param sql
	 * @param params
	 * @return
	 */
	public static <T> T executeQuerySingle(String sql ,Class<T> clazz, Object... params){
		Connection conn = getConnection();
		T obj = null;
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < params.length; j++) {
				pstmt.setObject(j+1,params[j]);
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				obj = clazz.newInstance();
				Field[] fs = clazz.getDeclaredFields();
				for(Field f:fs){
					f.setAccessible(true);
					f.set(obj, rs.getObject(f.getName()));
				}
			}
			closeResultSet(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	/**
	 * 更新操作关闭资源
	 * @param conn
	 * @param pstmt
	 */
	public static void close(Connection conn,PreparedStatement pstmt){
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 查询操作关闭资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeResultSet(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		close(conn,pstmt);
	}
}
