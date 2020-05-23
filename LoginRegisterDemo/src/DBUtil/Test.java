package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import Model.User;

public class Test {
	public static String URL;
    // �û���
    public static String USERNAME;
    // ����
    public static String PASSWORD;
    // mysql��������
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
            System.out.println("���ӳɹ���");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("��ȡ����ʧ��");
        }
        User user = null;
		try {
			user = DBOperation.getUser("����Ա", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String jsonStr = gson.toJson(user);
		System.out.println(jsonStr);
	}
}
