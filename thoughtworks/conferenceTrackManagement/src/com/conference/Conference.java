package com.conference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shridhar on 5/27/2017.
 */
public class Conference {

    private final List<Track> tracks = new ArrayList<>();
    private NetworkingEvent networkingEvent;

    public Conference(List<Track> tracks) throws InstantiationException {
        this.tracks.addAll(tracks);
        this.networkingEvent = new NetworkingEvent(calculateNetworkingStartTime());
    }

    private Time calculateNetworkingStartTime() {
        Time networkingEventStartTime = null;
        for(Track track : tracks) {
            if (networkingEventStartTime == null || networkingEventStartTime.before(track.finishTime())) {
                networkingEventStartTime = track.finishTime();
            }
        }
        return networkingEventStartTime;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    @Override
    public String toString() {
        StringBuilder confDetails = new StringBuilder();
        for (Track track : tracks) {
            confDetails.append(System.lineSeparator());
            confDetails.append(track);
            confDetails.append(networkingEvent);
            confDetails.append(System.lineSeparator());
        }
        return confDetails.toString();
    }
}
