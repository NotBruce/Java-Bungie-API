package app.raidhub.JBA.oauth2.objects;

import lombok.Data;

@Data
public class AuthToken {
    public String access_token;
    public String token_type;
    public short expires_in;
    public String refresh_token;
    public String membership_id;
    public long refresh_expires_in;
}
