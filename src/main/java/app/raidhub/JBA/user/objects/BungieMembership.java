package app.raidhub.JBA.user.objects;

import app.raidhub.JBA.user.enums.BungieMembershipType;

/**
 * Bungie Memberships from a request
 * TODO: Possibly check for Epic Games?
 */
public class BungieMembership {

    public String LastSeenDisplayName;
    public BungieMembershipType LastSeenDisplayNameType;
    public String iconPath;
    public BungieMembershipType[] applicableMembershipTypes;
    public boolean isPublic;
    public BungieMembershipType membershipType;
    public String membershipId;
    public String displayName;
    public String bungieGlobalDisplayName;
    public short bungieGlobalDisplayNameCode;
}
