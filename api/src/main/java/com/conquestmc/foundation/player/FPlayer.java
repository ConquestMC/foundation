package com.conquestmc.foundation.player;

import java.util.List;
import java.util.UUID;

public interface FPlayer {

    UUID getUUID();
    String getName();
    void update();
    boolean isOnline();
    FProfile getProfile(String name);
    List<FProfile> getAllProfiles();
    void setName(String name);

    boolean hasPermission(String permission);
    void givePermission(String permission);
    List<String> getPermissions();

    boolean isStaff();
    boolean isDonor();

    void giveDrachma(int amount);
    void givePoints(int amount);

}
