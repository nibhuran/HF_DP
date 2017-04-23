package com.Design.Bangalore.src.Flipkart;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public class Printer {
    enum State {PRINTING, IDLE, BROKEN};
    private State state;
    private Queue<PrinterContent> printerContents = new LinkedList<PrinterContent>();

    public Printer(String iD) {
        this.iD = iD;
        this.state = State.IDLE;
    }

    public String getiD() {
        return iD;

    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    private String iD;

    private void print(){
        while(printerContents.size() != 0){
            PrinterContent printerContent = printerContents.remove();
            System.out.println("Printing from "+this.iD);
            System.out.println(printerContent.toString());
        }
    }

    public void print(PrinterContent printerContent){
        if(printerContent != null){
            printerContents.add(printerContent);
            print();
        }
    }


 /*   public void print(PrinterContent printerContent){
        if(printerContent != null){

            System.out.println("Printing from "+this.iD);
            System.out.printf(printerContent.toString());
        }
    }
    */

    public void setIdleState(){
        this.setState(State.IDLE);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
