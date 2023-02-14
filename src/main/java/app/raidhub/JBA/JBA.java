package app.raidhub.JBA;

import app.raidhub.JBA.user.User;
import app.raidhub.JBA.user.enums.BungieMembershipType;
import lombok.Data;
import lombok.Getter;

@Data
public class JBA {

    @Getter
    private static final String API_ROOT_PATH = "https://www.bungie.net/Platform";
    @Getter
    private static String apiKey;

    @Getter
    private static String clientId;
    private final User user = new User();

    public JBA(String apiKey, String clientId) {
        JBA.apiKey = apiKey;
        JBA.clientId = clientId;
    }
}
