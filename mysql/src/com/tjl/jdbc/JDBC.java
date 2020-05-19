package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
//		加载MySQL驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
//		连接数据库,获得连接对象
			Connection connection=DriverManager.getConnection("jdbc:mysql://121.199.78.141:3306/system", "root", "123456");
			System.out.println("数据库连接成功");
//		创建执行环境
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("select * from user");
			while(result.next()) {
				System.out.println(result.getInt("id"));
				System.out.println(result.getString("age"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			e.printStackTrace();
		}
}
}

