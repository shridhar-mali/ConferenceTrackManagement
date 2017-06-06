package com.conference;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InstantiationException {
        InputParser input = new InputParser("/resources/input.txt");
        ConferenceManager conferenceManager = new ConferenceManager();
        Conference conference = conferenceManager.scheduleTalks(input.talks());
        System.out.println(conference);
    }
}
