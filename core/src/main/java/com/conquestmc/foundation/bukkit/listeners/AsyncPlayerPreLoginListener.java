package com.conquestmc.foundation.bukkit.listeners;

import com.conquestmc.foundation.API;
import com.conquestmc.foundation.CorePlayer;
import com.conquestmc.foundation.CorePlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class AsyncPlayerPreLoginListener implements Listener {
    @EventHandler
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        CorePlayerManager manager = (CorePlayerManager) API.getUserManager();
        CorePlayer user = manager.getUserDataDriver().findById(event.getUniqueId());
        if (user == null) {
            user = new CorePlayer(event.getUniqueId());
            manager.getUserDataDriver().create(user);
        }

        manager.getUsers().add(user);
    }
}
