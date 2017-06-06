package com.conference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Session {
    private List<Talk> talks;
    private int duration;
    private Time nextAvailableTime;
    private Time beginAt;
    private int minsLeft;

    public Session(int duration, String beginAt) {
        this.duration = duration;
        this.beginAt = new Time(beginAt);
        this.nextAvailableTime = this.beginAt;
        this.minsLeft = duration;
        this.talks = new ArrayList();
    }

    public Time getNextAvailableTime() {
        return this.nextAvailableTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public void addTalk(Talk talk) {
        talk.setStartTime(this.nextAvailableTime);
        this.talks.add(talk);
        this.nextAvailableTime.incrementMinutesBy(talk.length());
        this.minsLeft -= talk.length();
    }

    public boolean canAccomodate(Talk talk) {
        return this.minsLeft >= talk.length();
    }

    public String toString() {
        StringBuilder sessionDetails = new StringBuilder();
        for(Talk talk : talks) {
            sessionDetails.append(talk);
        }
        return sessionDetails.toString();
    }
}
