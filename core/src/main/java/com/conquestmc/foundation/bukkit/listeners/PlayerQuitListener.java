package com.conquestmc.foundation.bukkit.listeners;

import com.conquestmc.foundation.API;
import com.conquestmc.foundation.CorePlayer;
import com.conquestmc.foundation.CorePlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        CorePlayerManager userManager = (CorePlayerManager) API.getUserManager();
        CorePlayer user = (CorePlayer) userManager.findByUniqueId(event.getPlayer().getUniqueId());

        userManager.getUserDataDriver().update(user);
        userManager.getUsers().remove(user);

        event.setQuitMessage(null);
    }
}