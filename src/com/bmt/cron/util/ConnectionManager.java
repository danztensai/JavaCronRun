package com.bmt.cron.util;

import org.apache.log4j.*;
import java.sql.*;

public class ConnectionManager
{
    private static Logger log;
    private Connection con;
    private String driver;
    private String url;
    private String db;
    private String username;
    private String password;
    
    static {
        ConnectionManager.log = Logger.getLogger((Class)ConnectionManager.class);
    }
    
    public ConnectionManager() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "";
        this.db = "";
        this.username = "";
        this.password = "";
    }
    
    public void loadConfig() {
        final GetProperties gp = new GetProperties();
        this.db = gp.getDb();
        this.url = gp.getUrl();
        this.username = gp.getUsernameDB();
        this.password = gp.getPassDB();
    }
    
    public Connection logOn() {
        try {
            this.loadConfig();
            Class.forName(this.driver).newInstance();
            this.con = DriverManager.getConnection(this.url, this.username, this.password);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ConnectionManager.log.info((Object)ex, (Throwable)ex);
        }
        return this.con;
    }
    
    public void logOff() {
        try {
            this.con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ConnectionManager.log.info((Object)ex, (Throwable)ex);
        }
    }
}
