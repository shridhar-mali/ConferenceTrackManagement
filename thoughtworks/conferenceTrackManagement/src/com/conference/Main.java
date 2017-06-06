package com.conference;

import java.io.IOException;
import java.text.ParseException;
import java.net.URISyntaxException;

/**
 * Created by Shridhar on 5/27/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InstantiationException {
        InputParser input = new InputParser("/resources/input.txt");
        ConferenceManager conferenceManager = new ConferenceManager();
        Conference conference = conferenceManager.scheduleTalks(input.talks());
        System.out.println(conference);
    }
}
