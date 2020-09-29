package com.conquestmc.foundation;

import com.conquestmc.foundation.data.DataObject;
import com.conquestmc.foundation.player.FPlayer;
import com.conquestmc.foundation.player.FProfile;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.UUID;

public class CorePlayer extends DataObject implements FPlayer {

    private final UUID uuid;
    private String name;
    private List<FProfile> profiles;
    private boolean online;

    public CorePlayer(UUID uuid) {
        this.id = uuid;
        this.uuid = uuid;
        this.name = "unknown";
        this.profiles = Lists.newArrayList();
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update() {
        API.getUserManager().update(this);
    }

    @Override
    public boolean isOnline() {
        return online;
    }

    @Override
    public FProfile getProfile(String name) {
        return this.profiles.stream().filter(profile -> profile.getProfileName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    public List<FProfile> getAllProfiles() {
        return profiles;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
