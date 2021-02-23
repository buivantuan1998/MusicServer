package com.xtel.core.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER ="oracle.jdbc.OracleDriver";
    private static final String USER = "MUSIC_APPLICATION_SERVER";
    private static final String PASS = "123";

    //tao doi tuong ket noi
    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }

    //tao doi tuong dong ket noi
    public static void closeConnection(Connection conn, CallableStatement callst) {
        if(callst != null) {
            try {
                callst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
