package com.conquestmc.foundation.player;



import com.google.common.collect.ImmutableList;

import java.util.UUID;

public interface FPlayerManager {

    FPlayer findByUniqueId(UUID uuid);
    FPlayer findByName(String name);
    ImmutableList<FPlayer> findAll();

    void update(FPlayer user);
}
