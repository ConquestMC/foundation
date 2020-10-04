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
        this.online = true;
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

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public List<FProfile> getAllProfiles() {
        return profiles;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean hasPermission(String permission) {
        FProfile perms = getProfile("permissions");
        if (perms == null) {
            return false;
        }

        List<String> permissions = (List<String>) perms.getOrDefault("permissionList", Lists.newArrayList());

        return permissions.contains(permission);
    }

    @Override
    public void givePermission(String permission) {
        FProfile permProfile = getProfile("permissions");

        if (permProfile == null)
            return;

        List<String> permissions = (List<String>) permProfile.getOrDefault("permissionList", Lists.newArrayList());
        permissions.add(permission);
        permProfile.set("permissionList", permissions);
        update();
    }

    @Override
    public List<String> getPermissions() {
        FProfile permProfile = getProfile("permissions");

        if (permProfile == null)
            return null;

        List<String> permissions = (List<String>) permProfile.getOrDefault("permissionList", Lists.newArrayList());
        return permissions;
    }

    @Override
    public boolean isStaff() {
        FProfile permProfile = getProfile("permissions");

        if (permProfile == null)
            return false;

        List<String> permissions = (List<String>) permProfile.getOrDefault("permissionList", Lists.newArrayList());


        return permissions.contains("rank.staff");
    }

    @Override
    public boolean isDonor() {
        FProfile permProfile = getProfile("permissions");

        if (permProfile == null)
            return false;

        List<String> permissions = (List<String>) permProfile.getOrDefault("permissionList", Lists.newArrayList());


        return permissions.contains("rank.donor");
    }

    @Override
    public void giveDrachma(int amount) {

    }

    @Override
    public void givePoints(int amount) {

    }
}
