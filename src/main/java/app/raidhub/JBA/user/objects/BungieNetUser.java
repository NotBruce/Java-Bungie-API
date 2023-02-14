package app.raidhub.JBA.user.objects;

import lombok.Data;

/**
 * Bungie.NET User Object
 */
@Data
public class BungieNetUser {

    public String membershipId;
    public String uniqueName;
    public boolean isDeleted;
    public String firstAccess;
    public String lastUpdate;
    public String psnDisplayName;
    public String locale;
    public String profilePicturePath;
    public String profileThemeName;
    public String userTitleDisplay;
    public String statusText;
    public String statusDate;
    public String steamDisplayName;
    public String twitchDisplayName;
    public String cachedBungieGlobalDisplayName;
    public short cachedBungieGlobalDisplayNameCode;
}
