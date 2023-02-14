package app.raidhub.JBA.user;

import app.raidhub.JBA.JBA;
import app.raidhub.JBA.user.enums.BungieMembershipType;
import app.raidhub.JBA.user.objects.BungieMembership;
import app.raidhub.JBA.user.objects.BungieNetUser;
import app.raidhub.JBA.utils.HttpGetRequest;
import com.google.gson.Gson;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    // GET Requests
    public BungieNetUser GetBungieNetUserById(String id) {
        return new Gson().fromJson(HttpGetRequest.GET(JBA.getAPI_ROOT_PATH() + "/User/GetBungieNetUserById/" + id), BungieNetUser.class);
    }

    public BungieMembership[] getMembershipsById(String id, BungieMembershipType type) {
        List<BungieMembership> bungieMemberships = new ArrayList<BungieMembership>();
        var membershipArray = HttpGetRequest.GET(JBA.getAPI_ROOT_PATH() + "/User/GetMembershipsById/" + id + "/" + type.getType()).getAsJsonArray("destinyMemberships");
        membershipArray.forEach(membership -> bungieMemberships.add(new Gson().fromJson(membership, BungieMembership.class)));
        return bungieMemberships.toArray(new BungieMembership[0]);
    }
}
