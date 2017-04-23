package com.Design.Bangalore.src.Flipkart;

/**
 * Created by BHUVKUMA on 26-Jun-15.
 */
public class NormalPriterContent extends PrinterContent {
    private String file;

    public NormalPriterContent(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;

    }

    public void setFile(String file) {
        this.file = file;
    }

    public String toString(){
        return this.file;
    }
}
