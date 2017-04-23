package com.Design.Bangalore.src.Flipkart;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public class PrinterManager implements NormalUserPermission, AdminUserPermission{
    private Set<Printer> printerSet = new HashSet<>();
    private Queue<PrinterContent> printingQueue = new LinkedList<PrinterContent>();


    public void print(Printer printer, PrinterContent printerContent){
        printer.print(printerContent);
    }

    @Override
    public void addPrinter(Printer printer) {
        if(printer != null){
            printer.setIdleState();
            System.out.println("Adding Printer " + printer.getiD());
            printerSet.add(printer);
        }
    }

    @Override
    public void removePrinter(Printer printer) {
        if(printer != null){
            System.out.println("Removing Printer " + printer.getiD());
            printerSet.remove(printer);
        }
    }

    @Override
    public void fixPrinter(Printer printer) {
        if(printer != null){
            if(printer.getState() == Printer.State.BROKEN){
                System.out.println("Fixing Printer");
                printer.setState(Printer.State.IDLE);
                System.out.println("Printer Fixed");
            }
        }
    }
    private Printer getNextIdlePrinter(){
        while(true) {
            for (Printer printer : printerSet) {
                if (printer.getState() == Printer.State.IDLE) {
                    return printer;
                }
            }
            try {
                System.out.printf("Slleping");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void print(){
        if(printingQueue.isEmpty()){
            System.out.println("All Printed, Waiting");
        }
        else{
            for(PrinterContent printerContent: printingQueue){
                Printer printer = getNextIdlePrinter();
                printer.print(printerContent);
            }
        }
    }

    @Override
    public void print(PrinterContent printerContent) {
        if(printerContent != null){
            printingQueue.add(printerContent);
            print();
        }
    }
}
