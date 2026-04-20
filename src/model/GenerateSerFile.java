package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GenerateSerFile {

    public static void main(String[] args) {
        try {
            String username = "root";
            String password = "Amiru20040131$";
            String dbName = "ceylon_mart";
            String dumpPath = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe";
            String ip = "localhost";
            String port = "3306";

            MySQL2 dbInfo = new MySQL2(username, password, dbName, dumpPath, ip, port);

            try ( FileOutputStream fileOut = new FileOutputStream("dbinfor.ser");  ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(dbInfo);
                System.out.println("Serialized data is saved in dbinfor.ser");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
