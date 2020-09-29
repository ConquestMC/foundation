package com.conquestmc.foundation;

import com.conquestmc.foundation.data.CoreDataDriver;
import com.conquestmc.foundation.player.DataDriver;
import com.conquestmc.foundation.player.FPlayer;
import com.conquestmc.foundation.player.FPlayerManager;
import com.google.common.collect.ImmutableList;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class CorePlayerManager implements FPlayerManager {
    private final Set<FPlayer> users;
    private final DataDriver<CorePlayer> userDataDriver;

    public CorePlayerManager()
    {
        this.users = new LinkedHashSet<>();
        this.userDataDriver = new CoreDataDriver<>("localhost", 27017,"players", CorePlayer.class, null);
    }

    @Override
    public FPlayer findByUniqueId(UUID uuid)
    {
        return this.users.stream().filter(user -> user.getUUID().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public FPlayer findByName(String name)
    {
        return this.users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    public ImmutableList<FPlayer> findAll()
    {
        ImmutableList.Builder<FPlayer> immutableUsers = new ImmutableList.Builder<>();
        immutableUsers.addAll(this.users);
        return immutableUsers.build();
    }

    @Override
    public void update(FPlayer user)
    {
        this.userDataDriver.update((CorePlayer) user);
    }

    public DataDriver<CorePlayer> getUserDataDriver()
    {
        return this.userDataDriver;
    }

    public Set<FPlayer> getUsers()
    {
        return this.users;
    }
}
