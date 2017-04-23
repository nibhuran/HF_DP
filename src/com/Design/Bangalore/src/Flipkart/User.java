package com.Design.Bangalore.src.Flipkart;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public abstract class User {
    private String userId;
    private String location;
    protected Permission permission;
   // protected AdminUserPermission adminUserPermission;

    public abstract void print(PrinterContent printerContent);
    public abstract void print(PrinterContent printerContent, Printer printer);

    public String getUserId() {
        return userId;
    }

    public User(String userId, String location) {
        this.userId = userId;
        this.location = location;

    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
