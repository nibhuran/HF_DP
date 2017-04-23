package com.java.Phase2.trial;

import java.util.Comparator;
import java.util.List;

public class GenericClass<E> {
    private E element;

    public GenericClass(E element) {
        this.element = element;
    }

    public void printElement(){
        System.out.println(element.toString());
    }

    public <e> void sort(List<e> list, Comparator<? super e> c){
        list.sort(c);
    }
}
