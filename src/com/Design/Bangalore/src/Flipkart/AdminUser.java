package com.Design.Bangalore.src.Flipkart;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public class AdminUser extends User{
    AdminUserPermission printerManager;

    @Override
    public void print(PrinterContent printerContent) {
        //permission.print(printerContent);
    }

    @Override
    public void print(PrinterContent printerContent, Printer printer) {

    }

    public void addPrinter(Printer printer){
        if(printer != null)
        printerManager.addPrinter(printer);
    }

    public void removePrinter (Printer printer){
        if(printer != null)
        printerManager.removePrinter(printer);
    }

    public void fixPrinter (Printer printer){
        if(printer != null)
        printerManager.fixPrinter(printer);
    }

    public AdminUser(String userId, String location) {
        super(userId, location);


    }

    public AdminUser(String userId, AdminUserPermission adminUserPermission ) {
        super(userId);
        //this.adminUserPermission = adminUserPermission;
    }

}
