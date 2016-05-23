package com.example.evgo.secretdiary.model;

import java.util.Set;

/**
 * Created by evgo on 6/11/2015.
 * model for setting
 */
public class Setting {

    private int title;
    private int description;
    private int action;

    public Setting(int title,int description,int action){
        this.title = title;
        this.description = description;
        this.action = action;
    }

    public int getDescription() {
        return description;
    }
    public int getTitle() {
        return title;
    }
    public int getAction(){
        return action;
    }
}
