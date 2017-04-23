package com.Design.snakesandladder;

/**
 * Created by BHUVKUMA on 15-Apr-15.
 */
public class FixedOutcome implements Outcome {
    @Override
    public int returnOutcome(int endpoint) {
        return endpoint;
    }

}
