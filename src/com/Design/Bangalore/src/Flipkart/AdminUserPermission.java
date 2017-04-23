package com.Design.Bangalore.src.Flipkart;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public interface AdminUserPermission extends Permission {
    public void addPrinter(Printer printer);
    public void removePrinter(Printer printer);
    public void fixPrinter(Printer printer);
}
