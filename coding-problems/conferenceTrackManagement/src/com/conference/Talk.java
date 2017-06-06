//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.conference;

public class Talk implements Comparable {
    private String title;
    private int length;
    private Time startTime;

    public int length() {
        return this.length;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public Talk(String title, int length) {
        if(title.matches(".*\\d+.*")) {
            throw new IllegalArgumentException(title + " - Title is Invalid because it contains number");
        } else {
            this.title = title;
            this.length = length;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setStartTime(Time nextAvailableTime) {
        this.startTime = new Time(nextAvailableTime);
    }

    public String toString() {
        return "\n" + this.startTime + " " + this.getTitle() + " " + (this.length() == 5?"lightening":this.length() + "min");
    }

    public int compareTo(Object talk) {
        return this.length > ((Talk)talk).length()?-1:0;
    }
}
