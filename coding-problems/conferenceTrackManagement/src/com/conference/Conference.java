package com.conference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conference {
    private final List<Track> tracks = new ArrayList();
    private NetworkingEvent networkingEvent;

    public Conference(List<Track> tracks) throws InstantiationException {
        this.tracks.addAll(tracks);
        this.networkingEvent = new NetworkingEvent(calculateNetworkingStartTime());
    }

    private Time calculateNetworkingStartTime() {
        Time networkingEventStartTime = null;
        for(Track track : tracks) {
            if(networkingEventStartTime == null || networkingEventStartTime.before(track.finishTime())) {
                networkingEventStartTime = track.finishTime();
            }
        }
        return networkingEventStartTime;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public String toString() {
        StringBuilder confDetails = new StringBuilder();
        Iterator var2 = this.tracks.iterator();

        while(var2.hasNext()) {
            Track track = (Track)var2.next();
            confDetails.append(System.lineSeparator());
            confDetails.append(track);
            confDetails.append(this.networkingEvent);
            confDetails.append(System.lineSeparator());
        }

        return confDetails.toString();
    }
}
