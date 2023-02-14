package app.raidhub.JBA.user.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum BungieMembershipType {

    // I have no clue what Epic Games is atm.
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
