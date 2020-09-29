package com.conquestmc.foundation.bukkit.listeners;

import com.conquestmc.foundation.API;
import com.conquestmc.foundation.player.FPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginListener implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        FPlayer user = API.getUserManager().findByUniqueId(event.getPlayer().getUniqueId());

        if (user == null)
            return;

        user.setName(event.getPlayer().getName());

    }
}