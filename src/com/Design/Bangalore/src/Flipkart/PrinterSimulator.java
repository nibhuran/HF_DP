package com.Design.Bangalore.src.Flipkart;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public class PrinterSimulator {
    public static void main(String[] args){

        PrinterManager printerManager = new PrinterManager();

        Printer printer1 = new Printer("Printer1");
        Printer printer2 =  new Printer("Printer2");

        AdminUser admin = new AdminUser("Admin", printerManager);
        admin.addPrinter(printer1);
        admin.addPrinter(printer2);


        User ram = new NormalUser("Ram", printerManager);
        User shyam = new NormalUser("Shyam", printerManager);

        PrinterContent printerContent1 = new NormalPriterContent("hello");

        ram.print(printerContent1, printer1);
    }
}
