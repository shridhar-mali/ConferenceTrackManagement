//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.conference;

public class NetworkingEvent {
    private Time startTime;
    private static final String TITLe = "Networking Event";
    private static final Time NOT_BEFORE_TIME = new Time("04:00PM");
    private static final Time NOT_AFTER_TIME = new Time("05:00PM");

    public NetworkingEvent(Time startTime) throws InstantiationException {
        if(this.isValidStartTime(startTime)) {
            this.startTime = startTime;
        } else {
            throw new InstantiationException("Invalid networking start time : " + startTime);
        }
    }

    private boolean isValidStartTime(Time startTime) {
        return NOT_BEFORE_TIME.before(startTime) && !NOT_AFTER_TIME.before(startTime);
    }

    public String toString() {
        return "\n" + this.startTime + " " + "Networking Event";
    }
}
