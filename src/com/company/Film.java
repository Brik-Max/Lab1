package com.company;

import java.time.Year;

public class Film{
    String name;
    Year released;
    float rating;
    int views;

    Film(String name,Year released, float rating,int views){
        this.name = name;
        this.released = released;
        this.rating = rating;
        this.views = views;
    }

    void Print(){
        System.out.println(this.name + "| " + this.released + " ã.| " + this.rating + "| " + this.views + "\n");
    }

}
