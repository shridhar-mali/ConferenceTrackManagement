package com.conference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConferenceManager {
    public ConferenceManager() {
    }

    Conference scheduleTalks(List<Talk> talksList) throws InstantiationException {
        Collections.sort(talksList);
        int trackIndex = 1;
        ArrayList tracks = new ArrayList();

        while(talksList.size() > 0) {
            Track track = new Track("Track " + trackIndex++);
            track.addTalks(talksList);
            tracks.add(track);
        }

        return new Conference(tracks);
    }
}
