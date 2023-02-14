package app.raidhub.JBA.user.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Bungie Membership Types see: https://bungie-net.github.io/multi/schema_BungieMembershipType.html
 * TODO: Add support for Epic Games, cannot find current membership type for epic games on the bungie.net api website.
 */
@Getter
public enum BungieMembershipType {
    None(0, "NONE"),
    TigerXbox(1, "Xbox"),
    TigerPsn(2, "Psn"),
    TigerSteam(3, "Steam"),
    TigerBlizzard(4, "Blizzard"),
    TigerStadia(5, "Stadia"), // R.I.P Stadia
    TigerEgs(6, "Egs"), // I have no idea what this even is?
    TigerDemon(10, "10"), // DEMON HOURS!!
    BungieNext(254, "Bungie Next"),
    All(-1, "ALL");

    private int type;
    private String typeName;
    BungieMembershipType(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }
}
