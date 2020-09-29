package com.conquestmc.foundation;


import com.conquestmc.foundation.player.FPlayerManager;

public class CoreFoundation implements Foundation {

    private FPlayerManager playerManager;

    public CoreFoundation() {
        this.playerManager = new CorePlayerManager();
    }

    public FPlayerManager getPlayerManager() {
        return playerManager;
    }
}
