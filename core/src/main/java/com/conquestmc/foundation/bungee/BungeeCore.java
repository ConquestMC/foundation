package com.conquestmc.foundation.bungee;

import com.conquestmc.foundation.CoreFoundation;
import com.conquestmc.foundation.bungee.listeners.PlayerDisconnectListener;
import com.conquestmc.foundation.bungee.listeners.PostLoginListener;
import com.conquestmc.foundation.API;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeCore extends Plugin {

    @Override
    public void onLoad() {
        API.setFoundation(new CoreFoundation());
    }

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new PlayerDisconnectListener());
        getProxy().getPluginManager().registerListener(this, new PostLoginListener());
    }
}
