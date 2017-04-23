package com.Design.Bangalore.src.Flipkart;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public class NormalUser extends User {
    PrinterManager printerManager;

    public void print (Printer printer, PrinterContent printerContent){
        printerManager.print(printer, printerContent);
    }

    public NormalUser(String userId, String location) {
        super(userId, location);
        permission = new NormalUserPermission() {
            @Override
            public void print(PrinterContent printerContent) {

            }
        };

    }


    public NormalUser(String userId, NormalUserPermission normalUserPermission ) {
        super(userId);
        this.permission = normalUserPermission;
    }

    public void print(PrinterContent printerContent){
        //permission.print(printerContent);
    }

    @Override
    public void print(PrinterContent printerContent, Printer printer) {

    }
}
