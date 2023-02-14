package app.raidhub.JBA.user;

import app.raidhub.JBA.JBA;
import app.raidhub.JBA.user.enums.BungieMembershipType;
import app.raidhub.JBA.user.objects.BungieMembership;
import app.raidhub.JBA.user.objects.BungieNetUser;
import app.raidhub.JBA.user.objects.BungieTheme;
import app.raidhub.JBA.utils.HttpRequest;
import com.google.gson.Gson;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * User API Endpoint, simplified.
 * TODO: Finish all possible requests.
 */
@Data
public class User {

    /**
     * @param id Bungie Net API
     * @return Bungie Net User Class
     */
    public BungieNetUser GetBungieNetUserById(String id) {
        return new Gson().fromJson(HttpRequest.GET(JBA.getAPI_ROOT_PATH() + "/User/GetBungieNetUserById/" + id), BungieNetUser.class);
    }

    /**
     * @param id Destiny Membership Id
     * @param type Bungie Membership Type See BungieMembershipType.class
     * @return Membership ID's
     */
    public BungieMembership[] getMembershipsById(String id, BungieMembershipType type) {
        List<BungieMembership> bungieMemberships = new ArrayList<BungieMembership>();
        var membershipArray = HttpRequest.GET(JBA.getAPI_ROOT_PATH() + "/User/GetMembershipsById/" + id + "/" + type.getType()).getAsJsonArray("destinyMemberships");
        membershipArray.forEach(membership -> bungieMemberships.add(new Gson().fromJson(membership, BungieMembership.class)));
        return bungieMemberships.toArray(new BungieMembership[0]);
    }

    /**
     * @return Available Bungie Themes from GET Request.
     */
    public BungieTheme getAvailableThemes() {
        return new Gson().fromJson(HttpRequest.GET(JBA.getAPI_ROOT_PATH() + "/User/GetAvailableThemes"), BungieTheme.class);
    }
}
