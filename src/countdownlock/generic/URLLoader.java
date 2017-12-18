package countdownlock.generic;

import countdownlock.Main;

import java.net.URL;

public class URLLoader {

    public static URL getURL(String location) {
        return Main.class.getResource(location);
    }
}
