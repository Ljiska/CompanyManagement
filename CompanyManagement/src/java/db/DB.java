package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.*;

public class DB {

    private static DB instance;
    private static final int MAX_CON = 20;
    private static final Connection connections[] = new Connection[MAX_CON];
    private int free = MAX_CON, last = 0, first = 0;

    private DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            for (int i = 0; i < MAX_CON; i++) {
                connections[i] = DriverManager.getConnection("jdbc:mysql://localhost:3306/companymanagement?useUnicode=true&characterEncoding=utf8", "root", "");
            }
        } catch (Exception e) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (free == 0) {
            return null;
        }
        Connection temp = connections[first];
        first = (first + 1) % MAX_CON;
        free--;
        return temp;
    }

    public synchronized void putConnection(Connection c) {
        if (c == null || free == MAX_CON) {
            return;
        }
        connections[last] = c;
        last = (last + 1) % MAX_CON;
        free++;
    }
}
