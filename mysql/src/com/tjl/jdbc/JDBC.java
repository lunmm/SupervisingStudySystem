package com.tjl.jdbc;

public class JDBC {

	public static void main(String[] args) {
		//¼ÓÔØMySQLÇý¶¯
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			e.printStackTrace();
		}
	}

}
