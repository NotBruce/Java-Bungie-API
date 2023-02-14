package app.raidhub.JBA;

import lombok.Data;
import lombok.Getter;

@Data
public class JBA {

    @Getter
    private static final String API_ROOT_PATH = "https://www.bungie.net/Platform";
    @Getter
    private static String apiKey;
    public JBA(String apiKey) {
        JBA.apiKey = apiKey;
    }
}
