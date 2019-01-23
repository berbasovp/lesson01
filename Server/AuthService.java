package Server;

import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;
    public static String nicName;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavel\\Downloads\\chat.db");
            stmt = connection.createStatement();
            if (connection != null) System.out.println("Соединение установлено");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNickLoginAndPass(String login, String pass) {
        String sql = String.format("SELECT nickname FROM chat\n" +
                "WHERE login = '%s'\n" +
                "AND password = '%s'", login, pass);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
