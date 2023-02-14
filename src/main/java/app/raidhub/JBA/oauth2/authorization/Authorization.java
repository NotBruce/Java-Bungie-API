package app.raidhub.JBA.oauth2.authorization;

import app.raidhub.JBA.oauth2.exceptions.CodeNotReceived;
import app.raidhub.JBA.oauth2.exceptions.IncorrectStateReceived;
import app.raidhub.JBA.oauth2.objects.AuthToken;
import app.raidhub.JBA.utils.HttpRequest;
import com.google.gson.Gson;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Objects;

@Data
public class Authorization {

    public String url;
    public String state;
    public String code;
    public boolean receivedCallback = false;

    @SneakyThrows
    public void receiveCode(String code, String state) {
        if (!Objects.equals(this.state, state)) {
            throw new IncorrectStateReceived("Incorrect State Received.");
        }

        this.code = code;
        this.receivedCallback = true;
    }

    @SneakyThrows
    public AuthToken getAuthToken() {
        if (!this.receivedCallback) {
            throw new CodeNotReceived("Code has never been received.");
        }
        return new Gson().fromJson(HttpRequest.POST("https://www.bungie.net/platform/app/oauth/token/", this.code), AuthToken.class);
    }
}
