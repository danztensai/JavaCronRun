package com.bmt.cron.util;

import java.util.*;
import java.io.*;

public class GetProperties
{
    String uid;
    String pass;
    String url;
    String db;
    String usernameDB;
    String passDB;
    String urlSend;
    String port;
    String keyword;
    String maxDataPerM;
    String tinyUrl;
    String tinyUrlM1m;
    String crontabSchedue;
    String sidWapPush;
    String logSchStoryPlace;
    String checkLogStory;
    
    public String getLogSchStoryPlace() {
        return this.logSchStoryPlace;
    }
    
    public void setLogSchStoryPlace( String logSchStoryPlace) {
        this.logSchStoryPlace = logSchStoryPlace;
    }
    
    public String getSidWapPush() {
        return this.sidWapPush;
    }
    
    public void setSidWapPush( String sidWapPush) {
        this.sidWapPush = sidWapPush;
    }
    
    public String getCrontabSchedue() {
        return this.crontabSchedue;
    }
    
    public void setCrontabSchedue( String crontabSchedue) {
        this.crontabSchedue = crontabSchedue;
    }
    
    public String getKeyword() {
        return this.keyword;
    }
    
    public void setKeyword( String keyword) {
        this.keyword = keyword;
    }
    
    public String getPort() {
        return this.port;
    }
    
    public void setPort( String port) {
        this.port = port;
    }
    
    public String getUrlSend() {
        return this.urlSend;
    }
    
    public void setUrlSend( String urlSend) {
        this.urlSend = urlSend;
    }
    
    public GetProperties( String uid,  String pass,  String url,  String db,  String usernameDB,  String passDB) {
        this.uid = uid;
        this.pass = pass;
        this.url = url;
        this.db = db;
        this.usernameDB = usernameDB;
        this.passDB = passDB;
    }
    
    public String getTinyUrl() {
        return this.tinyUrl;
    }
    
    public void setTinyUrl( String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }
    
    @Override
    public String toString() {
        return "GetProperties [uid=" + this.uid + ", pass=" + this.pass + ", url=" + this.url + ", db=" + this.db + ", usernameDB=" + this.usernameDB + ", passDB=" + this.passDB + ", urlSend=" + this.urlSend + ", port=" + this.port + ", keyword=" + this.keyword + ", maxDataPerM=" + this.maxDataPerM + ", tinyUrl=" + this.tinyUrl + ", tinyUrlM1m=" + this.tinyUrlM1m + ", crontabSchedue=" + this.crontabSchedue + ", sidWapPush=" + this.sidWapPush + "]";
    }
    
    public String getTinyUrlM1m() {
        return this.tinyUrlM1m;
    }
    
    public void setTinyUrlM1m( String tinyUrlM1m) {
        this.tinyUrlM1m = tinyUrlM1m;
    }
    
    public GetProperties() {
         Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("conf/config.properties"));
            this.setUrl(prop.getProperty("urlDB"));
            this.setUsernameDB(prop.getProperty("dbuser"));
            this.setPassDB(prop.getProperty("dbpassword"));
            this.setMaxDataPerM(prop.getProperty("MaxDataPerM"));
            this.setTinyUrl(prop.getProperty("tinyUrl"));
            this.setTinyUrlM1m(prop.getProperty("tinyUrlM1m"));
            this.setCrontabSchedue(prop.getProperty("crontabSchedue"));
            this.setSidWapPush(prop.getProperty("sidWapPush"));
            this.setPort(prop.getProperty("port"));
            this.setLogSchStoryPlace(prop.getProperty("logSchStry"));
            this.setCheckLogStory(prop.getProperty("stringCheckPushedMT"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    
    public String getCheckLogStory() {
        return this.checkLogStory;
    }
    
    public void setCheckLogStory( String checkLogStory) {
        this.checkLogStory = checkLogStory;
    }
    
    public String getMaxDataPerM() {
        return this.maxDataPerM;
    }
    
    public void setMaxDataPerM( String maxDataPerM) {
        this.maxDataPerM = maxDataPerM;
    }
    
    public String getUid() {
        return this.uid;
    }
    
    public void setUid( String uid) {
        this.uid = uid;
    }
    
    public String getPass() {
        return this.pass;
    }
    
    public void setPass( String pass) {
        this.pass = pass;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl( String url) {
        this.url = url;
    }
    
    public String getDb() {
        return this.db;
    }
    
    public void setDb( String db) {
        this.db = db;
    }
    
    public String getUsernameDB() {
        return this.usernameDB;
    }
    
    public void setUsernameDB( String usernameDB) {
        this.usernameDB = usernameDB;
    }
    
    public String getPassDB() {
        return this.passDB;
    }
    
    public void setPassDB( String passDB) {
        this.passDB = passDB;
    }
}
