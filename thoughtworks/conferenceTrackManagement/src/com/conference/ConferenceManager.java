package com.conference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shridhar on 5/28/2017.
 */
public class ConferenceManager {

    Conference scheduleTalks(List<Talk> talksList) throws InstantiationException {
        Collections.sort(talksList);
        int trackIndex =1;
        final List<Track> tracks = new ArrayList<>();
        while (talksList.size() > 0) {
            Track track = new Track("Track " + trackIndex++);
            track.addTalks(talksList);
            tracks.add(track);
        }
        return new Conference(tracks);
    }
}
