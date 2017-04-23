package com.Design.snakesandladder;

/**
 * Created by BHUVKUMA on 15-Apr-15.
 */
public abstract class Entity {
    int end;
    Outcome outcome;

    public int getEndpoint(){
        return outcome.returnOutcome(end);
    }
}
