package com.thomas15v.NoAdver.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas15v on 9/03/15.
 */
public class IgnoreAbleListener<I> {

    private List<I> ignored = new ArrayList<>();

    public void addIgnored(I ignored){
        this.ignored.add(ignored);
    }

    public void removeIgnored(I ignored){
        this.ignored.remove(ignored);
    }

    public boolean isIgnore(I ignored){
        return this.ignored.contains(ignored);
    }
}
