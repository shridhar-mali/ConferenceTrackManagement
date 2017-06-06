//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.conference;

import java.util.Iterator;
import java.util.List;

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
        Iterator itr = talks.iterator();

        while(itr.hasNext()) {
            Talk talk = (Talk)itr.next();
            if(this.canAccomodate(talk)) {
                this.addTalk(talk);
                itr.remove();
            }
        }

    }

    private void addTalk(Talk talk) {
        if(this.morningSession.canAccomodate(talk)) {
            this.morningSession.addTalk(talk);
        } else if(this.eveningSession.canAccomodate(talk)) {
            this.eveningSession.addTalk(talk);
        }

    }

    public Time finishTime() {
        return this.eveningSession.getNextAvailableTime();
    }

    public String toString() {
        return this.name + ":" + System.lineSeparator() + this.morningSession + this.lunch + this.eveningSession;
    }
}
