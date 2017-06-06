package com.conference;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


/**
 * Created by Shridhar on 5/27/2017.
 */
public class InputParser {

    private final List<Talk> talks = new ArrayList<>();

    public InputParser(String filePath) throws URISyntaxException, IOException {
        extractTalks(Files.lines(Paths.get(InputParser.class.getResource(filePath).toURI())));
    }

    private void extractTalks(Stream<String> lines) {
        Pattern pattern = Pattern.compile("(.+?)([0-9]?[0-9]{1}min|lightning)");
        lines.forEach((String line) -> {
            Matcher m = pattern.matcher(line);
            if(m.matches()) {
                    Talk talk = new Talk(m.group(1).trim(), m.group(2).contains("min")? Integer.parseInt(m.group(2).replaceFirst("min", "")):5);
                    talks.add(talk);
            }
        });
    }

    public  List<Talk> talks() {
        return new ArrayList<>(talks);
    }
}
