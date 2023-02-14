package app.raidhub.JBA.oauth2;

import app.raidhub.JBA.JBA;
import app.raidhub.JBA.oauth2.authorization.Authorization;

import java.util.UUID;

public class OAuth2 {

    public Authorization createAuthorization() {
        var authorization = new Authorization();
        var state = usingRandomUUID();
        authorization.url = String.format("https://www.bungie.net/en/oauth/authorize?client_id={0}&response_type=code&state={1}", JBA.getClientId(), state);
        return authorization;
    }

    static String usingRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");

    }
}
