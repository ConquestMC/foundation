package com.conquestmc.foundation.bungee.listeners;

import com.conquestmc.foundation.API;
import com.conquestmc.foundation.CorePlayer;
import com.conquestmc.foundation.CorePlayerManager;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerDisconnectListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerDisconnectEvent event) {
        CorePlayerManager userManager = (CorePlayerManager) API.getUserManager();
        CorePlayer user = (CorePlayer) userManager.findByUniqueId(event.getPlayer().getUniqueId());
        user.setOnline(false);

        userManager.getUserDataDriver().update(user);
        userManager.getUsers().remove(user);
    }
}
