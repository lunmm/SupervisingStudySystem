package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
//		����MySQL����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�������سɹ�");
//		�������ݿ�,������Ӷ���
			Connection connection=DriverManager.getConnection("jdbc:mysql://121.199.78.141:3306/system", "root", "123456");
			System.out.println("���ݿ����ӳɹ�");
//		����ִ�л���
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

