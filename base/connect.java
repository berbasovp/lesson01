package base;

import java.sql.*;

public class connect {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src//base.db");
        stmt = connection.createStatement();
            if (connection != null) System.out.println("Соединение установлено");

    }
    private static void disconnect() throws ClassNotFoundException, SQLException {
        connection.close();
    }
    public static void addbase() throws SQLException, ClassNotFoundException{
        connect();
        String sql = String.format("CREATE TABLE Unit (\n" +
                "    id     INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    prodid INTEGER UNIQUE,\n" +
                "    title  TEXT,\n" +
                "    cost   DOUBLE\n" +
                ");");
        try {
            stmt.addBatch("DROP TABLE IF EXISTS Unit");
            stmt.addBatch(sql);
            stmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addUnion();
        disconnect();
    }
    private static void addUnion() throws SQLException, ClassNotFoundException  {
        try {
            connect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection.setAutoCommit(false);
        pstmt = connection.prepareStatement("INSERT INTO Unit (prodid, title, cost) VALUES (?, ?, ?)");
       for (int i=1; i<10001; i++) {
           pstmt.setInt(1, i);
           pstmt.setString(2,"товар"+i);
           pstmt.setInt(3, i*10);
           pstmt.addBatch();
       }
        pstmt.executeBatch();
        connection.setAutoCommit(true);
    }
}
