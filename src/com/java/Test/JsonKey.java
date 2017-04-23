package com.java.Test;

import java.util.ArrayList;

/**
 * Created by BHUVKUMA on 21-May-15.
 */
public class JsonKey {
    String name;
    ArrayList<String> valueList = new ArrayList<String>(1);
    String position;
    ArrayList<JsonKey> jsonKeyArrayList = new ArrayList<JsonKey>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        valueList.add(value);
    }

    public JsonKey add(String name){
        JsonKey jsonKey = new JsonKey();
        jsonKey.setName(name);

        jsonKeyArrayList.add(jsonKey);

        return jsonKey;
    }

    public boolean has(String name){
        for (JsonKey current: jsonKeyArrayList){
            if(current.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public JsonKey get(String name){
        for (JsonKey current: jsonKeyArrayList){
            if(current.getName().equals(name)){
                return current;
            }
        }
        return null;
    }

    public void print(){

        //System.out.println("Name: "+name+" Value: "+value);
        System.out.printf(position);
        if(jsonKeyArrayList.isEmpty()) {
            System.out.println(name + " : " + (valueList.size()==0 ? null : valueList.size()==1 ? valueList.get(0) : valueList));
        } else {
            System.out.print(name + " : ");
        }
        if (!jsonKeyArrayList.isEmpty()) {
            System.out.printf("{\n");
        }
        for(JsonKey current: jsonKeyArrayList){
            current.print();
        }
        if (jsonKeyArrayList.isEmpty() == false)
            System.out.printf(position+"}\n");
    }
}
