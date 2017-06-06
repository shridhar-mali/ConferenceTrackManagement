package com.conference;

import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Shridhar on 5/27/2017.
 */
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
        this.talks = new ArrayList<>();
    }

    public Time getNextAvailableTime() {
        return nextAvailableTime;
    }

    public int getDuration() {
        return duration;
    }
    public void addTalk(Talk talk) {
        talk.setStartTime(nextAvailableTime);
        talks.add(talk);
        nextAvailableTime.incrementMinutesBy(talk.length());
        minsLeft = minsLeft - talk.length();
    }

    public boolean canAccomodate(Talk talk) {
        return minsLeft >= talk.length();
    }

    @Override
    public String toString() {
        StringBuilder sessionDetails = new StringBuilder();
        for(Talk talk : talks) {
            sessionDetails.append(talk);
        }
        return sessionDetails.toString();
    }


}
