package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySQL2 implements Serializable {

    private static Connection connection;

    private static void createConnection() throws Exception {
        if (connection == null) {
            FileInputStream inputStream = new FileInputStream("dbinfor.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            MySQL2 db = (MySQL2) objectInputStream.readObject();

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + db.ip + ":" + db.port + "/" + db.dbName, db.username, db.password);
        }
    }

    public static ResultSet executeSearch(String query) throws Exception {
        createConnection();
        return connection.createStatement().executeQuery(query);
    }

    public static Integer executeIUD(String query) throws Exception {
        createConnection();
        return connection.createStatement().executeUpdate(query);
    }

    private final String username;
    private final String password;
    private final String dbName;
    private final String dump;
    private final String ip;
    private final String port;

    public MySQL2(String username, String password, String dbName, String dump, String ip, String port) {
        this.username = username;
        this.password = password;
        this.dbName = dbName;
        this.dump = dump;
        this.ip = ip;
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDump() {
        return dump;
    }
}
