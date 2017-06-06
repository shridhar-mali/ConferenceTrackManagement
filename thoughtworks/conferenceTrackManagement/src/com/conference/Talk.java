package com.conference;

/**
 * Created by Shridhar on 5/27/2017.
 */
public class Talk implements Comparable {
    private String title;
    private int length;
    private Time startTime;

    public int length() {
        return length;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Talk(final String title, final int length) {
        if(title.matches(".*\\d+.*")) {
            throw new IllegalArgumentException(title + " - Title is Invalid because it contains number");
        }
        this.title = title;
        this.length = length;

    }

    public String getTitle() {
        return title;
    }

    public void setStartTime(Time nextAvailableTime) {
        this.startTime = new Time(nextAvailableTime);
    }

    @Override
    public String toString() {
        return "\n" + startTime + " " + getTitle() + " " + (length() == 5 ? "lightening" : length() + "min");
    }

    @Override
    public int compareTo(Object talk) {
        talk = (Talk) talk;
        return length > ((Talk) talk).length() ? -1 : 0;
    }
}
