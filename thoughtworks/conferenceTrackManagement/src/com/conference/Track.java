package com.conference;

import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Shridhar on 5/27/2017.
 */
public class Track {

    private Session morningSession;
    private Session lunch;
    private Session eveningSession;
    private String name;

    public Track(String name) {
        this.name = name;
        this.morningSession = new Session(180, "09:00AM");
        this.lunch = new Session(60, "12:00PM");
        this.lunch.addTalk(new Talk("Lunch", 60));
        this.eveningSession = new Session(240, "01:00PM");
    }

    public boolean canAccomodate(Talk talk) {
        return this.morningSession.canAccomodate(talk) || this.eveningSession.canAccomodate(talk);
    }

    public void addTalks(List<Talk> talks) {
        for (Iterator<Talk> itr =talks.iterator(); itr.hasNext();) {
            Talk talk = (Talk) itr.next();
            if (canAccomodate(talk)) {
                addTalk(talk);
                itr.remove();
            }
        }

    }
    private void addTalk(Talk talk) {
        if (this.morningSession.canAccomodate(talk)) {
            this.morningSession.addTalk(talk);
        } else if (this.eveningSession.canAccomodate(talk)) {
            this.eveningSession.addTalk(talk);
        }
    }

    public Time finishTime() {
        return eveningSession.getNextAvailableTime();
    }

    @Override
    public String toString() {
        return this.name + ":" + System.lineSeparator() + morningSession + lunch
                + eveningSession;
    }
}
