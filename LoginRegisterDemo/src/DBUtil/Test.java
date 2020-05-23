package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import Model.User;

public class Test {
	public static String URL;
    // 用户名
    public static String USERNAME;
    // 密码
    public static String PASSWORD;
    // mysql的驱动类
    public static String DRIVER;
    private static ResourceBundle rb = ResourceBundle.getBundle("DBUtil.db-config");
    static {
        URL = rb.getString("jdbc.url");
        USERNAME = rb.getString("jdbc.username");
        PASSWORD = rb.getString("jdbc.password");
        DRIVER = rb.getString("jdbc.driver");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("链接成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        User user = null;
		try {
			user = DBOperation.getUser("管理员", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String jsonStr = gson.toJson(user);
		System.out.println(jsonStr);
	}
}
